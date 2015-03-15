package com.akjava.gwt.three.client.examples.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


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
public class Detector extends JavaScriptObject{
	protected Detector() {	
	}

	public static final native boolean webgl()/*-{
	return $wnd.Detector.webgl;
	}-*/;
	
	public static final native boolean addGetWebGLMessage()/*-{
	$wnd.Detector.addGetWebGLMessage();
	}-*/;
	
	public static final native void addGetWebGLMessage(Element parent,String id)/*-{
	$wnd.Detector.addGetWebGLMessage({'parent':parent,'id':id});
	}-*/;
	
}
