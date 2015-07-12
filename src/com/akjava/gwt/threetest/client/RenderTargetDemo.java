package com.akjava.gwt.threetest.client;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

/**
 * not complete
 * @author aki
 *
 */
public class RenderTargetDemo extends AbstractDemo{



	Camera camera;
	Scene scene;
	WebGLRenderer renderer;

	Mesh cube;
	Mesh plane;

	double targetRotation = 0;
	double targetRotationOnMouseDown = 0;

	int mouseX = 0;
	int mouseXOnMouseDown = 0;

	int windowHalfX ;
	int windowHalfY ;

	

@Override
public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
	super.start(renderer, width, height, panel);
	renderer.setClearColor(0xffffff, 1);
	windowHalfX=width/2;
	windowHalfY=height/2;
	this.renderer=renderer;

scene = THREE.Scene();

camera = THREE.PerspectiveCamera( 90,1, 1, 1000 );
camera.getPosition().setY( 150);
camera.getPosition().setZ( 500);
scene.add( camera );


Geometry geometry=THREE.BoxGeometry( 200, 200, 200);
for(int i=0;i<geometry.faces().length();i++){
	geometry.faces().get(i).getColor().setHex((int) (Math.random() * 0xffffff));
}
cube = THREE.Mesh(geometry , THREE.MeshBasicMaterial(
		MeshBasicMaterialParameter.create().vertexColors(THREE.FaceColors))
		);


cube.getPosition().setY( 150);
scene.add( cube );

// Plane




 plane = THREE.Mesh( THREE.PlaneBufferGeometry( 200, 200 ),
THREE.MeshBasicMaterial(MeshBasicMaterialParameter.create().color( 0xe0e0e0 ).overdraw(true)));
 plane.getGeometry().applyMatrix(THREE.Matrix4().makeRotationX( - Math.PI / 2 ) );
scene.add( plane );



WebGLRenderTarget target=THREE.WebGLRenderTarget(256, 256, null);
WebGLRenderTarget target2=THREE.WebGLRenderTarget(256, 256, null);



//test

renderer.render(scene, camera, target, true);
LogUtils.log(toDataUrl(renderer.getContext(),target.getWebglTexture(),256,256));

//renderer.render(scene, camera);

camera.getRotation().setZ(Math.PI);//flip texture
//camera.getRotation().setX(Math.PI/2);

camera.updateMatrix();
renderer.render(scene, camera, target2, true);
LogUtils.log(toDataUrl(renderer.getContext(),target2.getWebglTexture(),256,256));


	

Timer timer = new Timer(){
	public void run(){
		MainWidget.stats.begin();
		render();
		MainWidget.stats.end();
	}
};

startTimer(timer);
}

public void onMouseDown(MouseDownEvent event) {
	super.onMouseDown(event);
	
	mouseXOnMouseDown = event.getX() - windowHalfX;
	targetRotationOnMouseDown = targetRotation;
}


public void onMouseMove(MouseMoveEvent event) {
	super.onMouseMove(event);
	if(mouseDown){
	mouseX = event.getX() - windowHalfX;

	targetRotation = targetRotationOnMouseDown + ( mouseX - mouseXOnMouseDown ) * 0.02;
	}
}


public static final native String toDataUrl(JavaScriptObject gl, JavaScriptObject texture, int width, int height)/*-{
  // Create a framebuffer backed by the texture
			    var framebuffer = gl.createFramebuffer();
			    gl.bindFramebuffer(gl.FRAMEBUFFER, framebuffer);
			    gl.framebufferTexture2D(gl.FRAMEBUFFER, gl.COLOR_ATTACHMENT0, gl.TEXTURE_2D, texture, 0);

			    // Read the contents of the framebuffer
			    var data = new Uint8Array(width * height * 4);
			    gl.readPixels(0, 0, width, height, gl.RGBA, gl.UNSIGNED_BYTE, data);

			    gl.deleteFramebuffer(framebuffer);

			    // Create a 2D canvas to store the result 
			    var canvas = document.createElement('canvas');
			    canvas.width = width;
			    canvas.height = height;
			    var context = canvas.getContext('2d');

			    // Copy the pixels to a 2D canvas
			    var imageData = context.createImageData(width, height);
			    imageData.data.set(data);
			    context.putImageData(imageData, 0, 0);

			    return canvas.toDataURL();
}-*/;



public void render() {
	double rot= cube.getRotation().getY() +( targetRotation - cube.getRotation().getY() ) * 0.05;
	plane.getRotation().setY(rot);
	cube.getRotation().setY(rot);
	renderer.render( scene, camera );
}

@Override
public String getName() {
	return "RenderTarget";
}

@Override
public String getHowToHtml() {
	return "GWt version of <a href='http://mrdoob.github.com/three.js/examples/canvas_geometry_cube.html' target='threejs'>canvas_geometry_cube</a>";
}
}
