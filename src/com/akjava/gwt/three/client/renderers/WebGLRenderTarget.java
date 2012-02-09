package com.akjava.gwt.three.client.renderers;

import com.google.gwt.core.client.JavaScriptObject;

/*
 * not complete yet
 */
public class WebGLRenderTarget extends JavaScriptObject{

	protected WebGLRenderTarget(){}
	
	public  native final double getWidth()/*-{
	return this.width;
	}-*/;
	
	public  native final void getHeight()/*-{
	return this.height;
	}-*/;
}
