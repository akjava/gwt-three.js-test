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
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class QuotaViewDemo extends AbstractDemo{
private Timer timer;
private Mesh mesh;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		//renderer.setClearColor(0x333333, 1);
		renderer.setShadowMapEnabled(true);
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 0);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(100,200, 150);//light.setPosition(5,5, 5);
		light.setCastShadow(true);
		scene.add(light);
		
		
		scene.add(THREE.AmbientLight(0x888888));
		
		
		
		final Mesh root=THREE.Mesh(THREE.PlaneBufferGeometry(8, 8), THREEDep.MeshBasicMaterial().color(0xff0000).wireFrame().build());
		scene.add(root);
		mesh=root;
		
		for(int x=0;x<4;x++){
			for(int y=0;y<4;y++){
		Mesh plain=THREE.Mesh(THREE.PlaneBufferGeometry(4, 4), THREEDep.MeshBasicMaterial().color(0x00ff00).build());
		root.add(plain);
		plain.setPosition(-2+x*4, -2+y*4,0);
		plain.setReceiveShadow(true);
		
		Mesh box=THREE.Mesh(THREE.BoxGeometry(2, 2, 4), THREEDep.MeshLambertMaterial().color(0x0000ff).build());
		box.setCastShadow(true);
		plain.add(box);
		box.setPosition(1,1, 2);
		}
		}
		
		JSONLoader loader=THREE.JSONLoader();
		
		loader.load("models/two5.js", new JSONLoadHandler() {
			
			

			@Override
			public void loaded(Geometry geometry, JsArray<Material> ms) {
				Mesh obj = THREE.Mesh(geometry, THREE.MeshFaceMaterial(null));
				obj.setPosition(-3, -3,0);
				root.add(obj);
				obj.getRotation().set(Math.toRadians(90), Math.toRadians(180-45),0);
				
				
			}
		});
		
		
		
		
		root.getRotation().set(Math.toDegrees(45),Math.toDegrees(45),Math.toDegrees(-45));
		
		MainWidget.cameraRotation.setX(-45);
		MainWidget.cameraRotation.setZ(45);
		
	//	MainWidget.cameraMove.setZ(-20);
		MainWidget.cameraMove.setZ(25);
	//	MainWidget.cameraRotation.setX(-90);
		timer = new Timer(){
			public void run(){
				try{
					camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
					
					
					mesh.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()), Math.toRadians(MainWidget.cameraRotation.getY()), Math.toRadians(MainWidget.cameraRotation.getZ()));
				
				//cancel();
				if(mesh!=null){
				//mesh.getRotation().incrementZ(0.02);
				//mesh.getRotation().incrementZ(0.02);
				}
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
		return "Quoter View";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
