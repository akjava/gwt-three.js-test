package com.akjava.gwt.three.client.js.extras.curves;

import com.akjava.gwt.three.client.js.extras.core.GWTCurve3;


public class CatmullRomCurve3 extends GWTCurve3{
	protected CatmullRomCurve3(){}
	
	public final  native boolean getClosed()/*-{
	return this.closed;
	}-*/;

	public final  native void setClosed(boolean  param)/*-{
	this.closed=param;
	}-*/;
}
