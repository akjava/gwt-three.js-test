package com.akjava.gwt.three.client.java.ui;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.java.ThreeLog;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseWheelEvent;

public abstract class SimpleTabDemoEntryPoint extends TabDemoEntryPoint{

	protected Camera camera;
	protected double cameraX,cameraY,cameraZ;
	protected int screenWidth,screenHeight;
	protected long mouseLast;
	protected int tmpZoom;
	protected Scene scene;
	protected int defaultZoom=3;
	protected int minCamera=5;
	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		if(event.isShiftKeyDown()){
			onMouseWheelWithShiftKey(event.getDeltaY());
		}else{
		if(!autoUpdateCameraPosition){
			return;
		}
			
		//TODO make class
		long t=System.currentTimeMillis();
		if(mouseLast+100>t){
			tmpZoom*=2;
		}else{
			tmpZoom=defaultZoom;
		}
		//GWT.log("wheel:"+event.getDeltaY());
		int tmp=(int)cameraZ+event.getDeltaY()*tmpZoom;
		tmp=Math.max(minCamera, tmp);
		tmp=Math.min(4000, tmp);
		cameraZ=tmp;
		mouseLast=t;
		}
		//log(""+cameraZ);
	}
	public  void onMouseWheelWithShiftKey(int deltaY){
		
	}
	
	@Override
	public void initialize(WebGLRenderer renderer, int width, int height) {
		cameraZ=100;
		screenWidth=width;
		screenHeight=height;
		renderer.setClearColor(0x333333, 1);//this is only filter color
		scene=THREE.Scene();
		updateCamera(scene, width, height);
		
		initializeOthers(renderer);
	}
	
	protected boolean autoUpdateCameraPosition=true;
	
	@Override
	public void update(WebGLRenderer renderer) {
		beforeUpdate(renderer);
		if(autoUpdateCameraPosition){
			camera.getPosition().set(cameraX, cameraY, cameraZ);
		}
		//LogUtils.log("camera:"+ThreeLog.get(camera.getPosition()));
		renderer.render(scene, camera);
		
		if(stats!=null){
			stats.update();
		}
	}
	
	protected abstract void beforeUpdate(WebGLRenderer renderer);

	/** called before create Control**/
	protected abstract  void initializeOthers(WebGLRenderer renderer) ;

	protected double nearCamera=0.5;
	protected double farCamera=6000;
	
	//switch to replace
	protected void updateCamera(Scene scene,int width,int height){
		
		if(camera==null){
		Camera camera = THREE.PerspectiveCamera(35,(double)width/height,nearCamera,farCamera);
		//camera.getPosition().set(0, 0, cameraZ);
		scene.add(camera); //some kind of trick.
		this.camera=camera;
		}else{
			PerspectiveCamera pcamera=camera.gwtCastPerspectiveCamera();
			pcamera.setNear(nearCamera);
			pcamera.setFar(farCamera);
			pcamera.setAspect((double)width/height);
			pcamera.updateProjectionMatrix();
		}
		
	}
	
	@Override
	public void resized(int width, int height) {
		if(width==0 || height==0){
			//log("never happend ignore-0 size");
			return;
		}else{
			//log("resized:"+width+"x"+height);
		}
		screenWidth=width;
		screenHeight=height;
		updateCamera(scene,width,height);
	}
	
	protected boolean mouseDown;
	
	protected int mouseDownX;
	protected int mouseDownY;
	@Override
	public void onMouseDown(MouseDownEvent event) {
		mouseDown=true;
		mouseDownX=event.getX();
		mouseDownY=event.getY();
	}

	@Override
	public void onMouseUp(MouseUpEvent event) {
		mouseDown=false;
	}
	
	@Override
	public void onMouseOut(MouseOutEvent event) {
		mouseDown=false;
	}
	public double getCameraZ() {
		return cameraZ;
	}
	public void setCameraZ(double cameraZ) {
		this.cameraZ = cameraZ;
	}
}
