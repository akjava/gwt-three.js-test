/*
 * 
 * CCD-IK
 * based on Inverse kinematics and geometric constraints for articulated figure manipulation
 * http://summit.sfu.ca/item/5706
 * and
 * http://www.tmps.org/index.php?CCD-IK%20and%20Particle-IK
 * 
 * Copyright (C) 2011-2012 aki@akjava.com
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

import com.akjava.gwt.lib.client.ExportUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Intersect;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.core.Projector;
import com.akjava.gwt.three.client.gwt.GWTDragObjectControler;
import com.akjava.gwt.three.client.gwt.GWTGeometryUtils;
import com.akjava.gwt.three.client.lights.Light;
import com.akjava.gwt.three.client.math.Vector3;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

public class DragDemo extends AbstractDemo{

private Camera camera;
private Scene scene;
private Object3D root;

@SuppressWarnings("unchecked")
JsArray<Object3D> meshs=((JsArray<Object3D>) JsArray.createArray());
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		renderer.setClearColorHex(0xffffff, 1);
		scene=THREE.Scene();
	
		
		camera=THREE.PerspectiveCamera(70,(double)width/height,1,10000);
			
		scene.add(camera);
		
		root=THREE.Object3D();
		scene.add(root);
		
		root.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(0, -2000, 0), THREE.Vector3(0, 2000, 0), 0x00ff00));
		
		Mesh ground=THREE.Mesh(THREE.PlaneGeometry(100, 100, 50, 50), THREE.MeshBasicMaterial().color(0x888888).wireFrame().build());
		ground.setRotation(Math.toRadians(-90), 0, 0);
		ground.setPosition(0,-5,0);
		root.add(ground);
		
		Light pointLight = THREE.PointLight(0xffffff);
		pointLight.setPosition(0, 100, 100);
		root.add(pointLight);
		
		dragObjectControler = new GWTDragObjectControler(scene,projector);
		
		Object3D mesh =  THREE.Mesh(THREE.CubeGeometry(10,10,10), THREE.MeshLambertMaterial().color(0x00ff00).build());
		root.add(mesh);
		meshs.push(mesh);
		

		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.update();
				camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
				
				root.setRotation(cameraControle.getRadiantRotationX(), cameraControle.getRadiantRotationY(), cameraControle.getRadiantRotationZ());
				
				
				renderer.render(scene, camera);
				
			}
		};
		startTimer(timer);
	}
	
	Projector projector=THREE.Projector();

	@Override
	public void onMouseMove(MouseMoveEvent event) {
	super.onMouseMove(event);	
	if(event.getNativeButton()==NativeEvent.BUTTON_MIDDLE){
	return;
	}
	
	
	if(dragObjectControler.isSelected()){
		scene.updateMatrixWorld(true);//very important.sometime selectedDraggablekObject.getParent().getMatrixWorld() return 0. should i call after.renderer.render()
		Vector3 newPos=dragObjectControler.moveSelectionPosition(event.getX(),event.getY(), this.width, this.height, camera);
		dragObjectControler.getSelectedDraggablekObject().setPosition(newPos);	
	}
	
	
	
	}

	
	private GWTDragObjectControler dragObjectControler;
	@Override
	public void onMouseDown(MouseDownEvent event) {
		super.onMouseDown(event);
		if(event.getNativeButton()==NativeEvent.BUTTON_MIDDLE){
			return;
		}
		
		/* same as usual way
		double mouseX=((double)event.getX()/width)*2-1;
		double mouseY=-((double)event.getY()/height)*2+1;;
		Vector3 vector =  THREE.Vector3( mouseX, mouseY, 0.5 );
		projector.unprojectVector( vector, camera );
		Ray ray=THREE.Ray(camera.getPosition(), vector.subSelf( camera.getPosition() ).normalize());
		JsArray<Intersect> intersects=ray.intersectObjects(meshs);
		*/
		JsArray<Intersect> intersects=projector.gwtPickIntersects(event.getX(), event.getY(), width, height, camera, meshs);
		
		
		
		if(intersects.length()>0){
			dragObjectControler.selectObject(intersects.get(0).getObject(), event.getX(), event.getY(), this.width, this.height, camera);
		}
		
		
	}
	
	CheckBox exportButton;
	@Override
	public Widget getControler() {
		if(exportButton==null){
			exportButton=new CheckBox("visible mouse-detect plane");
			exportButton.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					dragObjectControler.getMouseCatchPlane().setVisible(exportButton.getValue());
				}
			});
		}
		return exportButton;
	}
	@Override
	public void onMouseUp(MouseUpEvent event) {
		super.onMouseUp(event);
		dragObjectControler.unselectObject();
	}
	
	@Override
	public void onMouseOut(MouseOutEvent event) {
		super.onMouseOut(event);
		dragObjectControler.unselectObject();
	}

	@Override
	public String getName() {
		return "Drag Object";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.drag().getText();
	}
}
