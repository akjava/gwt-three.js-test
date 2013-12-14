package com.akjava.gwt.three.client.js.math;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
/**
 * for Spline
 * @author aki
 *
 */
public class GWTSplineLength extends JavaScriptObject {
	protected GWTSplineLength() {
	}

	public final native double totalLength ()/*-{
	return this.totalLength;
	}-*/;
	
	public final native JsArrayNumber chunks ()/*-{
	return this.totalLength;
	}-*/;
	
}
