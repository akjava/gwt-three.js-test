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
import com.akjava.gwt.three.client.core.Intersect;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.core.Ray;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.gwt.GWTGeometryUtils;
import com.akjava.gwt.three.client.gwt.GWTThreeUtils;
import com.akjava.gwt.three.client.gwt.ThreeLog;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class DragDemo extends AbstractDemo{
private Timer timer;

private Mesh plane;

private Camera camera;
private Scene scene;
private Object3D root;
private double zoom=100;
JsArray<Object3D> meshs=(JsArray<Object3D>) JsArray.createArray();
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		scene=THREE.Scene();
	
		
		camera=THREE.PerspectiveCamera(70,(double)width/height,1,10000);
		camera.getPosition().set(0, 0, zoom);
		
		scene.add(camera);
		
		root=THREE.Object3D();
		scene.add(root);
		
		root.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(-2000, 0, 0), THREE.Vector3(2000, 0, 0), 0xff0000));
		root.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(0, -2000, 0), THREE.Vector3(0, 2000, 0), 0x00ff00));
		root.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(0, 0, -2000), THREE.Vector3(0, 0, 2000), 0x0000ff));
		
		Light pointLight = THREE.PointLight(0xffffff);
		pointLight.setPosition(0, 10, 300);
		scene.add(pointLight);
		
		plane=THREE.Mesh(THREE.PlaneGeometry(10000, 10000, 20, 20), THREE.MeshBasicMaterial().color(0xffff00).wireFrame().build());
		root.add(plane);
		//plane.setVisible(false);
		/*
		for(int i=0;i<36;i++){
			Vector3 pos=THREE.Vector3(0,0,100);
			Matrix4 mx=GWTThreeUtils.degitRotationToMatrix4(0, i*10, 0);
			mx.multiplyVector3(pos);
			Object3D mesh =  THREE.Mesh(THREE.CubeGeometry(10,10,10), THREE.MeshBasicMaterial().color(0x00ffff).build());
			mesh.setPosition(pos);
			root.add(mesh);
		}
		*/
		Object3D mesh =  THREE.Mesh(THREE.CubeGeometry(50,50,50), THREE.MeshBasicMaterial().color(0x00ff00).build());
		root.add(mesh);
		meshs.push(mesh);
		
		//mesh.setPosition(THREE.Vector3(50, 50, 50));
		timer = new Timer(){
			public void run(){
				//camera.setRotation(Math.toRadians(angleX),Math.toRadians(angleY),Math.toRadians(0));
				renderer.render(scene, camera);
				
			}
		};
		timer.scheduleRepeating(1000/60);
	}
	
	Projector projector=THREE.Projector();
	
	Vector3 zero=THREE.Vector3(0, 0, 0);
	private int angleX,angleY;
	@Override
	public void onMouseMove(MouseMoveEvent event) {
	int diffX=event.getX()-mouseDownX;
	int diffY=event.getY()-mouseDownY;
	mouseDownX=event.getX();
	mouseDownY=event.getY();
	
	if(event.getNativeButton()==NativeEvent.BUTTON_MIDDLE){
	angleX+=diffY;
	angleY+=diffX;
	
	angleX%=360;
	angleY%=360;
	log(angleX+","+angleY);
	Matrix4 mx=GWTThreeUtils.degitRotationToMatrix4(angleX, angleY, 0);	
	camera.setPosition(mx.multiplyVector3(THREE.Vector3(0, 0, zoom)));
	
	camera.lookAt(zero);
	plane.lookAt(camera.getPosition());
	return;
	}
	
	
	if(selectedObject!=null){
		Ray ray=projector.gwtCreateRay(event.getX(), event.getY(), width, height, camera);
		JsArray<Intersect> intersects = ray.intersectObject( plane );
		selectedObject.getPosition().copy( intersects.get(0).getPoint().subSelf( offset ) );
		
		log("newPos:"+ThreeLog.get(selectedObject.getPosition()));
		
		plane.lookAt(camera.getPosition());
		return;
	}
	
	
	
	}
	
	protected boolean mouseDown;
	
	protected int mouseDownX;
	protected int mouseDownY;
	
	private Object3D selectedObject;
	private Vector3 offset=THREE.Vector3();
	@Override
	public void onMouseDown(MouseDownEvent event) {
		mouseDown=true;
		mouseDownX=event.getX();
		mouseDownY=event.getY();
		
		double mouseX=((double)event.getX()/width)*2-1;
		double mouseY=-((double)event.getY()/height)*2+1;;
		
		if(event.getNativeButton()==NativeEvent.BUTTON_MIDDLE){
			return;
		}
		
		Vector3 vector =  THREE.Vector3( mouseX, mouseY, 0.5 );
		projector.unprojectVector( vector, camera );
		log("mouse:"+mouseX+","+mouseY);
		log("unprojectVector:"+ThreeLog.get(vector));
		
		Ray ray=THREE.Ray(camera.getPosition(), vector.subSelf( camera.getPosition() ).normalize());
		
		JsArray<Intersect> intersects=ray.intersectObjects(meshs);
		
		
		
		if(intersects.length()>0){
			selectedObject=intersects.get(0).getObject();
			
			plane.getPosition().copy( selectedObject.getPosition() );
			plane.lookAt(camera.getPosition());
			
			JsArray<Intersect> pintersects=ray.intersectObject(plane);
			log("plain:"+ThreeLog.get(pintersects.get(0).getPoint()));
			
			offset.copy(pintersects.get(0).getPoint()).subSelf(plane.getPosition());
			
		}
		
		
	}
	@Override
	public void onMouseUp(MouseUpEvent event) {
		mouseDown=false;
		
		selectedObject=null;
	}
	
	@Override
	public void onMouseOut(MouseOutEvent event) {
		mouseDown=false;
	}
	@Override
	public  void onMouseWheel(MouseWheelEvent event){
		zoom+=event.getDeltaY();
		Matrix4 mx=GWTThreeUtils.degitRotationToMatrix4(angleX, angleY, 0);	
		camera.setPosition(mx.multiplyVector3(THREE.Vector3(0, 0, zoom)));
	};


	@Override
	public String getName() {
		return "Drag Object";
	}

}
