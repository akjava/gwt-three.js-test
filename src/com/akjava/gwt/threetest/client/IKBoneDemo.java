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

import java.util.ArrayList;
import java.util.List;

import com.akjava.gwt.three.client.gwt.boneanimation.ik.CDDIK;
import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.java.utils.GWTGeometryUtils;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.lights.Light;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.threetest.client.resources.Bundles;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class IKBoneDemo extends AbstractDemo{
//private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		super.start(renderer, width, height, panel);
		renderer.setClearColor(0xffffff, 1);
		final Scene scene=THREE.Scene();
	
		
		final Camera camera=THREE.PerspectiveCamera(35,(double)width/height,.1,10000);
		cameraControle.setPositionZ(50);
		
		scene.add(camera);
		
		
		Light pointLight = THREE.PointLight(0xffffff);
		pointLight.setPosition(0, 10, 300);
		scene.add(pointLight);
		
		
		
		
		
		
		root=THREE.Object3D();
		scene.add(root);
		
		targetMesh = THREE.Mesh(THREE.BoxGeometry(.5, .5, .5), 
				THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color(0x0000ff)));
		root.add(targetMesh);
		targetMesh.setPosition(targetPos);
		
		
		
		joints = new ArrayList<Object3D>();

		Object3D parent=THREE.Object3D();
		joints.add(parent);
		
		root.add(parent);
		for(int i=0;i<4;i++){
			int color=0xff0000;
			if(i==3){
				color=0x00ff00;
			}
			
			
			if(i==3){
				hand=THREE.Mesh(THREE.BoxGeometry(.5, .5, .5), 
						THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color(color)));
				parent.add(hand);
				Vector3 pos=THREE.Vector3(2, 0, 0);
				hand.setPosition(pos);
				parent.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(), pos, 0x888888));
			}else{
				final Mesh mesh=THREE.Mesh(THREE.BoxGeometry(.5, .5, .5), 
						THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color(color)));
				parent.add(mesh);
				Vector3 pos=THREE.Vector3(2, 0, 0);
				mesh.setPosition(pos);
				parent.add(GWTGeometryUtils.createLineMesh(THREE.Vector3(), pos, 0x888888));
				Object3D joint=THREE.Object3D();
				joint.setPosition(pos);
				joints.add(joint);	
			parent.add(joint);
			parent=joint;
			}
		}
		
		
		
		
		
panel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if(!steping){
				Vector3 tpos=GWTThreeUtils.toWebGLXY(event.getX(), event.getY(), camera, width, height);
				tpos.setZ(0);
				targetPos=tpos;
				targetMesh.setPosition(targetPos);
				
				//log(ret);
				
				steped=0;
				steping=true;
				}
			}
});
		
		/*
		
		*/
		last=System.currentTimeMillis();
	
		Timer timer = new Timer(){
			public void run(){
				MainWidget.stats.begin();
				
				camera.setPosition(cameraControle.getPositionX(), cameraControle.getPositionY(), cameraControle.getPositionZ());
				//not allow rotation.this version not good at rotation.
				//root.setRotation(cameraControle.getRagiantRotattionX(), cameraControle.getRagiantRotattionY(), cameraControle.getRagiantRotattionZ());
				
				renderer.render(scene, camera);

				if(steping){
					long c=System.currentTimeMillis();
					if(last+100<c){
						doStep();
						steped++;
						if(steped==20){
							steping=false;
						}
						last=c;
					}
					
				}
				MainWidget.stats.end();
			}
		};
		startTimer(timer);
	}
	
	

	long last;
	private boolean steping;
	int steped;

	private Object3D root;
	
	private int index=3;

	private List<Object3D> joints;

	
	private  Mesh hand;
	Vector3 targetPos=THREE.Vector3(0, 0, 0);

	private Mesh targetMesh;
	private CDDIK cddik=new CDDIK();
	public  void doStep(){
		//Vector3 handPos=hand.getMatrixWorld().getPosition();
		Vector3 handPos=THREE.Vector3().setFromMatrixPosition(hand.getMatrixWorld());
		Object3D joint=joints.get(index);
		//Vector3 jointPos=joint.getMatrixWorld().getPosition();
		Vector3 jointPos=THREE.Vector3().setFromMatrixPosition(joint.getMatrixWorld());
		//GWT.log("h0");
		Matrix4 beforeRot=THREE.Matrix4();
		beforeRot.makeRotationFromEuler(joint.getRotation());
		//GWT.log("h1");
		Matrix4 rotated=cddik.doStep(handPos, jointPos, beforeRot, targetPos);
		//GWT.log("h2");
		
		
		
		
		if(rotated==null){
			GWT.log("rotated:null");
			steping=false;
			return;
		}
		
		Vector3 vec=THREE.Vector3();
		vec.getRotationFromMatrix(rotated);
		//log("name:"+joint.getName()+",before:"+ThreeLog.getAsDegree(joint.getRotation())+",after:"+ThreeLog.getAsDegree(vec));
		joint.getRotation().set(vec.getX(), vec.getY(), vec.getZ(), Euler.XYZ);
		joint.updateMatrixWorld(true);
		index--;
		if(index<0){
			index=joints.size()-1;
		}
	}
	


	@Override
	public String getName() {
		return "CDD-IK Bone";
	}
	@Override
	public String getHowToHtml(){
		return Bundles.INSTANCE.cdd().getText();
	}
}
