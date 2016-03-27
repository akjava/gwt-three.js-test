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

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.examples.renderers.CellShader;
import com.akjava.gwt.three.client.gwt.materials.ShaderMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.SceneUtils;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class CellShaderDemo extends AbstractDemo{

private Object3D object;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		renderer.setClearColor(0xffffff, 1);
		
		final Scene scene=THREE.Scene();
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		
		
		
		JSONLoader loader=THREE.JSONLoader();
		
		
		
		loader.load("models/female04b.js", new JSONLoadHandler() {
			
			

			

			@Override
			public void loaded(Geometry geometry, JsArray<Material> ms) {
				
				if(!CellShader.exists()){
					LogUtils.log("not found THREEx.ShaderLib maybe forget include it.");
				}
				CellShader shader=(CellShader) CellShader.createObject();
				
				
				Material material=THREE.ShaderMaterial(ShaderMaterialParameter.create().
						fragmentShader(shader.fragmentShader()).
						vertexShader(shader.vertexShader()).
						uniforms(shader.uniforms())
						);
				
				List<Material> materials=new ArrayList<Material>();
				materials.add(material);
				object=SceneUtils.createMultiMaterialObject(geometry, materials);
				
				
				object.setPosition(0, 0, 0);
				object.getRotation().set(0, 0, 0, Euler.XYZ);
				object.setScale(5,5,5);
				scene.add(object);
			}
		});
		
		
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		
		scene.add(light);
		
		
		
		//default camera position
		cameraControle.setPositions(0,0,200);
		
		Timer timer = new Timer(){
			public void run(){
				try{
					MainWidget.stats.begin();
					camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
					object.getRotation().set(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ(),Euler.XYZ);
					
					renderer.render(scene, camera);
					MainWidget.stats.end();
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		
		startTimer(timer);
	}

	@Override
	public boolean isSupportCanvas(){
		return false;
	}
	
	@Override
	public String getName() {
		return "Cell Shader";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.cell().getText();
	}
}
