package com.akjava.gwt.threejsexamples.client.examples.animation.cloth;

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Face3;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;



public class Cloth {
	/*
	 * Cloth Simulation using a relaxed constrains solver
	 */

	// Suggested Readings

	// Advanced Character Physics by Thomas Jakobsen Character
	// http://freespace.virgin.net/hugo.elias/models/m_cloth.htm
	// http://en.wikipedia.org/wiki/Cloth_modeling
	// http://cg.alexandra.dk/tag/spring-mass-system/
	// Real-time Cloth Animation http://www.darwin3d.com/gamedev/articles/col0599.pdf

	double DAMPING = 0.03;
	double DRAG = 1 - DAMPING;
	double MASS = .1;
	double restDistance = 25;


	private static int xSegs = 10; //
	private static int ySegs = 10; //

	//must be javascript function ParametricGeometry use this function
	JavaScriptObject clothFunction = plane(restDistance * xSegs, restDistance * ySegs);

	//var cloth = new Cloth(xSegs, ySegs);

	double GRAVITY = 981 * 1.4; // 
	Vector3 gravity = THREE.Vector3( 0, -GRAVITY, 0 ).multiplyScalar(MASS);


	double TIMESTEP = 18.0 / 1000;
	double TIMESTEP_SQ = TIMESTEP * TIMESTEP;

	int[] pins;


	boolean wind = true;
	double windStrength = 2;
	Vector3 windForce = THREE.Vector3(0,0,0);

	Vector3 ballPosition = THREE.Vector3(0, -45, 0);
	double ballSize = 60; //40

	Vector3 tmpForce = THREE.Vector3();

	Double lastTime;
	
	//for ParametricGeometry
	public native final JavaScriptObject plane(double width,double height)/*-{
	return function(u, v) {
			var x = (u-0.5) * width;
			var y = (v+0.5) * height;
			var z = 0;

			return new $wnd.THREE.Vector3(x, y, z);
		};
	}-*/;
	
	/*}
	public  ClothPartiicle createParticle(double x,double y,double z,double mass){
		ClothPartiicle particle=ClothPartiicle.createObject().cast();
		particle.setPosition(doClothFunction(x,y));
		return particle;
	}
	*/
	//horible implements
	public native final Vector3 doClothFunction(JavaScriptObject clothFunction,double x,double y)/*-{
	return clothFunction(x,y);
	}-*/;
	
	public class Constrain{
		private Particle p1;
		private Particle p2;
		private double distance;
		public Constrain(Particle p1, Particle p2, double distance) {
			super();
			this.p1 = p1;
			this.p2 = p2;
			this.distance = distance;
		}
	}
	public class Particle{
		Vector3 position;
		private Vector3 previous;
		private Vector3 original;
		//for after modify
		public Vector3 getOriginal() {
			return original;
		}

		private Vector3 a;
		private double mass;
		private double invMass;
		private Vector3 tmp;
		private Vector3 tmp2;
		public Particle(double x,double y,double z,double mass){
			position=doClothFunction(clothFunction,x, y);
			previous=doClothFunction(clothFunction,x, y);
			original=doClothFunction(clothFunction,x, y);
			a=THREE.Vector3(0, 0, 0);
			this.mass=mass;
			this.invMass=1.0 / mass;
			tmp=THREE.Vector3(0, 0, 0);
			tmp2=THREE.Vector3(0, 0, 0);
		}
		
		public void addForce(Vector3 force){
			this.a.add(
					this.tmp2.copy(force).multiplyScalar(this.invMass)
					);
		}
		
		public void integrate(double timesq){
			Vector3 newPos = this.tmp.subVectors(this.position, this.previous);
			newPos.multiplyScalar(DRAG).add(this.position);
			newPos.add(this.a.multiplyScalar(timesq));

			this.tmp = this.previous;
			this.previous = this.position;
			this.position = newPos;

			this.a.set(0, 0, 0);
		}
	}
	Vector3 diff = THREE.Vector3();

	public void satisifyConstrains(Particle p1,Particle p2,double distance) {
		diff.subVectors(p2.position, p1.position);
		double currentDist = diff.length();
		if (currentDist==0) return; // prevents division by 0
		Vector3 correction = diff.multiplyScalar(1 - distance/currentDist);
		Vector3 correctionHalf = correction.multiplyScalar(0.5);
		p1.position.add(correctionHalf);
		p2.position.sub(correctionHalf);
	}
	
	int w;
	int h;
	
	private List<Constrain> constrains=new ArrayList<Constrain>();
	public List<Particle> particles=new ArrayList<Particle>();
	
	
	public Cloth(){
		this(xSegs,ySegs);
	}
	
	List<int[]> pinsFormation=new ArrayList<int[]>();
	
	
	public void initPins(){//this is initialized based on Cloth's xSegs TODO link
		int center=w/2+1;
		pins= new int[]{center};

		pinsFormation.add( pins );

		//default all first line 
		pins = new int[w+1];
		for(int i=0;i<=w;i++){
			pins[i]=i;
		}
		
		pinsFormation.add( pins );

		pins = new int[]{ 0 };
		pinsFormation.add( pins );

		pins = new int[0]; // cut the rope ;)
		pinsFormation.add( pins );

		pins = new int[]{ 0, w }; // classic 2 pins
		pinsFormation.add( pins );

		pins = pinsFormation.get(1);	
	}
	
	
	public Cloth(int w,int h){
			this.w = w;
			this.h = h;

			initPins();
			
			
			// Create particles
			for (int v=0;v<=h;v++) {
				for (int u=0;u<=w;u++) {
					particles.add(
						new Particle((double)u/w, (double)v/h, 0, MASS)
					);
				}
			}
			
			

			// Structural

			/*
				particle exists v<=h & u<=w
			*/
			
			for (int v=0;v<h;v++) {
				for (int u=0;u<w;u++) {
					
					constrains.add(
							new Constrain(particles.get(index(u,v)), particles.get(index(u,v+1)), restDistance)
							);
					
					constrains.add(
							new Constrain(particles.get(index(u,v)), particles.get(index(u+1,v)), restDistance)
							);

				}
			}
			
			
			for (int u=w, v=0;v<h;v++) {
				
				constrains.add(
						new Constrain(particles.get(index(u,v)), particles.get(index(u,v+1)), restDistance)
						);
			}
			
			for (int v=h, u=0;u<w;u++) {
				
				constrains.add(
						new Constrain(particles.get(index(u,v)), particles.get(index(u+1,v)), restDistance)
						);
			}


		
	}
	private int index(int u,int v){
		return u + v * (w + 1);
	}
	
	
	public void simulate(double time,Geometry clothGeometry,Mesh sphereMesh) {
		if (lastTime==null) {
			lastTime = time;
			return;
		}
		//var i, il, particles, particle, pt, constrains, constrain;

		// Aerodynamics forces
		if (wind) {
			Face3 face;
			JsArray<Face3> faces = clothGeometry.getFaces();
			Vector3 normal;
			

			for (int i=0,il=faces.length();i<il;i++) {
				face = faces.get(i);
				normal = face.getNormal();

				tmpForce.copy(normal).normalize().multiplyScalar(normal.dot(windForce));
				particles.get(face.getA()).addForce(tmpForce);
				particles.get(face.getB()).addForce(tmpForce);
				particles.get(face.getC()).addForce(tmpForce);
			}
		}
		
		for (int i=0, il = particles.size()
				;i<il;i++) {
			Particle particle = particles.get(i);
			particle.addForce(gravity);

			particle.integrate(TIMESTEP_SQ);
		}

		// Start Constrains

		
		
		for (int i=0;i<constrains.size();i++) {
			Constrain constrain = constrains.get(i);
			satisifyConstrains(constrain.p1, constrain.p2, constrain.distance);
		}

		// Ball Constrains

		double now=System.currentTimeMillis();

		ballPosition.setZ(-Math.sin(now/600) * 90 ) ; 
		ballPosition.setX(Math.cos(now/400) * 70) ;

		if (sphereMesh.isVisible())
		for (int i=0;i<particles.size();i++) {
			Particle particle = particles.get(i);
			Vector3 pos = particle.position;
			diff.subVectors(pos, ballPosition);
			if (diff.length() < ballSize) {
				// collided
				diff.normalize().multiplyScalar(ballSize);
				pos.copy(ballPosition).add(diff);
			}
		}
		
		// Floor Constains
		for (int i=0;i<particles.size();i++) {
			Particle particle = particles.get(i);
			Vector3 pos = particle.position;
			if (pos.getY() < -250) {
				pos.setY(-250);
			}
		}

		// Pin Constrains
		
		for (int i=0;i<pins.length;i++) {
			int xy = pins[i];
			Particle p = particles.get(xy);
			p.position.copy(p.original);
			p.previous.copy(p.original);
		}
	}


	

}
