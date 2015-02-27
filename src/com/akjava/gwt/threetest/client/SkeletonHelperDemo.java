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

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.java.utils.GWTGeometryUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.extras.helpers.SkeletonHelper;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.FocusPanel;

/**
 * 
 * @author aki
 *
 */
public class SkeletonHelperDemo extends AbstractDemo{

private Object3D object;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		
		renderer.setClearColor(0x333333, 1);
		
		final Scene scene=THREE.Scene();
		
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		scene.add(camera);
		
		//final JSONLoader loader=THREE.JSONLoader();
		
		RequestBuilder builder=new RequestBuilder(RequestBuilder.GET,"models/model001_proxy837_bone19.js");
		try {
			builder.sendRequest(null, new RequestCallback() {
				
				@Override
				public void onResponseReceived(Request request, Response response) {
					
					String text=response.getText();
					JSONObject jsonObject=GWTGeometryUtils.loadJsonModelWithMaterial(text);
					
					
					Geometry geometry=(Geometry)(jsonObject.get("geometry").isObject().getJavaScriptObject());
					
					
					Material material=THREE.MeshLambertMaterial(MeshLambertMaterialParameter.create().color(0xff0000));
					
					//LogUtils.log(geometry);
					/*
					 * model must have bones or  Uncaught TypeError: Cannot set property 'needsUpdate' of undefined
					 */
					
					SkinnedMesh skinned=THREE.SkinnedMesh(geometry, material);
					SkeletonHelper helper=THREE.SkeletonHelper(skinned);
					
					
					object=THREE.Object3D();
					
					
					
					//object.setScale(5,5,5);
					scene.add(object);
					
					object.add(skinned);
					object.add(helper);
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
		
		
		
		//need distance,if so close on initial object would not be drawn.
		cameraControle.setPositions(0,10,50);
		
		Timer timer = new Timer(){
			public void run(){
				try{
					MainWidget.stats.begin();
					camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
					
					object.getRotation().set(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ(),"XYZ");
					
					
					
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
		return "Skeleton Helper";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
