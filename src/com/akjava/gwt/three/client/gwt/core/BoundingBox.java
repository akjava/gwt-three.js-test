package com.akjava.gwt.three.client.gwt.core;

import com.akjava.gwt.three.client.math.Vector3;
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
}
