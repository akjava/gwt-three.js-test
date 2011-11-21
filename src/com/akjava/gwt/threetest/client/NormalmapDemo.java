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
import com.akjava.gwt.three.client.extras.ImageUtils;
import com.akjava.gwt.three.client.extras.ShaderUtils;
import com.akjava.gwt.three.client.extras.ShaderUtils.Shader;
import com.akjava.gwt.three.client.extras.ShaderUtils.Uniforms;
import com.akjava.gwt.three.client.extras.UniformUtils;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader.LoadHandler;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.MorphAnimMesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class NormalmapDemo extends AbstractDemo{

private MorphAnimMesh animMesh;
private long last;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		renderer.setClearColorHex(0x333333, 1);
		
		final Scene scene=THREE.Scene();
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 300, 0);
		final Vector3 target=THREE.Vector3(0, 150, 0);
		scene.add(camera);
		
		
		
		
		
		JSONLoader loader=THREE.JSONLoader();
		
		
		loader.load("models/men_boned.js", new LoadHandler() {
			
			

			@Override
			public void loaded(Geometry geometry) {
				Material material=THREE.MeshLambertMaterial().color(0xffffff).morphTargets(true).map(ImageUtils.loadTexture("img/uv.png")).build();
				//material=THREE.MeshFaceMaterial();
				//material.setMorphTargets(true);
				
				Shader shader=ShaderUtils.lib("normal");
				Uniforms uniforms=UniformUtils.clone(shader.uniforms());
				uniforms.set("tNormal", ImageUtils.loadTexture("img/normalmap.png"));
				
				uniforms.set("enableDiffuse", true);
				uniforms.setHex("uDiffuseColor", 0xff0000);
				uniforms.set("tDiffuse", ImageUtils.loadTexture("img/uv.png"));
				
				//material=THREE.ShaderMaterial().fragmentShader(shader.fragmentShader()).vertexShader(shader.vertexShader()).uniforms(uniforms).lights(true).morphTargets(true).build();
				
				animMesh = THREE.MorphAnimMesh(geometry, material);
				try{
				animMesh.compute();//try
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
				animMesh.setDuration(1000*5); //5sec
				animMesh.setMirrordLoop(true);//animation move forward and back
				//animMesh.getScale().set( 1.5, 1.5, 1.5 );
				animMesh.getScale().set( 5, 5, 5 );
				scene.add(animMesh);
				GWT.log("loaded:");
			}
		});
		
		
		
		final Light light=THREE.DirectionalLight(0xeeeeee,2);
		light.setPosition(1, 1, 1);
		scene.add(light);
		
		scene.add(THREE.AmbientLight(0xcccccc));
		
		
	//	MainWidget.cameraMove.setZ(-20);
		MainWidget.cameraMove.setZ(25);
	//	MainWidget.cameraRotation.setX(-90);
		final int radius = 600;
		
		last = System.currentTimeMillis();
		timer = new Timer(){
			double theta;
			public void run(){
				try{
					theta += 0.2;

					camera.getPosition().setX(radius * Math.sin( theta * Math.PI / 360 ));
					camera.getPosition().setZ(radius * Math.cos( theta * Math.PI / 360 ));
					camera.lookAt( target );
					
					if(animMesh!=null){
						//TODO clock
						long tmp=System.currentTimeMillis();
						long delta=tmp-last;
						animMesh.updateAnimation(delta);
						//animMesh.compute();//try
						last=tmp;
					}
				
				renderer.render(scene, camera);
				MainWidget.stats.update();
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		
		startTimer();
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Simple Animation";
	}

}
