package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.event.dom.client.MouseWheelEvent;

public abstract class SimpleDemoEntryPoint extends AbstractDemoEntryPoint{

	protected Camera camera;
	protected int cameraX,cameraY,cameraZ;
	protected int screenWidth,screenHeight;
	private long mouseLast;
	private int tmpZoom;
	protected Scene scene;
	protected int defaultZoom=10;
	protected int minCamera=5;
	@Override
	public void onMouseWheel(MouseWheelEvent event) {
		//TODO make class
		long t=System.currentTimeMillis();
		if(mouseLast+100>t){
			tmpZoom*=2;
		}else{
			tmpZoom=defaultZoom;
		}
		//GWT.log("wheel:"+event.getDeltaY());
		int tmp=cameraZ+event.getDeltaY()*tmpZoom;
		tmp=Math.max(minCamera, tmp);
		tmp=Math.min(4000, tmp);
		cameraZ=tmp;
		mouseLast=t;
		log(""+cameraZ);
	}
	
	@Override
	public void initialize(WebGLRenderer renderer, int width, int height) {
		cameraZ=100;
		screenWidth=width;
		screenHeight=height;
		renderer.setClearColorHex(0x333333, 1);
		scene=THREE.Scene();
		createCamera(scene, width, height);
		
		initializeOthers(renderer);
	}
	
	@Override
	public void update(WebGLRenderer renderer) {
		beforeUpdate(renderer);
		camera.getPosition().set(cameraX, cameraY, cameraZ);
		renderer.render(scene, camera);
	}
	
	protected abstract void beforeUpdate(WebGLRenderer renderer);

	protected abstract  void initializeOthers(WebGLRenderer renderer) ;

	private void createCamera(Scene scene,int width,int height){
		if(camera!=null){
			//TODO find update way.
			scene.remove(camera);
		}
		camera = THREE.PerspectiveCamera(35,(double)width/height,1,6000);
		//camera.getPosition().set(0, 0, cameraZ);
		scene.add(camera);
	}
	
	@Override
	public void resized(int width, int height) {
		screenWidth=width;
		screenHeight=height;
		createCamera(scene,width,height);
	}
}
