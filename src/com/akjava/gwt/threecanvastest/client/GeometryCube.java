package com.akjava.gwt.threecanvastest.client;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.cameras.Camera;
import com.akjava.gwt.three.client.core.Color;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.extras.ImageUtils;
import com.akjava.gwt.three.client.gwt.ThreeLog;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.materials.MeshBasicMaterialBuilder;
import com.akjava.gwt.three.client.objects.Mesh;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.scenes.Scene;
import com.akjava.gwt.three.client.textures.Texture;
import com.akjava.gwt.threecanvastest.client.birds.Bird;
import com.akjava.gwt.threecanvastest.client.birds.Boid;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class GeometryCube extends AbstractDemo{



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
	windowHalfX=width/2;
	windowHalfY=height/2;
	this.renderer=renderer;

scene = THREE.Scene();

camera = THREE.PerspectiveCamera( 70, width / height, 1, 1000 );
camera.getPosition().setY( 150);
camera.getPosition().setZ( 500);
scene.add( camera );

// Cube

JsArray<Material> materials = (JsArray<Material>) JsArray.createArray();



for ( int i = 0; i < 6; i ++ ) {

materials.push( THREE.MeshBasicMaterial().overdraw(true).color( Math.random() * 0xffffff ).build() );

}

cube = THREE.Mesh( THREE.CubeGeometry( 200, 200, 200, 1, 1, 1, materials ), THREE.MeshFaceMaterial() );

cube.getPosition().setY( 150);
scene.add( cube );

// Plane




 plane = THREE.Mesh( THREE.PlaneGeometry( 200, 200 ),
THREE.MeshBasicMaterial(). color( 0xe0e0e0 ).overdraw(true).build() );
 plane.getGeometry().applyMatrix(THREE.Matrix4().makeRotationX( - Math.PI / 2 ) );
scene.add( plane );




	

Timer timer = new Timer(){
	public void run(){
		MainWidget.stats.begin();
		render();
		MainWidget.stats.end();
	}
};

startTimer(timer);
}

public static native final JavaScriptObject tmp(Texture texture)/*-{
return {overdraw:true,map:texture};
}-*/;

public static native final Material material(Texture texture)/*-{
return new $wnd.THREE.MeshBasicMaterial({overdraw:true,map:texture});
}-*/;


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





public void render() {
	double rot= cube.getRotation().getY() +( targetRotation - cube.getRotation().getY() ) * 0.05;
	plane.getRotation().setY(rot);
	cube.getRotation().setY(rot);
	renderer.render( scene, camera );
}

@Override
public String getName() {
	return "Geometry Cube";
}

@Override
public String getHowToHtml() {
	return "GWt version of <a href='http://mrdoob.github.com/three.js/examples/canvas_geometry_cube.html' target='threejs'>canvas_geometry_cube</a>";
}
}
