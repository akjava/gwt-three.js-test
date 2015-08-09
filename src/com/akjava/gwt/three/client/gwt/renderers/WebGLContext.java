package com.akjava.gwt.three.client.gwt.renderers;

import com.google.gwt.core.client.JavaScriptObject;

public class WebGLContext extends JavaScriptObject{

	/**
	 * only implement method used often in three.js
	 */
	protected WebGLContext(){}
	
	public  native final boolean getExtension(String name)/*-{
	return this.getExtension(name);
	}-*/;
}
