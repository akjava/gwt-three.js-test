package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;


/**
 * This is Detector.js for GWT
 * 
 * even if you call addGetWebGLMessage() manually,message will show only Webgl is not supported
 * 
 *  see in Detector.js
 *  if ( ! this.webgl ) {
 * 
 * @author aki
 *
 */

/**
 * Detector.js Authors
 * @author alteredq / http://alteredqualia.com/
 * @author mr.doob / http://mrdoob.com/
 */
public class Mirror extends Object3D{
	protected Mirror() {	
	}


	
	public  final native void renderWithMirror(Mirror otherMirror)/*-{
	this.renderWithMirror(otherMirror);
	}-*/;

	public  final native void updateTextureMatrix()/*-{
	this.updateTextureMatrix();
	}-*/;

	public  final native void render()/*-{
	this.render();
	}-*/;

	public  final native void renderTemp()/*-{
	this.renderTemp();
	}-*/;
	
	public  final native Material getMaterial()/*-{
	return this.material;
	}-*/;
}
