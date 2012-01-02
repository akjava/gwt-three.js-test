/*
 * Copyright (C) 2011 aki@akjava.com
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
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class BoneDemo extends AbstractDemo{
private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		
	
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 50);
		
		
		final Scene scene=THREE.Scene();
		Light pointLight = THREE.PointLight(0xffffff);
		pointLight.setPosition(0, 10, 300);
		scene.add(pointLight);
		
		root=THREE.Object3D();
		scene.add(root);
		
		
		
		final Mesh mesh=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0xff0000).build());
		root.add(mesh);
		
		
		//00
		
		final Mesh mesh2=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x00ff00).build());
		root.add(mesh2);
		
		Vector3 point1=THREE.Vector3(5, 10, 0);
		root.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(), point1.clone(),0));
		mesh.lookAt(point1);
		Matrix4 tmp=THREE.Matrix4();
		tmp.setRotationFromEuler(mesh.getRotation(), "XYZ");
		
		log(point1);
		mesh2.setPosition(point1);
		
		
		final Mesh tmpMesh=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x000000).build());
		root.add(tmpMesh);
		point1.multiplyScalar(0.5);
		tmpMesh.setPosition(point1);
		log(point1);
		
		final Mesh tmp2Mesh=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x000000).build());
		root.add(tmp2Mesh);
		point1.multiplyScalar(0.5);
		tmp2Mesh.setPosition(point1);
		log(point1);
		
		double thera=Math.atan2(10, 5);//
		double theraY=Math.atan2(-15, 10);//
		double theraZ=Math.atan2(5, -15);//
		
		Matrix4 mx=THREE.Matrix4();
		mx.setRotationZ(thera);
		
		Matrix4 m2=THREE.Matrix4();
		m2.setRotationX(theraY);
		mx.multiply(mx, m2);
		
		Matrix4 m3=THREE.Matrix4();
		m3.setRotationY(theraZ);
		mx.multiply(mx, m3);
		
		Matrix4 foward=THREE.Matrix4();
		//foward.setTranslation(0, 0,10);
		//mx.multiply(mx,foward);
		
		Vector3 newPos=THREE.Vector3();//Z is right
		newPos.set(0,0,15);
		//tmp.multiplyVector3(newPos);
		
		
		
		
		final Mesh mesh3=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshBasicMaterial().color(0x0000ff).build());
		root.add(mesh3);
		mesh3.setPosition(newPos);
		
		
		root.add(THREE.Line(GWTGeometryUtils.createLineGeometry(THREE.Vector3(), point1),THREE.LineBasicMaterial().color(0x888888).build()));
		root.add(THREE.Line(GWTGeometryUtils.createLineGeometry(THREE.Vector3(), newPos),THREE.LineBasicMaterial().color(0x888888).build()));
		
		
		
		timer = new Timer(){
			public void run(){
				root.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()),Math.toRadians(MainWidget.cameraRotation.getY()),Math.toRadians(MainWidget.cameraRotation.getZ()));
				renderer.render(scene, camera);

			}
		};
		timer.scheduleRepeating(1000/60);
	}

	private Object3D root;
	
	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Bone";
	}

}
