package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.examples.js.controls.MouseControls;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.examples.js.controls.VRControls;
import com.akjava.gwt.three.client.examples.js.controls.VRControls.VRControlCallbackHandler;
import com.akjava.gwt.three.client.examples.js.effects.StereoEffect;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/*
 * for examples package constructor
 */
public class THREEExp {
	public static final native OrbitControls OrbitControls(Object3D object,Element dom)/*-{
	return new $wnd.THREE.OrbitControls(object,dom);
	}-*/;
	
	public static final native MouseControls MouseControls(Object3D object)/*-{
	return new $wnd.THREE.MouseControls(object);
	}-*/;
	
	
	public static final native VRControls VRControls(Object3D object)/*-{
	return new $wnd.THREE.VRControls(object);
	}-*/;
	
	public static final native VRControls VRControls(Object3D object,VRControlCallbackHandler handler)/*-{
	return new $wnd.THREE.VRControls(object,function ( message ) {
		handler.@com.akjava.gwt.three.client.examples.js.controls.VRControls$VRControlCallbackHandler::callback(Ljava/lang/String;)(message);
		});
	}-*/;
	
/**
 * 
 * @param renderer only WebGLRenderer support on this lib
 * @return
 */
	public static final native StereoEffect StereoEffect(WebGLRenderer renderer)/*-{
	return new $wnd.THREE.StereoEffect(renderer);
	}-*/;
	
	//need Mirror.js
	public static final native Mirror Mirror(WebGLRenderer renderer,Camera camera,JavaScriptObject options)/*-{
	return new $wnd.THREE.Mirror(renderer,camera,options);
	}-*/;
	
}
