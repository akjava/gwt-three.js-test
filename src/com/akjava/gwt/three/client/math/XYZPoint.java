package com.akjava.gwt.three.client.math;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * for spline
 * @author aki
 *
 */
public class XYZPoint extends JavaScriptObject{

	protected XYZPoint(){}
	
	public   final native double getX()/*-{
	return this.x;
	}-*/;
	public   final native double getY()/*-{
	return this.y;
	}-*/;
	public   final native double getZ()/*-{
	return this.y;
	}-*/;
	
	public   final native void setX(double x)/*-{
	 this.x=x;
	}-*/;
	public   final native void setY(double y)/*-{
	 this.y=y;
	}-*/;
	public   final native void setZ(double z)/*-{
	 this.y=y;
	}-*/;
	public   final native void set(double x,double y,double z)/*-{
	this.x=x;
	this.y=y;
	this.z=z;
	}-*/;
	
	public  static final native XYZPoint create(double x,double y,double z)/*-{
	var pt={"x":x,"y":y,"z":z};
	return pt;
	}-*/;
}
