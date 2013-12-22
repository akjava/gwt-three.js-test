package com.akjava.gwt.three.client.gwt.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @deprecated
 * @author aki
 *
 */
public class XYObject extends XY{

	protected XYObject(){}
	
	public   final native void setX(double x)/*-{
	 this.x=x;
	}-*/;
	public   final native void setY(double y)/*-{
	 this.y=y;
	}-*/;
	public   final native void set(double x,double y)/*-{
	this.x=x;
	this.y=y;
	}-*/;
	
	public  static final native XYObject create(double x,double y)/*-{
	var pt={"x":x,"y":y};
	return pt;
	}-*/;
}
