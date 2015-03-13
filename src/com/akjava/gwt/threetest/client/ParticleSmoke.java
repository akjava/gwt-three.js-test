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

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class ParticleSmoke extends AbstractDemo{

private Mesh mesh;

//original is here
//www.airtightinteractive.com/demos/cubes_three/
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		renderer.setClearColor(0xcccccc, 1);
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 0);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(1000,2000, 1500);//light.setPosition(5,5, 5);
		scene.add(light);
		
		final Mesh root=THREE.Mesh(THREE.PlaneBufferGeometry(50, 50), 
				THREE.MeshLambertMaterial(MeshLambertMaterialParameter.create().color(0x00ee88)
						));
		
		scene.add(root);
		mesh=root;
		
		
		Object3D group=THREE.Object3D();
		
		mesh.add(group);
		
		final EmitterSystem emitterSystem=new EmitterSystem();
		
		emitterSystem.setParent(group);
		emitterSystem.setVelocity(THREE.Vector3(0, 200.0/120, 0));
		emitterSystem.setVelocityRange(THREE.Vector3(100.0/120,0, 100.0/120));
		
		
		root.getRotation().set(Math.toDegrees(45),Math.toDegrees(45),Math.toDegrees(-45));
		
		
		//Particle particle=THREE.Particle(THREE.MeshLambertMaterial().color(0x00ee88).build());
		//particle.getScale().set(100, 100, 100);
		//scene.add(particle);
		
		
		cameraControle.setRotationX(0);
		cameraControle.setRotationZ(0);
		
		cameraControle.setPositionZ(1000);
	//	MainWidget.cameraRotation.setX(-90);
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
				try{
					
					emitterSystem.update();
					
					
					camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
					
					mesh.getRotation().set(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ());
				
					
					//camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
					//mesh.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()), Math.toRadians(MainWidget.cameraRotation.getY()), Math.toRadians(MainWidget.cameraRotation.getZ()));
				
				renderer.render(scene, camera);
				}catch(Exception e){
					GWT.log(e.getMessage());
					LogUtils.log(e.getMessage());
				}
				MainWidget.stats.end();
			}
		};
		startTimer(timer);
	}

	

	@Override
	public String getName() {
		return "ParticleSmoke";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
	@Override
	public boolean isSupportCanvas(){
		return false;
	}

}
