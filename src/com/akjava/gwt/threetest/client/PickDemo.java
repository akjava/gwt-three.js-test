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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Intersect;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class PickDemo extends AbstractDemo{

	private Map<Integer,Mesh> meshs;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		renderer.setClearColorHex(0xffffff, 1);
		
		meshs = new HashMap<Integer,Mesh>();
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 50);
		camera.getRotation().set(0, 0, 0);
		
		
		final Scene scene=THREE.Scene();
		
		
		final Material material=THREE.MeshLambertMaterial().color(0xff00ff).build();
		
		final Mesh mesh=THREE.Mesh(THREE.CylinderGeometry(5, 5, 5,6), 
				material);
		scene.add(mesh);
		
		final Mesh mesh2=THREE.Mesh(THREE.CylinderGeometry(5, 5, 5,15), 
				THREE.MeshLambertMaterial().color(0x00ff00).build());
		mesh2.setPosition(0, 10, 0);
		scene.add(mesh2);
		
		final Mesh mesh3=THREE.Mesh(THREE.CylinderGeometry(5, 1, 5,15), 
				THREE.MeshLambertMaterial().color(0x0000ff).build());
		mesh3.setPosition(0, -10, 0);
		scene.add(mesh3);
		
		final Mesh mesh4=THREE.Mesh(THREE.CylinderGeometry(5, 4.5, 5,5), 
				THREE.MeshLambertMaterial().color(0xffff00).build());
		mesh4.setPosition(-10,0, 0);
		scene.add(mesh4);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		meshs.put(mesh.getId(),mesh);
		meshs.put(mesh2.getId(),mesh2);
		meshs.put(mesh3.getId(),mesh3);
		meshs.put(mesh4.getId(),mesh4);
		
		
		MainWidget.cameraMove.setX(0);
		MainWidget.cameraMove.setY(0);
		MainWidget.cameraMove.setZ(50);
		
		Timer timer = new Timer(){
			public void run(){
				mesh.getRotation().incrementX(0.02);
				mesh.getRotation().incrementY(0.02);

				renderer.render(scene, camera);
				camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
			
				
			}
		};
		startTimer(timer);
		
		final Projector projector=THREE.Projector();
		panel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				List<Object3D> list=new ArrayList<Object3D>();
				for(Mesh mesh:meshs.values()){
					list.add(mesh);
				}
				JsArray<Intersect> intersects=projector.gwtPickIntersectsByList(event.getX(), event.getY(), width, height, camera,list);
				if(intersects.length()>0){
				
				}
				for(int i=0;i<intersects.length();i++){
					Intersect sect=intersects.get(i);
					
					final Mesh target=meshs.get(sect.getObject().getId());
					log(target);
					
					final int old=target.getMaterial().getColor().getHex();
					target.getMaterial().getColor().setHex(0xeeeeee);
					Timer timer=new Timer(){

						@Override
						public void run() {
							target.getMaterial().getColor().setHex(old);
						}
						
					};
					timer.schedule(1000);
					
					
				}
			}
		});
	}

	

	@Override
	public String getName() {
		return "Pick";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
