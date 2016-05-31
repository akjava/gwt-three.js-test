package com.akjava.gwt.three.client.gwt.core;

import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;

public class BoundingBox extends JavaScriptObject{
	protected BoundingBox(){
		
	}
	public final native Vector3 getMax()/*-{
	return this.max;
	}-*/;
	public final native Vector3 getMin()/*-{
	return this.min;
	}-*/;
	
	public final native void setMax(Vector3 max)/*-{
	this.max=max;
	}-*/;
	public final native void setMin(Vector3 min)/*-{
	this.min=min;
	}-*/;
}
