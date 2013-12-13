package com.akjava.gwt.three.client.gwt.math;

import com.google.gwt.core.client.JavaScriptObject;


public class XY extends JavaScriptObject{

	protected XY(){}
	
	public   final native double getX()/*-{
	return this.x;
	}-*/;
	public   final native double getY()/*-{
	return this.y;
	}-*/;
	
}
