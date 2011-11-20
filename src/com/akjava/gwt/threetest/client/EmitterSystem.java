package com.akjava.gwt.threetest.client;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vertex;
import com.akjava.gwt.three.client.extras.ImageUtils;
import com.akjava.gwt.three.client.materials.ParticleBasicMaterial;
import com.akjava.gwt.three.client.materials.ParticleBasicMaterialBuilder;
import com.akjava.gwt.three.client.objects.ParticleSystem;

/**
 * TODO time base
 * @author aki
 *
 */
public class EmitterSystem {
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
	
	private ParticleBasicMaterialBuilder baseMaterial=THREE.ParticleBasicMaterial().opacity(1).transparent(true).
		depthTest(false).color(0x666666).size(baseSize).map(ImageUtils.loadTexture("img/particle2.png")).blending(THREE.NormalBlending);//
	
	
	Vector3[][] addVelocities;
	
	Vector3 wind=THREE.Vector3(0,0,0);

	Vector3 accel=THREE.Vector3(0,-0.5/120,0);
	//Vector3 accel=THREE.Vector3(0,-2.8/120,0); //spring
	
	
	private double changeOpacity=1.0/120;
	private double changeSize=150.0/120;
	ParticleSystem[] systems;
	int steps[];
	int index;
	Vector3 winds[]=new Vector3[particleSize];
	public void reset(int index){
		if(systems==null){
			systems=new ParticleSystem[maxStep];
			steps=new int[maxStep];
			addVelocities=new Vector3[maxStep][particleSize];
		}
		if(systems[index]==null){
			Geometry geometry=THREE.Geometry();
			for(int i=0;i<particleSize;i++){
				geometry.vertices().push(THREE.Vertex(THREE.Vector3(0, 0, 0)));
			}
			
			ParticleSystem system=THREE.ParticleSystem(geometry, baseMaterial.build());
			//system.setSortParticles(true);
			systems[index]=system;
			parent.add(system);
			
			
		}else{
			ParticleSystem system=systems[index];
			((ParticleBasicMaterial)system.materials().get(0)).setSize(baseSize);
			
			for(int i=0;i<particleSize;i++){
				Vertex vertex=system.getGeometry().vertices().get(i);
				vertex.getPosition().set(0, Math.random()*10, 0);
			}
			system.getGeometry().setDirtyVertices(true);
			
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
		//grouping
		/*
		for(int j=0;j<maxStep;j++){
			Vector3 move=
		for(int i=0;i<particleSize;i++){
		addVelocities[j][i]=move;
		}
		}
		*/
		
		}
	
	private double plusMinus(double value){
		return value*2*Math.random()-value;
	}
	
	public void update(){
		if(systems==null || systems[index]==null){
			reset(index);
		}
		
		for(int j=0;j<maxStep;j++){
		ParticleSystem system=systems[j];
		if(system==null){
			break;
		}
		Vector3 addAccel=THREE.Vector3(0, accel.getY()*steps[j], 0);
		for(int i=0;i<particleSize;i++){
			Vertex vertex=system.getGeometry().vertices().get(i);
			vertex.getPosition().addSelf(velocity);
			vertex.getPosition().addSelf(addVelocities[j][i]);
			vertex.getPosition().addSelf(wind);
			vertex.getPosition().addSelf(addAccel); //do slow
			
			//vertex.getPosition().addSelf(winds[i]);
		}
		system.getGeometry().setDirtyVertices(true);
		
		//change size and color
		((ParticleBasicMaterial)system.materials().get(0)).setSize(baseSize+changeSize*steps[j]);
		((ParticleBasicMaterial)system.materials().get(0)).setOpacity(Math.max(0, 1-changeOpacity*steps[j]));
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
