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
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vertex;
import com.akjava.gwt.three.client.extras.ImageUtils;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.objects.ParticleSystem;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class ParticleDemo extends AbstractDemo{
private Timer timer;
private Mesh mesh;

//original is here
//www.airtightinteractive.com/demos/cubes_three/
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		
		renderer.setClearColorHex(0x333333, 1);
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 0);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(1000,2000, 1500);//light.setPosition(5,5, 5);
		scene.add(light);
		
		
		//scene.add(THREE.AmbientLight(0x888888));
		
		final int pcount=1800;
		final Geometry particles =  THREE.Geometry();
		//Material material=THREE.ParticleBasicMaterial().color(0xffffff).size(20).build();
		Material material=THREE.ParticleBasicMaterial().color(0xffffff).size(20).map(ImageUtils.loadTexture("img/particle.png"))
		.blending(THREE.AdditiveBlending).transparent(true).build();
		final Vector3[] velocity=new Vector3[pcount];
		for(int i=0;i<pcount;i++){
			int px= (int) (Math.random() * 500 - 250);
			int py= (int) (Math.random() * 500 - 250);
			int pz= (int) (Math.random() * 500 - 250);
			Vertex v=THREE.Vertex(THREE.Vector3(px, py, pz));
			particles.vertices().push(v);
			
			velocity[i]=THREE.Vector3(0, 0, -Math.random());
		}
		
		final ParticleSystem particleSystem=THREE.ParticleSystem(particles, material);
		particleSystem.setSortParticles(true);
		
		final Mesh root=THREE.Mesh(THREE.PlaneGeometry(500, 500), THREE.MeshLambertMaterial().color(0x00ee88).build());
		scene.add(root);
		mesh=root;
		
		mesh.add(particleSystem);
		
		
		
		root.setRotation(Math.toDegrees(45),Math.toDegrees(45),Math.toDegrees(-45));
		
		MainWidget.cameraRotation.setX(-45);
		MainWidget.cameraRotation.setZ(45);
		
	//	MainWidget.cameraMove.setZ(-20);
		MainWidget.cameraMove.setZ(1000);
	//	MainWidget.cameraRotation.setX(-90);
		timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
				try{
					
					particleSystem.getRotation().incrementZ(0.001);
					
					for(int i=0;i<pcount;i++){
						Vertex v=particles.vertices().get(i);
						if(v.getPosition().getZ()<-200){
							v.getPosition().setZ(200);
							velocity[i].setZ(0);
						}
						
						velocity[i].incrementZ(-Math.random() * .1);
				        
				       
				        v.getPosition().addSelf(
				        		velocity[i]);
					}
					
					particles.setDirtyVertices(true);//call if you move verticle
					
					camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
					mesh.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()), Math.toRadians(MainWidget.cameraRotation.getY()), Math.toRadians(MainWidget.cameraRotation.getZ()));
				
				renderer.render(scene, camera);
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		//timer.schedule(2000);
		timer.scheduleRepeating(1000/60);
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Particle";
	}
	

}
