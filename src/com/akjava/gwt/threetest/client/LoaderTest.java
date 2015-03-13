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
import com.akjava.gwt.three.client.java.utils.GWTGeometryUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.SceneUtils;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.loaders.ImageLoader;
import com.akjava.gwt.three.client.js.loaders.ImageLoader.ImageLoadHandler;
import com.akjava.gwt.three.client.js.loaders.LoadingManager.LoadingManagerHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * json
 * @author aki
 *
 */
public class LoaderTest extends AbstractDemo{

private Object3D object;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		renderer.setClearColor(0x333333, 1);
		
		final Scene scene=THREE.Scene();
		
		ImageLoader imloader=THREE.ImageLoader(THREE.LoadingManager(new LoadingManagerHandler() {
			
			@Override
			public void onProgress(String url, int loaded, int total) {
				LogUtils.log("onprogress:"+url+",loaded="+loaded+",total="+total);
			}
			
			@Override
			public void onLoad() {
				LogUtils.log("onload");
			}
			
			@Override
			public void onError(NativeEvent error) {
				LogUtils.log(error);
			}
		}));
		imloader.load("img/wood64.png", new  ImageLoadHandler() {
			
			@Override
			public void onProgress(NativeEvent progress) {
				LogUtils.log(progress);
			}
			
			@Override
			public void onLoad(ImageElement imageElement) {
				Image img=Image.wrap(imageElement);
				RootPanel.get().add(img);
			}
			
			@Override
			public void onError(NativeEvent error) {
				LogUtils.log(error);
			}
		});
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		//final JSONLoader loader=THREE.JSONLoader();
		
		RequestBuilder builder=new RequestBuilder(RequestBuilder.GET,"models/men.js");
		try {
			builder.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					String text=response.getText();
					JSONObject jsonObject=GWTGeometryUtils.loadJsonModelWithMaterial(text);
					
					
					Geometry geometry=(Geometry)(jsonObject.get("geometry").isObject().getJavaScriptObject());
					
					List<Material> materials=new ArrayList<Material>();
					materials.add(THREE.MeshLambertMaterial().color(0x0000ff).build());
					materials.add(THREE.MeshBasicMaterial().color(0x0).transparent(true).wireFrame().build());
					object=SceneUtils.createMultiMaterialObject(geometry, materials);
					
					
					object.setPosition(0, 0, 0);
					object.setRotation(0, 0, 0);
					object.setScale(5,5,5);
					scene.add(object);
				}
				
				@Override
				public void onError(Request request, Throwable exception) {
					Window.alert(exception.getMessage());
				}
			});
		} catch (RequestException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		/*
		loader.load("models/men.js", new LoadHandler() {
			
			

			@Override
			public void loaded(Geometry geometry) {
				List<Material> materials=new ArrayList<Material>();
				materials.add(THREE.MeshLambertMaterial().color(0xff0000).build());
				materials.add(THREE.MeshBasicMaterial().color(0x0).transparent(true).wireFrame().build());
				object=SceneUtils.createMultiMaterialObject(geometry, materials);
				
				//mesh = THREE.Mesh(geometry, );
				object.setPosition(0, 0, 0);
				object.setRotation(0, 0, 0);
				object.setScale(5,5,5);
				scene.add(object);
			}
		});
		*/
		
		
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		
		scene.add(light);
		
		
		
		//default camera position
		cameraControle.setPositions(30,70,200);
		
		Timer timer = new Timer(){
			public void run(){
				try{
					MainWidget.stats.begin();
					camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
					
					object.setRotation(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ());
					
					
					
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
	public String getName() {
		return "Load Obj";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
