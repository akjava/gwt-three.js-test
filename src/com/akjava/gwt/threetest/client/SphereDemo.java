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

import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class SphereDemo extends AbstractDemo{

	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		renderer.setClearColor(0xffffff, 1);
		
		
		
		
		
		final Scene scene=THREE.Scene();
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		cameraControle.setPositionZ(50);
		
		final Mesh mesh=THREE.Mesh(THREE.SphereGeometry(5, 16, 16), 
				THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color(0xff0000).wireframe(true)));
		scene.add(mesh);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		
		
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
				camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
				
				
				mesh.getRotation().gwtIncrementX(0.02);
				mesh.getRotation().gwtIncrementY(0.02);
				renderer.render(scene, camera);
				MainWidget.stats.end();
			}
		};
		startTimer(timer);
	}


	@Override
	public String getName() {
		return "Sphere";
	}
	
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.sphere().getText();
	}

}
