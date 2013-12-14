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

import com.akjava.gwt.lib.client.CanvasUtils;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.examples.renderers.CSS3DObject;
import com.akjava.gwt.three.client.examples.renderers.CSS3DRenderer;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;

public class PlainDemo extends AbstractDemo{

	private boolean css3d;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		if(renderer.gwtGetType().equals("css3d")){
			css3d=true;
		}else{
			css3d=false;
			renderer.setClearColorHex(0xffffff, 1);
		}
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 20);
		
		final Scene scene=THREE.Scene();
		
		final Object3D object;
		if(css3d){
			
			Image img=new Image(createColorImage(0,255,255,0.5,5,5));
			CSS3DObject obj1 = CSS3DObject.createObject(img.getElement());
			
			scene.add(obj1);
			object=obj1;
			
			Image img2=new Image(createColorImage(255,0,0,0.5,5,5));
			CSS3DObject obj2 = CSS3DObject.createObject(img2.getElement());
			obj2.setPosition(2, 2, 2);
			scene.add(obj2);
			
		}else{
		MeshBasicMaterialBuilder basicMaterial=MeshBasicMaterialBuilder.create().wireFrame(false).color(0x00ffff).opacity(0.5).reflectivity(true)
		.transparent(true);
		
		final Mesh mesh=THREE.Mesh(THREE.PlaneGeometry(5, 5), 
				basicMaterial.build());
		scene.add(mesh);
		object=mesh;
		
		final Mesh mesh2=THREE.Mesh(THREE.PlaneGeometry(5, 5), 
				basicMaterial.color(0xff0000).build());
		mesh2.setPosition(2, 2, 2);
		scene.add(mesh2);
		}
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		
		
		Timer timer = new Timer(){
			public void run(){
				object.getRotation().gwtIncrementX(0.02);
				object.getRotation().gwtIncrementY(0.02);
				renderer.render(scene, camera);

			}
		};
		startTimer(timer);
	}

	@Override
	public void stop() {
		super.stop();
		if(css3d){
		CSS3DRenderer css3r=(CSS3DRenderer)renderer;
		css3r.gwtClear();
		}
	}
	public String createColorImage(int r,int g,int b,double opacity,int w,int h){
		Canvas canvas=CanvasUtils.createCanvas(w, h);
		canvas.getContext2d().setFillStyle("rgba("+r+","+g+","+b+","+opacity+")");
		canvas.getContext2d().fillRect(0, 0, w, h);
		String image1=canvas.toDataUrl();
		return image1;
	}
	
	@Override
	public boolean isSupportCSS3D(){
		return true;
	}

	@Override
	public String getName() {
		return "Plain";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
