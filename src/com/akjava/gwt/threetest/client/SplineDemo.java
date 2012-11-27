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
import com.akjava.gwt.three.client.gwt.AbstractMovingXYControler;
import com.akjava.gwt.three.client.gwt.Clock;
import com.akjava.gwt.three.client.gwt.Point;
import com.akjava.gwt.three.client.gwt.Spline;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class SplineDemo extends AbstractDemo{
private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		stop();
		
		
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		camera.getPosition().set(0, 0, 500);
		
		
		final Scene scene=THREE.Scene();
		
		final List<Point> pts=new ArrayList<Point>();
		for(int i=0;i<10;i++){
			double mx=Math.random()*20+i*20-100;
			double my=Math.random()*100;
			pts.add(Point.create(mx, my));
			final Mesh mesh=THREE.Mesh(THREE.SphereGeometry(2, 16, 16), 
					THREE.MeshLambertMaterial().color(0xff0000).build());
			mesh.setPosition(mx, my, 0);
			scene.add(mesh);
		}
		
		
		final Light light=THREE.PointLight(0xffffff);
		light.setPosition(10, 0, 10);
		scene.add(light);
		
		
		
		final long s=System.currentTimeMillis();
		final long totalDuration=1000*10;
		
		final Geometry geo=THREE.SphereGeometry(2, 16, 16);
		final Material material=THREE.MeshLambertMaterial().color(0x0000ff).build();
		final Clock clock=new Clock();
		final AbstractMovingXYControler moving=new AbstractMovingXYControler(pts,totalDuration) {
			
			@Override
			public void moveTo(double x, double y) {
				final Mesh mesh=THREE.Mesh(geo, 
						material);
				mesh.setPosition(x,y, 0);
				//GWT.log(pt.getX()+"x"+pt.getY());
				scene.add(mesh);
			}
			
			@Override
			public void moveEnd() {
				
			}
		};
		timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
				long t=clock.delta();
				if(moving.isMoving()){
					moving.update(t);
				}
				renderer.render(scene, camera);

			}
			
		};
		timer.scheduleRepeating(1000/60);
	}

	@Override
	public void stop() {
		if(timer!=null){
		timer.cancel();
		}
	}

	@Override
	public String getName() {
		return "Sprine";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.howto_default().getText();
	}
}
