package com.akjava.gwt.threetest.client;

import com.akjava.gwt.three.client.java.ParticleBasicMaterialBuilder;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.materials.ParticleBasicMaterial;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Points;
import com.akjava.gwt.three.client.js.textures.Texture;

/**
 * TODO time base
 * @author aki
 *
 */
public class EmitterSystem {
	
	public EmitterSystem(){
		Texture texture=ImageUtils.loadTexture("img/particle4.png");
		//need for stop:Texture is not power of two. Texture.minFilter is set to THREE.LinearFilter or THREE.NearestFilter. ( undefined )
		texture.setMinFilter(THREE.Filters.LinearFilter());
		baseMaterial=THREE.ParticleBasicMaterial().transparent(true).
		depthTest(false).blending(THREE.Blending.NormalBlending()).color(0x666666).size(baseSize).map(texture);//

	}
	
	private Object3D parent;
	public Object3D getParent() {
		return parent;
	}

	public void setParent(Object3D parent) {
		this.parent = parent;
	}

	private int maxStep=120;
	
	
	private Vector3 velocityRange;
	public Vector3 getVelocityRange() {
		return velocityRange;
	}

	public void setVelocityRange(Vector3 velocityRange) {
		this.velocityRange = velocityRange;
	}

	public Vector3 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector3 velocity) {
		this.velocity = velocity;
	}

	private Vector3 velocity;
	
	
	
	private int particleSize=1;
	
	private double baseSize=50;
	
	/*
	private ParticleBasicMaterialBuilder baseMaterial=THREE.ParticleBasicMaterial().transparent(true).sizeAttenuation(false).
		depthTest(false).size(baseSize).blending(THREE.AdditiveBlending).map(ImageUtils.loadTexture("img/particles2.png"));//
	*/
	private ParticleBasicMaterialBuilder baseMaterial;
	
	Vector3[][] addVelocities;
	
	Vector3 wind=THREE.Vector3(0,0,0);

	Vector3 accel=THREE.Vector3(0,-0.5/120,0);
	//Vector3 accel=THREE.Vector3(0,-2.8/120,0); //spring
	
	
	private double changeOpacity=1.0/120;
	private double changeSize=150.0/120;
	Points[] systems;
	int steps[];
	int index;
	Vector3 winds[]=new Vector3[particleSize];
	public void reset(int index){
		if(systems==null){
			systems=new Points[maxStep];
			steps=new int[maxStep];
			addVelocities=new Vector3[maxStep][particleSize];
		}
		if(systems[index]==null){//initialize
			Geometry geometry=THREE.Geometry();
			for(int i=0;i<particleSize;i++){
				geometry.vertices().push(THREE.Vector3(0, 0, 0));
			}
			
			Points system=THREE.Points(geometry, baseMaterial.build());
			//system.setSortParticles(true);
			systems[index]=system;
			parent.add(system);
			
			
		}else{
			//
		
			Points system=systems[index];
			((ParticleBasicMaterial)system.getMaterial()).setSize(baseSize);
			
			for(int i=0;i<particleSize;i++){
				Vector3 vertex=system.getGeometry().vertices().get(i);
				vertex.set(0, 0, 0);
			}
			system.getGeometry().setVerticesNeedUpdate(true);
		
		}
		//addVelocities=new Vector3[maxStep][particleSize];
		//simple and boring
		for(int i=0;i<particleSize;i++){
		addVelocities[index][i]=THREE.Vector3(plusMinus(velocityRange.getX()), plusMinus(velocityRange.getY()),plusMinus(velocityRange.getZ()));
		}
		
		Vector3 addwind=THREE.Vector3(plusMinus(velocityRange.getX())*2, plusMinus(velocityRange.getY())*2,plusMinus(velocityRange.getZ())*2);
		//wind.addSelf(addwind);
		if(index%5==0){
		wind.set(wind.getX()/4*3+addwind.getX()/4, wind.getY()/4*3+addwind.getY()/4, wind.getZ()/4*3+addwind.getZ()/4);
		
		}
		for(int i=0;i<particleSize;i++){
			winds[i]=THREE.Vector3(plusMinus(velocityRange.getX())*5, plusMinus(velocityRange.getY())*5,plusMinus(velocityRange.getZ())*5);
		}
		
		}
	
	private double plusMinus(double value){
		return value*2*Math.random()-value;
	}
	
	public void update(){
		
		if(systems==null || systems[index]==null){
			reset(index);
		}
		
		for(int j=0;j<maxStep;j++){
		Points system=systems[j];
		if(system==null){
			break;
		}
		Vector3 addAccel=THREE.Vector3(0, accel.getY()*steps[j], 0);
		for(int i=0;i<particleSize;i++){
			Vector3 vertex=system.getGeometry().vertices().get(i);
			
			vertex.addSelf(velocity);
			vertex.addSelf(addVelocities[j][i]);
			vertex.addSelf(wind);
			vertex.addSelf(addAccel); //do slow
			
			//vertex.getPosition().addSelf(winds[i]);
		}
		system.getGeometry().setVerticesNeedUpdate(true);
		
		
		((ParticleBasicMaterial)system.getMaterial()).setSize(baseSize+changeSize*steps[j]);
		((ParticleBasicMaterial)system.getMaterial()).setOpacity(Math.max(0, 1-changeOpacity*steps[j]));
		
		steps[j]++;
		if(steps[j]==maxStep){
			reset(j);
			steps[j]=0;
		}
		}
		
		index++;
		if(index==maxStep){
			index=0;
		}
	}
}
