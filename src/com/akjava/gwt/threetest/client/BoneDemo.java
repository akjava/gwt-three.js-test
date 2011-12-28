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

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader.LoadHandler;
import com.akjava.gwt.three.client.gwt.animation.AnimationBone;
import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.animation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.gwt.animation.AnimationKey;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class BoneDemo extends AbstractDemo{
private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 20);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Mesh mesh=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshLambertMaterial().color(0xff0000).build());
		scene.add(mesh);
		
		final Mesh mesh2=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshLambertMaterial().color(0x00ff00).build());
		scene.add(mesh2);
		Vector3 mesh2P=THREE.Vector3(0, 3, 0);
		Vector3 mesh2R=THREE.Vector3(0,0,Math.toRadians(120));
		Matrix4 m1=THREE.Matrix4();
		m1.setPosition(mesh2P);
		m1.setRotationFromEuler(mesh2R, "XYZ");
		
		
		
		
		
		mesh2.getPosition().setPositionFromMatrix(m1);
		mesh2.getRotation().setRotationFromMatrix(m1);
		
		
		final Mesh mesh3=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshLambertMaterial().color(0x0000ff).build());
		scene.add(mesh3);
		Vector3 mesh3P=THREE.Vector3(0, 2, 0);
		Matrix4 m2=THREE.Matrix4();
		m2.setPosition(mesh3P);
		
		m2=m1.multiply(m1,m2);
		Vector3 new3P=THREE.Vector3();
		new3P.setPositionFromMatrix(m2);
		mesh3.setPosition(new3P);
		
		Vector3 new3R=THREE.Vector3();
		new3R.setRotationFromMatrix(m2);
		mesh3.setRotation(new3R);
		
		
		
		final Mesh mesh4=THREE.Mesh(THREE.CubeGeometry(1, 1, 1), 
				THREE.MeshLambertMaterial().color(0x00ff00).build());
		scene.add(mesh4);
		Matrix4 m3=THREE.Matrix4();
		m3.setPosition(THREE.Vector3(0,1,0));
		m3.multiply(m1, m3);
		
		mesh4.getPosition().setPositionFromMatrix(m3);
		mesh4.getRotation().setRotationFromMatrix(m3);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
JSONLoader loader=THREE.JSONLoader();
		
		loader.load("models/buffalo.js", new LoadHandler() {
			@Override
			public void loaded(Geometry geometry) {
				
				//AnimationData data=AnimationUtils.createAnimationData();
				log(geometry);
				//log(geometry.getAnimation());
				AnimationData data=geometry.getAnimation();
				
				GWT.log(data.getName()+","+data.getLength()+","+data.getFps()+","+data.getJIT());
				
				
				JsArray<AnimationBone> bones=geometry.getBones();
				
				for(int i=0;i<bones.length();i++){
					AnimationBone bone=bones.get(i);
					//GWT.log("bone:"+i);
					String log="";
					log+=bone.getName()+","+bone.getParent();
					JsArrayNumber pos=bone.getPos();
					//GWT.log("pos:"+pos);
					log+="pos["+pos.get(0)+","+pos.get(1)+","+pos.get(2)+"] ";
					//GWT.log(log);
				}
				/*
				 * JsArray<AnimationHierarchyItem> hi=data.getHierarchy();
				for(int i=0;i<hi.length();i++){
					AnimationHierarchyItem item=hi.get(i);
					GWT.log("parent:"+item.getParent());
					JsArray<AnimationKey> keys=item.getKeys();
					GWT.log("keys:"+keys.length());
					for(int j=0;j<keys.length();j++){
						AnimationKey key=keys.get(j);
						String keyLog="time:"+key.getTime()+" ";
						//key.setPos(1, 1, 1);
						//key.setScl(1, 1, 1);
						JsArrayNumber pos=key.getPos();
						
						keyLog+="pos["+pos.get(0)+","+pos.get(1)+","+pos.get(2)+"] ";
						
						JsArrayNumber scl=key.getScl();
						//keyLog+="scl["+scl.get(0)+","+scl.get(0)+","+scl.get(0)+"] ";
						GWT.log(j+","+keyLog);
					}
				}*/
				
			}
		});
		
		
		timer = new Timer(){
			public void run(){
				
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
		return "Sphere";
	}

}
