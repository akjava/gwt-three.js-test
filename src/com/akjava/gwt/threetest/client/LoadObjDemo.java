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
import com.akjava.gwt.three.client.extras.loaders.JSONLoader;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader.LoadHandler;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;

public class LoadObjDemo extends AbstractDemo{
private Timer timer;
private Mesh mesh;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		renderer.setClearColorHex(0xcccccc, 1);
		
		final Scene scene=THREE.Scene();
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		
		
		
		JSONLoader loader=THREE.JSONLoader();
		
		loader.load("models/animation.js", new LoadHandler() {
			
			

			@Override
			public void loaded(Geometry geometry) {

				mesh = THREE.Mesh(geometry, THREE.MeshLambertMaterial().color(0xff0000).build());
				mesh.setPosition(0, 0, 0);
				mesh.setRotation(0, 0, 0);
				mesh.setScale(5,5,5);
				scene.add(mesh);
			}
		});
		
		
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		
		scene.add(light);
		
		scene.add(THREE.AmbientLight(0xcccccc));
		
		
		//default camera position
		MainWidget.cameraMove.setX(30);
		MainWidget.cameraMove.setY(70);
		MainWidget.cameraMove.setZ(200);
		
		timer = new Timer(){
			public void run(){
				try{
					camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
					//TODO change ui
					mesh.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()), Math.toRadians(MainWidget.cameraRotation.getY()), Math.toRadians(MainWidget.cameraRotation.getZ()));
				
				renderer.render(scene, camera);
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		
		timer.scheduleRepeating(1000/60);
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Load Obj";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
