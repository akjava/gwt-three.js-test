package com.akjava.gwt.three.client.js.renderers;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * what is this?
 * @author aki
 *
 */
public class GWTRenderObject extends JavaScriptObject{

	protected GWTRenderObject(){
		
	}
	
	public static GWTRenderObject create(){
		
		return (GWTRenderObject) GWTRenderObject.createObject();
	}
	
	public  native final GWTRenderObject preserveDrawingBuffer()/*-{
	this["preserveDrawingBuffer"]=true;
	return this;
	}-*/;
	
	
}
