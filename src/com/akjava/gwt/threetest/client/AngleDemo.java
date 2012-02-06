/*
 * 
 * CCD-IK
 * based on Inverse kinematics and geometric constraints for articulated figure manipulation
 * http://summit.sfu.ca/item/5706
 * and
 * http://www.tmps.org/index.php?CCD-IK%20and%20Particle-IK
 * 
 * Copyright (C) 2011-2012 aki@akjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.akjava.gwt.threetest.client;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.gwt.GWTGeometryUtils;
import com.akjava.gwt.three.client.gwt.GWTThreeUtils;
import com.akjava.gwt.three.client.gwt.ThreeLog;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class AngleDemo extends AbstractDemo{
private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		final Scene scene=THREE.Scene();
	
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 100);
		
		scene.add(camera);
		
		
		Light pointLight = THREE.PointLight(0xffffff);
		pointLight.setPosition(0, 10, 300);
		scene.add(pointLight);
		
		
		
		
		
		
		root=THREE.Object3D();
		scene.add(root);
		
		rootMesh = THREE.Mesh(THREE.CubeGeometry(.5, .5, .5), 
				THREE.MeshBasicMaterial().color(0x0000ff).build());
		root.add(rootMesh);
		
		Mesh mesh1=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x00ff00).build());
		mesh1.setPosition(targetPos);
		root.add(mesh1);
		root.add(GWTGeometryUtils.createLineMesh(root.getPosition(), targetPos, 0xcccccc));
		
		Mesh mesh2=THREE.Mesh(THREE.CubeGeometry(.5, .5, .5), 
				THREE.MeshBasicMaterial().color(0xff0000).build());
		mesh2.setPosition(jointPos);
		root.add(mesh2);
		root.add(GWTGeometryUtils.createLineMesh(root.getPosition(), jointPos, 0xcccccc));
		
		log("joint-angle:"+ThreeLog.get(posToDegreeAngle(jointPos)));
		log("target-angle:"+ThreeLog.get(posToDegreeAngle(targetPos)));
		
		//DO-X
		double angleXJoint=Math.atan2(jointPos.getZ(),jointPos.getY());
		double angleXTarget=Math.atan2(targetPos.getZ(),targetPos.getY());
		log("target-angle:"+Math.toDegrees(angleXTarget));
		double diffX=angleXTarget-angleXJoint;
		
		Matrix4 mxX=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(diffX, 0, 0));
		Vector3 newPosX=jointPos.clone();
		mxX.multiplyVector3(newPosX);
		
		Mesh meshX=THREE.Mesh(THREE.CubeGeometry(.5, .5, .5), 
				THREE.MeshBasicMaterial().color(0x00ffff).build());
		meshX.setPosition(newPosX);
		double angleXMovec=Math.atan2(newPosX.getZ(),newPosX.getY());
		log("newpos-angle:"+Math.toDegrees(angleXMovec));
		root.add(meshX);
		//root.add(GWTGeometryUtils.createLineMesh(root.getPosition(), newPosX, 0xcccccc));
		log("angleX-moved:"+ThreeLog.get(posToDegreeAngle(newPosX)));
		//DO-Y
		double angleYJoint=Math.atan2(newPosX.getX(),newPosX.getZ());
		double angleYTarget=Math.atan2(targetPos.getX(),targetPos.getZ());
		log("target-angleY:"+Math.toDegrees(angleYTarget));
		double diffY=angleYTarget-angleYJoint;
		
		
		
		
		
		Matrix4 mxY=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, diffY, 0));
		Vector3 newPosY=newPosX.clone();
		mxY.multiplyVector3(newPosY);
		
		Mesh meshY=THREE.Mesh(THREE.CubeGeometry(.75, .75, .75), 
				THREE.MeshBasicMaterial().color(0x00ffff).build());
		meshY.setPosition(newPosY);
		double angleYMoved=Math.atan2(newPosY.getX(),newPosY.getZ());
		log("newpos-angle:"+Math.toDegrees(angleYMoved));
		
	
		
		root.add(meshY);
		//root.add(GWTGeometryUtils.createLineMesh(root.getPosition(), newPosY, 0xcccccc));
		log("angleY-moved:"+ThreeLog.get(posToDegreeAngle(newPosY)));
		
		//DO-Z
		double angleJoint=Math.atan2(newPosY.getY(), newPosY.getX());
		
		double angleTarget=Math.atan2(targetPos.getY(), targetPos.getX());
		log("target-angle:Z"+Math.toDegrees(angleTarget));
		double diff=angleTarget-angleJoint;
		
		Matrix4 mx=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, 0, diff));
		Vector3 newPosZ=newPosY.clone();
		mx.multiplyVector3(newPosZ);
		
		Mesh meshZ=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x00ffff).build());
		meshZ.setPosition(newPosZ);
		double angleZNew=Math.atan2(newPosZ.getY(), newPosZ.getX());
		log("newpos-angle:"+Math.toDegrees(angleZNew));
		
		root.add(meshZ);
		root.add(GWTGeometryUtils.createLineMesh(root.getPosition(), newPosZ, 0xcccccc));
		
		
		
		
		log("angleZ-moved:"+ThreeLog.get(posToDegreeAngle(newPosZ)));
		
		
		Vector3 diffAngle=getTwoPointAngle(jointPos,targetPos);
		log("diff-angle:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(diffAngle)));
		
		Mesh meshFinal=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x333333).build());
		
		
		
		
		Vector3 jAngle=getPointAngle(jointPos);
		log("jAngle:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(jAngle)));
		Vector3 finalPos=jointPos.clone();
		log("final-pos:"+ThreeLog.get(finalPos));
		Vector3 jointAngle=GWTThreeUtils.degreeToRagiant(posToDegreeAngle(jointPos));
		
		log("jposAngle:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(jointAngle)));
		
		diffAngle.addSelf(jAngle);
		Matrix4 finalMatrix=GWTThreeUtils.rotationToMatrix4(diffAngle);
		
		log(GWTThreeUtils.rotationToMatrix4(diffAngle));
		
		
		
		/*
		Matrix4 mX=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(diffAngle.getX(), 0, 0));
		Matrix4 mY=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, diffAngle.getY(), 0));
		Matrix4 mZ=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, 0, diffAngle.getZ()));
		
		mX.multiplySelf(mY);
		mX.multiplySelf(mZ);
		log(mX);
		*/
		
		
		
		//Vector3 atanAngle=getAtanAngle(jointPos,targetPos);
		//log("atanAngle:"+ThreeLog.get(GWTThreeUtils.radiantToDegree(atanAngle)));
		//Matrix4 atanMatrix=GWTThreeUtils.rotationToMatrix4(atanAngle);
		
		finalMatrix.multiplyVector3(finalPos);
		meshFinal.setPosition(finalPos);
		//meshFinal.setRotation(GWTThreeUtils.degreeToRagiant(newAngle));
		root.add(meshFinal);
		
		
		Vector3 mAngle=getPointAngle(targetPos);
		Matrix4 mmx=GWTThreeUtils.rotationToMatrix4(mAngle);
		Vector3 line=THREE.Vector3(0,15,0);
		mmx.multiplyVector3(line);
		Mesh mm=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x888888).build());
		root.add(mm);
		mm.setPosition(line);
		
		timer = new Timer(){
			public void run(){
				root.setRotation(Math.toRadians(angleX),Math.toRadians(angleY),Math.toRadians(0));
				renderer.render(scene, camera);
				}
		};
		timer.scheduleRepeating(1000/60);
	}
	
	
	public Vector3 getAtanAngle(Vector3 jointPos,Vector3 targetPos){
		//DO-X
		double angleXJoint=Math.atan2(jointPos.getZ(),jointPos.getY());
		double angleXTarget=Math.atan2(targetPos.getZ(),targetPos.getY());
		double diffX=angleXTarget-angleXJoint;
		
		Matrix4 mxX=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(diffX, 0, 0));
		Vector3 newPosX=jointPos.clone();
		mxX.multiplyVector3(newPosX);
		
		//DO-Y
		double angleYJoint=Math.atan2(jointPos.getX(),jointPos.getZ());
		double angleYTarget=Math.atan2(targetPos.getX(),targetPos.getZ());
		double diffY=angleYTarget-angleYJoint;
		Matrix4 mxY=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, diffY, 0));
		Vector3 newPosY=newPosX;
		mxY.multiplyVector3(newPosY);
		
		//DO-Z
		double angleJoint=Math.atan2(jointPos.getY(), jointPos.getX());
		double angleTarget=Math.atan2(targetPos.getY(), targetPos.getX());
		double diffZ=angleTarget-angleJoint;
		
		Matrix4 mx=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, 0, diffZ));
		Vector3 newPosZ=newPosY;
		mx.multiplyVector3(newPosZ);
		
		log("debug:"+ThreeLog.get(posToDegreeAngle(newPosZ)));
		
		return THREE.Vector3(diffX,diffY,diffZ);
}
	
	public Vector3 getPointAngle(Vector3 jointPos){
		//DO-X
		double angleXJoint=Math.atan2(jointPos.getZ(),jointPos.getY());
		
		double diffX=angleXJoint;
		
		Matrix4 mxX=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(diffX, 0, 0));
		Vector3 newPosX=jointPos.clone();
		mxX.multiplyVector3(newPosX);
		
		//DO-Y
		double angleYJoint=Math.atan2(newPosX.getX(),newPosX.getZ());
		
		double diffY=angleYJoint;
		Matrix4 mxY=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, diffY, 0));
		Vector3 newPosY=newPosX;
		mxY.multiplyVector3(newPosY);
		
		//DO-Z
		double angleJoint=Math.atan2(newPosY.getY(), newPosY.getX());
		
		double diffZ=angleJoint;
		
		Matrix4 mx=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, 0, diffZ));
		Vector3 newPosZ=newPosY;
		mx.multiplyVector3(newPosZ);
		
		log("debug:"+ThreeLog.get(posToDegreeAngle(newPosZ)));
		
		return THREE.Vector3(diffX,diffY,diffZ);
}
	
	/**
	 * MatrixÇ…ïœä∑Ç≈Ç´Ç»Ç¢ÅA
	 * @param jointPos
	 * @param targetPos
	 * @return
	 */
	public Vector3 getTwoPointAngle(Vector3 jointPos,Vector3 targetPos){
				//DO-X
				double angleXJoint=Math.atan2(jointPos.getZ(),jointPos.getY());
				double angleXTarget=Math.atan2(targetPos.getZ(),targetPos.getY());
				double diffX=angleXTarget-angleXJoint;
				
				Matrix4 mxX=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(diffX, 0, 0));
				Vector3 newPosX=jointPos.clone();
				mxX.multiplyVector3(newPosX);
				
				//DO-Y
				double angleYJoint=Math.atan2(newPosX.getX(),newPosX.getZ());
				double angleYTarget=Math.atan2(targetPos.getX(),targetPos.getZ());
				double diffY=angleYTarget-angleYJoint;
				Matrix4 mxY=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, diffY, 0));
				Vector3 newPosY=newPosX;
				mxY.multiplyVector3(newPosY);
				
				//DO-Z
				double angleJoint=Math.atan2(newPosY.getY(), newPosY.getX());
				double angleTarget=Math.atan2(targetPos.getY(), targetPos.getX());
				double diffZ=angleTarget-angleJoint;
				
				Matrix4 mx=GWTThreeUtils.rotationToMatrix4(THREE.Vector3(0, 0, diffZ));
				Vector3 newPosZ=newPosY;
				mx.multiplyVector3(newPosZ);
				
				log("debug:"+ThreeLog.get(posToDegreeAngle(newPosZ)));
				
				return THREE.Vector3(diffX,diffY,diffZ);
	}
	
	public Vector3 posToDegreeAngle(Vector3 pos){
		double x=Math.atan2(pos.getZ(),pos.getY());
		double y=Math.atan2(pos.getX(),pos.getZ());
		double z=Math.atan2(pos.getY(),pos.getX());
		return THREE.Vector3(Math.toDegrees(x),Math.toDegrees(y),Math.toDegrees(z));
	}

	private Object3D root;
	

	Vector3 targetPos=THREE.Vector3(-12, -15, 21);
	Vector3 jointPos=THREE.Vector3(5, 10, 0);

	private Mesh rootMesh;


	int angleX=0;
	int angleY=0;
	@Override
	public void onMouseMove(MouseMoveEvent event) {
	if(!mouseDown){
		return;
	}
	int diffX=event.getX()-mouseDownX;
	int diffY=event.getY()-mouseDownY;
	mouseDownX=event.getX();
	mouseDownY=event.getY();
	
	angleX+=diffY;
	angleY+=diffX;
	}
	
	protected boolean mouseDown;
	
	protected int mouseDownX;
	protected int mouseDownY;
	@Override
	public void onMouseDown(MouseDownEvent event) {
		mouseDown=true;
		mouseDownX=event.getX();
		mouseDownY=event.getY();
	}
	@Override
	public void onMouseUp(MouseUpEvent event) {
		mouseDown=false;
	}
	
	@Override
	public void onMouseOut(MouseOutEvent event) {
		mouseDown=false;
	}
	@Override
	public String getName() {
		return "Angle test";
	}

}
