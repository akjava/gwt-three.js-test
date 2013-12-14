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
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class SimpleCubeDemo extends AbstractDemo{

	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		renderer.setClearColorHex(0xffffff, 1);
		
		
		
		
		final Scene scene=THREE.Scene();
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		cameraControle.setPositionZ(20);
		
		
		final Mesh mesh=THREE.Mesh(THREE.CubeGeometry(5, 5, 5), 
				THREE.MeshLambertMaterial().color(0xff0000).build());
		scene.add(mesh);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
				camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
				
				mesh.setRotation(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ());
				
				
				
				renderer.render(scene, camera);
				MainWidget.stats.end();
			}
		};
		
		
		startTimer(timer);
	}
@Override
	public void onMouseMove(MouseMoveEvent event) {
	super.onMouseMove(event);
		if(event.getNativeButton()==NativeEvent.BUTTON_LEFT && mouseDown){
			int diffX=event.getX()-mouseDownX;
			int diffY=event.getY()-mouseDownY;
			mouseDownX=event.getX();
			mouseDownY=event.getY();
			
			cameraControle.incrementRotationX(diffY);
			cameraControle.incrementRotationY(diffX);
		}
	}

	@Override
	public String getName() {
		return "Simple Cube";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.box().getText();
	}
}
