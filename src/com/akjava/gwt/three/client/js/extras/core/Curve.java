package com.akjava.gwt.three.client.js.extras.core;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class Curve extends JavaScriptObject{
	protected Curve(){}
	
	public final native double getLength()/*-{
	return this.getLength();
	}-*/;

	public final native JsArrayNumber getLengths(double divisions)/*-{
	return this.getLengths(divisions);
	}-*/;

	public final native void updateArcLengths()/*-{
	this.updateArcLengths();
	}-*/;

	public final native double getUtoTmapping(double u,double distance)/*-{
	return this.getUtoTmapping(u,distance);
	}-*/;
}
