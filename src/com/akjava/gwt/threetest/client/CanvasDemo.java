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

import com.akjava.gwt.lib.client.ExportUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.three.client.textures.Texture;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class CanvasDemo extends AbstractDemo{

	
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		canvas = Canvas.createIfSupported();
		canvas.setCoordinateSpaceWidth(100);
		canvas.setCoordinateSpaceHeight(100);
		canvas.getContext2d().setFillStyle("#cccccc");
		canvas.getContext2d().fillRect(0, 0, canvas.getCoordinateSpaceWidth(), canvas.getCoordinateSpaceHeight());
		canvas.getContext2d().strokeText("Hello World",25, 25);
		String url=canvas.toDataUrl();
		Image img=new Image(url);
		ImageElement imageElement=ImageElement.as(img.getElement());
		Texture texture=THREE.Texture(imageElement);
		texture.setNeedsUpdate(true);
		
		
		
		
		final Scene scene=THREE.Scene();
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		cameraControle.setPositionZ(20);
		
		
		final Mesh mesh=THREE.Mesh(THREE.CubeGeometry(5, 5, 5), 
				THREE.MeshLambertMaterial().map(texture).build());
		scene.add(mesh);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
				camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
				
				mesh.setRotation(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ());
				
				
				
				renderer.render(scene, camera);
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

Button exportButton;
private Canvas canvas;
@Override
public Widget getControler() {
	if(exportButton==null){
		exportButton=new Button("Export Image");
		exportButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String url=canvas.toDataUrl();
				ExportUtils.openTabAbsoluteURLImage(url, "canvastest");
			}
		});
	}
	return exportButton;
}

	@Override
	public String getName() {
		return "Canvas";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.canvas().getText();
	}
}
