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

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Vertex;
import com.akjava.gwt.three.client.extras.ImageUtils;
import com.akjava.gwt.three.client.extras.ShaderUtils;
import com.akjava.gwt.three.client.extras.ShaderUtils.Shader;
import com.akjava.gwt.three.client.extras.ShaderUtils.Uniforms;
import com.akjava.gwt.three.client.extras.UniformUtils;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.loaders.JSONLoader;
import com.akjava.gwt.three.client.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.math.Vector3;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class NormalmapDemo extends AbstractDemo{


private long last;
private AnimationModel model;

	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		renderer.setClearColorHex(0x333333, 1);
		
		final Scene scene=THREE.Scene();
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 300, 0);
		final Vector3 target=THREE.Vector3(0, 150, 0);
		scene.add(camera);
		
		
		
		
		
		JSONLoader loader=THREE.JSONLoader();
		
		
		loader.load("models/animation.js", new JSONLoadHandler() {
		//loader.load("models/men2b_boned_gun.js", new LoadHandler() {
			
			
			

			@Override
			public void loaded(Geometry geometry, JsArray<Material> ms) {
				log(geometry);
				
				Shader shader=ShaderUtils.lib("normal");
				Uniforms uniforms=UniformUtils.clone(shader.uniforms());
				uniforms.set("tNormal", ImageUtils.loadTexture("img/normalmap.png"));
				//uniforms.set("tNormal", ImageUtils.loadTexture("img/men2buv_n.png#10"));
				
				uniforms.set("enableDiffuse", true);
				uniforms.setHex("uDiffuseColor", 0xff0000);
				//uniforms.set("tDiffuse", ImageUtils.loadTexture("img/men2buv.png#1"));
				uniforms.set("tDiffuse", ImageUtils.loadTexture("img/uv.png"));
				uniforms.set("uNormalScale",1,1);
				
				Material material=THREE.ShaderMaterial().fragmentShader(shader.fragmentShader()).vertexShader(shader.vertexShader()).uniforms(uniforms).lights(true)
						.morphTargets(false).build();
				
				model=new AnimationModel(geometry, material);
				model.getObject3D().getScale().set( 15, 15, 15);
				model.getObject3D().getPosition().set(0, -100, 0);
				scene.add(model.getObject3D());
				
				GWT.log("loaded:");
			}
		});
		
		
		
		final Light light=THREE.DirectionalLight(0xeeeeee,2);
		light.setPosition(1, 1, 1);
		light.getPosition().normalize();
		//scene.add(light);
		
		final Light light2=THREE.DirectionalLight(0xeeeeee,2);
		light2.setPosition(-1, -1, -1);
		light2.getPosition().normalize();
		scene.add(light2);
		
		final Light light3=THREE.PointLight(0xffffff);
		light3.setPosition(0, 0, 600);
		scene.add(light3);
		//scene.add(light2);
		
		scene.add(THREE.AmbientLight(0xcccccc));
		
		
	//	MainWidget.cameraMove.setZ(-20);
		MainWidget.cameraMove.setZ(25);
	//	MainWidget.cameraRotation.setX(-90);
		final int radius = 600;
		
		last = System.currentTimeMillis();
		Timer timer = new Timer(){
			double theta;
			public void run(){
				MainWidget.stats.begin();
				try{
					theta += 0.2;

					camera.getPosition().setX(radius * Math.sin( theta * Math.PI / 360 ));
					camera.getPosition().setZ(radius * Math.cos( theta * Math.PI / 360 ));
					camera.lookAt( target );
					
					if(model!=null){
						//TODO clock
						long tmp=System.currentTimeMillis();
						long delta=tmp-last;
						//animMesh.updateAnimation(delta);
						//animMesh.update((int) delta);
						//tmpwork
						int index=(int) (tmp/100%model.getFramelength());
						model.select(index);
						last=tmp;
					}
				
				renderer.render(scene, camera);
				
				
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
				MainWidget.stats.end();
			}
		};
		
		startTimer(timer);
	}

	

	@Override
	public String getName() {
		return "NormalMap Animation";
	}
	
	public static class AnimationModel{
	protected AnimationModel(){
		
	}
	public int getFramelength(){
		return meshs.size();
	}
	List<Mesh> meshs=new ArrayList<Mesh>();
	private Mesh current;
	private Object3D container;
	Geometry last;
	private boolean createBetweenFrame=true;
	public  AnimationModel(Geometry geometry,Material material){
		container=THREE.Object3D();
		int size=getMorphTargetsLength(geometry);
		for(int i=1;i<size;i++){//0 is reset pose?
			Geometry geo=makeMorphTargetsGeometry(geometry,i);
			geo.computeTangents();
			
			if(createBetweenFrame){
			//make half
			if(i!=1){
				JsArray<Vector3> pre=last.vertices();
				JsArray<Vector3> current=geo.vertices();
				JsArray<Vector3> half=halfAndHalf(pre,current,0.5);
				//Geometry geo2=makeMorphTargetsGeometry(geometry,half);
				//geo2.computeTangents();
				//Mesh mesh=THREE.Mesh(geo2, material);
				//add(mesh);
			}
			}
			
			last=geo;
			
			Mesh mesh=THREE.Mesh(geo, material);
			add(mesh);
		}
		
	}
	public Object3D getObject3D(){
		return container;
	}
	private final void add(Mesh mesh){
		meshs.add(mesh);
	}
	
	public final void select(int index){
		if(current!=null){
			container.remove(current);
		}
		current=meshs.get(index);
		container.add(current);
	}
	
	public static final native int getMorphTargetsLength(Geometry geometry)/*-{
	return geometry.morphTargets.length;
	}-*/;
	
	public static final native Geometry makeMorphTargetsGeometry(Geometry base,int index)/*-{
	var geometry=base.clone();
	geometry.vertices=base.morphTargets[index].vertices;
	
	return geometry;
	}-*/;
	

	public static final native Geometry makeMorphTargetsGeometry(Geometry base,JsArray<Vertex> vertexs)/*-{
	var geometry=base.clone(base);
	geometry.vertices=vertexs;
	
	return geometry;
	}-*/;
	
	public static JsArray<Vector3> halfAndHalf(JsArray<Vector3> v1,JsArray<Vector3> v2,double level){
		if(v1.length()!=v2.length()){
			return null;
		}
		double v2level=1-level;
		JsArray<Vector3> result=(JsArray<Vector3>) JsArray.createArray();
		for(int i=0;i<v1.length();i++){
			//TODO search better way
			Vector3 ve1=v1.get(i);
			Vector3 ve2=v2.get(i);
			Vector3 newV=THREE.Vector3(
					ve1.getX()*level+ve2.getX()*v2level,
					ve1.getY()*level+ve2.getY()*v2level,
					ve1.getZ()*level+ve2.getZ()*v2level
					);
			result.push(newV);
		}
		return result;
	}
	
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
