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
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class ParticleDemo2 extends AbstractDemo{

private Mesh mesh;

//original is here
//www.airtightinteractive.com/demos/cubes_three/
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		
		renderer.setClearColorHex(0xcccccc, 1);
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 0);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(1000,2000, 1500);//light.setPosition(5,5, 5);
		scene.add(light);
		
		
		
		
		final Mesh root=THREE.Mesh(THREE.PlaneGeometry(50, 50), THREE.MeshLambertMaterial().color(0x00ee88).build());
		scene.add(root);
		mesh=root;
		
		
		Object3D group=THREE.Object3D();
		
		mesh.add(group);
		
		final EmitterSystem emitterSystem=new EmitterSystem();
		emitterSystem.setParent(group);
		emitterSystem.setVelocity(THREE.Vector3(0, 200.0/120, 0));
		emitterSystem.setVelocityRange(THREE.Vector3(100.0/120,0, 100.0/120));
		
		
		root.setRotation(Math.toDegrees(45),Math.toDegrees(45),Math.toDegrees(-45));
		
		
		//Particle particle=THREE.Particle(THREE.MeshLambertMaterial().color(0x00ee88).build());
		//particle.getScale().set(100, 100, 100);
		//scene.add(particle);
		
		MainWidget.cameraRotation.setX(0);
		MainWidget.cameraRotation.setZ(0);
		
	//	MainWidget.cameraMove.setZ(-20);
		MainWidget.cameraMove.setZ(1000);
	//	MainWidget.cameraRotation.setX(-90);
		timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
				try{
					
					emitterSystem.update();
					
					camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
					mesh.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()), Math.toRadians(MainWidget.cameraRotation.getY()), Math.toRadians(MainWidget.cameraRotation.getZ()));
				
				renderer.render(scene, camera);
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		timer.scheduleRepeating(1000/60);
		//timer.schedule(2000);
		
	}

	

	@Override
	public String getName() {
		return "Smoke";
	}
	

}
