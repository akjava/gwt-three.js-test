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

import java.util.HashMap;
import java.util.Map;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Intersect;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class PickDemo extends AbstractDemo{
private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		if(timer!=null){
			timer.cancel();
			timer=null;
		}
		//renderer.setClearColorHex(0xff0000, 0.5);
		
		final Map<Integer,Mesh> meshs=new HashMap<Integer,Mesh>();
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 50);
		camera.getRotation().set(0, 0, 0);
		
		
		final Scene scene=THREE.Scene();
		
		
		final Material material=THREE.MeshLambertMaterial(0xff00ff, false);
		
		final Mesh mesh=THREE.Mesh(THREE.CylinderGeometry(5, 5, 5,6), 
				material);
		scene.add(mesh);
		
		final Mesh mesh2=THREE.Mesh(THREE.CylinderGeometry(5, 5, 5,15), 
				THREE.MeshLambertMaterial(0x00ff00, false));
		mesh2.setPosition(0, 10, 0);
		scene.add(mesh2);
		
		final Mesh mesh3=THREE.Mesh(THREE.CylinderGeometry(5, 1, 5,15), 
				THREE.MeshLambertMaterial(0x0000ff, false));
		mesh3.setPosition(0, -10, 0);
		scene.add(mesh3);
		
		final Mesh mesh4=THREE.Mesh(THREE.CylinderGeometry(5, 4.5, 5,5), 
				THREE.MeshLambertMaterial(0xffff00, false));
		mesh4.setPosition(-10,0, 0);
		scene.add(mesh4);
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		//scene.add(THREE.AmbientLight(0x330000));
		
		meshs.put(mesh.getId(),mesh);
		meshs.put(mesh2.getId(),mesh2);
		meshs.put(mesh3.getId(),mesh3);
		meshs.put(mesh4.getId(),mesh4);
		
		timer = new Timer(){
			public void run(){
				mesh.getRotation().incrementX(0.02);
				mesh.getRotation().incrementY(0.02);
				//mesh.setMaterials(material);
				//material.setColor(THREE.Color((int) (Math.random()*0xffffff)));
				//mesh.setMaterials(THREE.MeshLambertMaterial().color((int) (Math.random()*0xffffff)).build());
				renderer.render(scene, camera);
				camera.setPosition(MainWidget.cameraMove.getX(), MainWidget.cameraMove.getY(),MainWidget.cameraMove.getZ());
			
				double xa=Math.toRadians(MainWidget.cameraRotation.getX());
				double ya=Math.toRadians(MainWidget.cameraRotation.getY());
				double za=Math.toRadians(MainWidget.cameraRotation.getZ());
				//camera.setRotation(xa, ya, za);
			}
		};
		timer.scheduleRepeating(1000/60);
		
		final Projector projector=THREE.Projector();
		panel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//GWT.log(event.getX()+"x"+event.getY()+" - "+width+"x"+height);
				JsArray<Intersect> intersects=projector.pickIntersects(event.getX(), event.getY(), width, height, camera,scene);
				if(intersects.length()>0){
				//GWT.log(""+intersects.length());
				}
				for(int i=0;i<intersects.length();i++){
					Intersect sect=intersects.get(i);
					//GWT.log(""+sect.getObject().getId()+" = "+sect.getObject().getName());
					
					final Mesh target=meshs.get(sect.getObject().getId());
					final int old=target.getMaterials().get(0).getColor().getHex();
					target.getMaterials().get(0).getColor().setHex(0xeeeeee);
					Timer timer=new Timer(){

						@Override
						public void run() {
							target.getMaterials().get(0).getColor().setHex(old);
						}
						
					};
					timer.schedule(1000);
					
					
				}
			}
		});
	}

	@Override
	public void stop() {
		timer.cancel();
	}

	@Override
	public String getName() {
		return "Pick";
	}

}
