package com.akjava.gwt.three.client.renderers;

import com.google.gwt.core.client.JavaScriptObject;

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
