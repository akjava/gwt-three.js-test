package com.akjava.gwt.threejsexamples.client.examples.animation.cloth;

import java.util.List;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.google.common.collect.Lists;
/**
 * @deprecated don't modify here
 * @author aki
 *
 */
public class ClothControler {
	private List<ClothData> cloths=Lists.newArrayList();
	
	private Mesh sphere;//TODO multiple
	
	public ClothControler(Mesh sphere) {
		super();
		this.sphere = sphere;
	}

	public void addClothData(ClothData data){
		data.getCloth().wind=wind;
		cloths.add(data);
	}
	
	public void update(double time){
		animateCloth(time);
		renderCloth();
	}
	
	private boolean wind;
	public void setWind(boolean value){
		this.wind=value;
		for(ClothData data:cloths){
			data.getCloth().wind=value;
		}
	}
	
	public void animateCloth(double time){
		double windStrength= Math.cos( time / 7000 ) * 20 + 40;;
		
		Vector3 windForce=THREE.Vector3().set(Math.sin( time / 2000 ), Math.cos( time / 3000 ), Math.sin( time / 1000 ) ).normalize().multiplyScalar( windStrength );
		for(ClothData data:cloths){
			Cloth2 cloth=data.getCloth();
			//cloth.wind=true;
			Geometry clothGeometry=data.getClothGeometry();
			
			
			cloth.windStrength =windStrength;
			cloth.windForce.copy(windForce);
			
			
			//arrow.setLength( cloth.windStrength );
			//arrow.setDirection( cloth.windForce );
			
			
			cloth.simulate(time,clothGeometry,sphere);//set otherwhere?
		}
	}
	
	public void renderCloth(){
		for(ClothData data:cloths){
			Cloth2 cloth=data.getCloth();
			Geometry clothGeometry=data.getClothGeometry();
			
			List<Cloth2.Particle> p = cloth.particles;

			for ( int i = 0, il = p.size(); i < il; i ++ ) {

				clothGeometry.getVertices().get(i).copy( p.get(i).position);

			}

			clothGeometry.computeFaceNormals();
			clothGeometry.computeVertexNormals();

			clothGeometry.setNormalsNeedUpdate(true);//clothGeometry.normalsNeedUpdate = true;
			clothGeometry.setVerticesNeedUpdate(true);//clothGeometry.verticesNeedUpdate = true;

			//sphere.getPosition().copy( cloth.ballPosition );//sphere.position.copy( ballPosition );
		}
	}
}
