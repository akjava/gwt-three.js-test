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

import com.akjava.gwt.three.client.examples.renderers.CSS3DObject;
import com.akjava.gwt.three.client.examples.renderers.CSS3DRenderer;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class HelloCSS3DDemo extends AbstractDemo{

	private CSS3DObject css3;
	private Scene scene;
	private Camera camera;
	private Label label;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		//renderer.setClearColorHex(0xcccccc, 1);
		//renderer.clear();
		
		
		scene = THREE.Scene();
		camera = THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		cameraControle.setPositionZ(100);
		cameraControle.setPositionX(0);
		cameraControle.setPositionY(0);
		label = new Label("hello world");
		
		cameraControle.setRotations(0, 0, 0);
		
		css3 = CSS3DObject.createObject(label.getElement());
		scene.add(css3);
		
		
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
				camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
				
				css3.setRotation(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ());
				
				
				
				renderer.render(scene, camera);
				MainWidget.stats.end();
			}
		};
		
		
		
		startTimer(timer);
	}
	
	@Override
	public void stop() {
		if(timer!=null){
		timer.cancel();
		timer=null;
		
		
		}
		
		CSS3DRenderer css3r=(CSS3DRenderer)renderer;
		
		css3r.gwtClear();	//to avoid show duplicate content.
		
		/*
		if(css3!=null){
		scene.remove(css3);
		Canvas canvas=CanvasUtils.createCanvas(width, height);
		canvas.getContext2d().setFillStyle("#ccc");
		canvas.getContext2d().fillRect(0, 0, width, height);
		scene.add(CSS3DObject.create(canvas.getCanvasElement()));
		renderer.render(scene, camera);
		}
		*/
		
	}
	
	
	@Override 
	public Widget getControler(){
		
		HorizontalPanel panel=new HorizontalPanel();
		Button bt=new Button("remove",new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				css3.setVisible(false);
				scene.remove(css3);
				label.setVisible(false);//i have no idea
				
			}
		});
		panel.add(bt);
		
		return panel;
		
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
		return "Css3D";
	}
	@Override
	public String getHowToHtml(){
		return "";
	}
	@Override
	public boolean isSupportCanvas(){
		return false;
	}
	@Override
	public boolean isSupportWebGL(){
		return false;
	}
	@Override
	public boolean isSupportCSS3D(){
		return true;
	}
}
