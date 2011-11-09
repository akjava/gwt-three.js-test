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
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
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
		camera.setRotation(Math.toRadians(10),0, 0);
		
		
		final Scene scene=THREE.Scene();
		
		
		final Mesh mesh=THREE.Mesh(THREE.CubeGeometry(40, 5,40), 
				THREE.MeshLambertMaterial(0xeeeeee, false));
		mesh.setRotation(0, -Math.PI/2, 0);
		mesh.setPosition(0, -10, 0);
		scene.add(mesh);
		mesh.setCastShadow(true);
		mesh.setReceiveShadow(true);
		
		final Mesh mesh2=THREE.Mesh(THREE.CubeGeometry(6, 6,6), 
				THREE.MeshLambertMaterial(0xeff0000, false));
		scene.add(mesh2);
		mesh2.setPosition(0, 0, 0);
		mesh2.setReceiveShadow(true);
		mesh2.setCastShadow(true);
		
		
		final Mesh mesh3=THREE.Mesh(THREE.CubeGeometry(3, 3,10), 
				THREE.MeshLambertMaterial(0xe00ff00, false));
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
				mesh2.getRotation().incrementX(0.02);
				mesh2.getRotation().incrementY(0.02);
				mesh3.getRotation().incrementX(0.02);
				mesh3.getRotation().incrementZ(0.02);
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
	public String getName() {
		return "Shadow";
	}

}
