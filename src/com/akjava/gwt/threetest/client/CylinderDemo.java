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

public class CylinderDemo extends AbstractDemo{
private Timer timer;
	@SuppressWarnings("deprecation")
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		//renderer.setClearColor(0xff0000, 0.5);
		
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 50);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Mesh mesh=THREE.Mesh(THREE.CylinderGeometry(5, 5, 5,6), 
				THREEDep.MeshLambertMaterial().color(0xff0000).build());
		scene.add(mesh);
		
		final Mesh mesh2=THREE.Mesh(THREE.CylinderGeometry(5, 5, 5,15), 
				THREEDep.MeshLambertMaterial().color(0x00ff00).build());
		mesh2.setPosition(0, 10, 0);
		scene.add(mesh2);
		
		final Mesh mesh3=THREE.Mesh(THREE.CylinderGeometry(5, 1, 5,15), 
				THREEDep.MeshLambertMaterial().color(0x0000ff).build());
		mesh3.setPosition(0, -10, 0);
		scene.add(mesh3);
		
		final Mesh mesh4=THREE.Mesh(THREE.CylinderGeometry(5, 4.5, 5,5), 
				THREEDep.MeshLambertMaterial().color(0xffffff).build());
		mesh4.setPosition(-10,0, 0);
		scene.add(mesh4);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		scene.add(THREE.AmbientLight(0x330000));
		
		
		timer = new Timer(){
			public void run(){
				mesh.getRotation().gwtIncrementX(0.02);
				mesh.getRotation().gwtIncrementY(0.02);
				renderer.render(scene, camera);

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
		return "cylinder";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
