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
import com.akjava.gwt.three.client.gwt.materials.PointsMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.objects.Points;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class ParticleDemo extends AbstractDemo{

private Mesh mesh;

//original is here
//www.airtightinteractive.com/demos/cubes_three/
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		renderer.setClearColor(0x333333, 1);
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 0);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(1000,2000, 1500);//light.setPosition(5,5, 5);
		scene.add(light);
		
		final int pcount=1800;
		final Geometry particles =  THREE.Geometry();
		Texture texture=ImageUtils.loadTexture("img/particle.png");
		//need for stop:Texture is not power of two. Texture.minFilter is set to THREE.LinearFilter or THREE.NearestFilter. ( undefined )
		texture.setMinFilter(THREE.Filters.LinearFilter());
		
		/* TODO fix
		Material material=THREE.Points(
				PointsMaterialParameter.create().
				color(0xffffff).size(20).map(texture).blending(THREE.Blending.AdditiveBlending()).transparent(true).depthTest(false)
				)
		;
		*/
		Material material=null;
		
		final Vector3[] velocity=new Vector3[pcount];
		for(int i=0;i<pcount;i++){
			int px= (int) (Math.random() * 500 - 250);
			int py= (int) (Math.random() * 500 - 250);
			int pz= (int) (Math.random() * 500 - 250);
			Vector3 v=THREE.Vector3(px, py, pz);
			particles.vertices().push(v);
			
			velocity[i]=THREE.Vector3(0, 0, -Math.random());
		}
		
		final Points particleSystem=THREE.Points(particles, material);
		//particleSystem.setSortParticles(true); no need since r70
		
		final Mesh root=THREE.Mesh(THREE.PlaneBufferGeometry(500, 500), THREE.MeshLambertMaterial(
				MeshLambertMaterialParameter.create().color(0x00ee88))
				);
		scene.add(root);
		mesh=root;
		
		mesh.add(particleSystem);
		
		
		
		root.getRotation().set(Math.toDegrees(45),Math.toDegrees(45),Math.toDegrees(-45),Euler.XYZ);
		
		
		cameraControle.setRotationX(-45);
		cameraControle.setRotationZ(45);
		
		cameraControle.setPositionZ(1000);
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
				try{
					
					particleSystem.getRotation().gwtIncrementZ(0.001);
					
					for(int i=0;i<pcount;i++){
						Vector3 v=particles.vertices().get(i);
						if(v.getZ()<-200){
							v.setZ(200);
							velocity[i].setZ(0);
						}
						
						velocity[i].gwtIncrementZ(-Math.random() * .1);
				        
				       
				        v.add(
				        		velocity[i]);
					}
					
					particles.setVerticesNeedUpdate(true);//call if you move verticle
					
					camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
					
					mesh.getRotation().set(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ(),Euler.XYZ);
					
					
				renderer.render(scene, camera);
				}catch(Exception e){
					LogUtils.log(e.getMessage());
				}
				MainWidget.stats.end();
			}
		};
		startTimer(timer);
	}

	

	@Override
	public String getName() {
		return "Particle";
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
