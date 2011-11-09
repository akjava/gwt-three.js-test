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
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class ExplotionDemo extends AbstractDemo{
private Timer timer;
private Mesh mesh;

//original is here
//www.airtightinteractive.com/demos/cubes_three/
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		
		
		
		renderer.setClearColorHex(0x333333, 1);
		renderer.setShadowMapEnabled(true);
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 0);
		
		
		
		final Scene scene=THREE.Scene();
		
		final Light light=THREE.SpotLight(0xffffff);
		light.setPosition(100,200, 150);//light.setPosition(5,5, 5);
		light.setCastShadow(true);
		scene.add(light);
		
		
		//scene.add(THREE.AmbientLight(0x888888));
		
		
		
		final Mesh root=THREE.Mesh(THREE.PlaneGeometry(36, 36), THREE.MeshLambertMaterial().color(0x00ee88).build());
		scene.add(root);
		mesh=root;
		
		final List<Block> blocks=new ArrayList<Block>();
		for(int i=0;i<100;i++){
		Block block=new Block(root);
		blocks.add(block);
		}
		
		
		root.setRotation(Math.toDegrees(45),Math.toDegrees(45),Math.toDegrees(-45));
		
		MainWidget.cameraRotation.setX(-45);
		MainWidget.cameraRotation.setZ(45);
		
	//	MainWidget.cameraMove.setZ(-20);
		MainWidget.cameraMove.setZ(75);
	//	MainWidget.cameraRotation.setX(-90);
		timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
				try{
					
					for(Block block:blocks){
						block.update();
					}
					camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
					
					
					mesh.setRotation(Math.toRadians(MainWidget.cameraRotation.getX()), Math.toRadians(MainWidget.cameraRotation.getY()), Math.toRadians(MainWidget.cameraRotation.getZ()));
				
				//cancel();
				if(mesh!=null){
				//mesh.getRotation().incrementZ(0.02);
				//mesh.getRotation().incrementZ(0.02);
				}
				renderer.render(scene, camera);
				}catch(Exception e){
					GWT.log(e.getMessage());
				}
			}
		};
		//timer.schedule(2000);
		timer.scheduleRepeating(1000/60);
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Explotion";
	}
	
	public class Block{
		double maxSize=5;
		double minSize=0.8;
		boolean smoke;
		public Block(Mesh parentMesh){
			
			//Geometry cube = THREE.CubeGeometry(maxSize*Math.random()+minSize, maxSize*Math.random()+minSize, maxSize*Math.random()+minSize);
			Geometry cube=THREE.SphereGeometry((maxSize*Math.random()+minSize)/2, 3, 3);
			//Material[] ms=new Material[cube.faces().length()];
			if(Math.random()<0.5){
				//orange
				for(int i=0;i<cube.faces().length();i++){
					Material mt=THREE.MeshBasicMaterial().color((int)Math.floor( Math.random() * 128 + 128), (int)Math.floor( Math.random() * 66*2 ), 0).build();
					cube.faces().get(i).materials().set(0, mt);
				}
			}else{
				//gray
				smoke=true;
				for(int i=0;i<cube.faces().length();i++){
					int brightness = (int) Math.floor( Math.random() * 216 + 40);
					Material mt=THREE.MeshBasicMaterial().color(brightness, brightness, brightness).build();
					cube.faces().get(i).materials().set(0, mt);
				}
			}
				
		mesh = THREE.Mesh(cube, THREE.MeshFaceMaterial());
		parentMesh.add(mesh);
		reset();
		}
		double MAX_SPEED=0.2;
		double MAX_ROT=0.1;
		
		double xd,yd,zd;
		double xrd,zrd;
		
		int ticks;
		private Mesh mesh;
		public void reset(){
			mesh.setPosition(0, 0, 0);
			mesh.setRotation(Math.random()*360, 0, Math.random()*360);
			
			xrd=Math.random()*MAX_ROT*2 - MAX_ROT;
			zrd=Math.random()*MAX_ROT*2 - MAX_ROT;
			
			xd=Math.random()*MAX_SPEED*2 - MAX_SPEED;
			yd=Math.random()*MAX_SPEED*2 - MAX_SPEED;
			zd=Math.random()*MAX_SPEED*2 - MAX_SPEED;
			
			ticks=0;
		}
		
		public void update(){
			
			if(smoke){
			mesh.getPosition().incrementX(xd/3);
			mesh.getPosition().incrementY(yd/3);
			mesh.getPosition().incrementZ(zd);
			}else{
				mesh.getPosition().incrementX(xd/5);
				mesh.getPosition().incrementY(yd/5);
				mesh.getPosition().incrementZ(zd/10);
			}
			
			mesh.getRotation().incrementX(xrd);
			mesh.getRotation().incrementZ(zrd);
			
			ticks++;
			if(ticks>100){
				reset();
			}
		}
		
	}

}
