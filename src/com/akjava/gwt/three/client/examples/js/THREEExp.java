package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.dom.client.Element;

/*
 * for examples package constructor
 */
public class THREEExp {
	public static final native OrbitControls OrbitControls(Object3D object,Element dom)/*-{
	return new $wnd.THREE.OrbitControls(object,dom);
	}-*/;
}
