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
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class ShadowDemo extends AbstractDemo{
private Timer timer;
private WebGLRenderer renderer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		this.renderer=renderer;
		renderer.setShadowMapEnabled(true);
		
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 100);
		camera.getRotation().set(Math.toRadians(10),0, 0);
		
		
		final Scene scene=THREE.Scene();
		
		
		final Mesh mesh=THREE.Mesh(THREE.BoxGeometry(40, 5,40), 
				THREE.MeshLambertMaterial().color(0xeeeeee).build());
		mesh.getRotation().set(0, -Math.PI/2, 0);
		mesh.setPosition(0, -10, 0);
		scene.add(mesh);
		mesh.setCastShadow(true);
		mesh.setReceiveShadow(true);
		
		final Mesh mesh2=THREE.Mesh(THREE.BoxGeometry(6, 6,6), 
				THREE.MeshLambertMaterial().color(0xeff0000).build());
		scene.add(mesh2);
		mesh2.setPosition(0, 0, 0);
		mesh2.setReceiveShadow(true);
		mesh2.setCastShadow(true);
		
		
		final Mesh mesh3=THREE.Mesh(THREE.BoxGeometry(3, 3,10), 
				THREE.MeshLambertMaterial().color(0xe00ff00).build());
		scene.add(mesh3);
		mesh3.setPosition(5, 20, 15);
		//mesh2.setReceiveShadow(true);
		mesh3.setCastShadow(true);
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(100,200, 150);
		scene.add(light);
		light.setCastShadow(true);
		
		scene.add(THREE.AmbientLight(0xffffff));
		
		
		timer = new Timer(){
			public void run(){
				mesh2.getRotation().gwtIncrementX(0.02);
				mesh2.getRotation().gwtIncrementY(0.02);
				mesh3.getRotation().gwtIncrementX(0.02);
				mesh3.getRotation().gwtIncrementZ(0.02);
				renderer.render(scene, camera);

			}
		};
		timer.scheduleRepeating(1000/60);
	}

	@Override
	public void stop() {
		timer.cancel();
		renderer.setShadowMapEnabled(false);
	}
	

	@Override
	public String getHowToHtml() {
		return Bundles.INSTANCE.sphere().getText();
	}

	@Override
	public String getName() {
		return "Shadow";
	}

}
