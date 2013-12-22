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

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.ImageUtils;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.MorphAnimMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class SimpleAnimation extends AbstractDemo{

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
		
		
		loader.load("models/animation.js", new JSONLoadHandler() {
			
			

			@Override
			public void loaded(Geometry geometry, JsArray<Material> ms) {
				Material material=THREE.MeshLambertMaterial().color(0xffffff).morphTargets(true).map(ImageUtils.loadTexture("img/uv.png")).build();
				animMesh = THREE.MorphAnimMesh(geometry, material);
				
				animMesh.setDuration(1000*5); //5sec
				animMesh.setMirroredLoop(true);//animation move forward and back
	
				animMesh.getScale().set(10, 10, 10 );
				scene.add(animMesh);
				GWT.log("loaded:");
			}
		});
		
		
		
		final Light light=THREE.DirectionalLight(0xeeeeee,2);
		light.setPosition(1, 1, 1);
		scene.add(light);
		
		scene.add(THREE.AmbientLight(0xcccccc));
		
		
	
		final int radius = 600;
		
		last = System.currentTimeMillis();
		Timer timer = new Timer(){
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
						
						last=tmp;
					}
				
				renderer.render(scene, camera);
				MainWidget.stats.update();
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		
		startTimer(timer);
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Simple Animation";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
