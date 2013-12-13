package com.akjava.gwt.three.client.gwt.math;


/**
 * i'm afraid this make slow?however i guess using Vector3 all the time will make more slow situation.
 * @author aki
 *
 */
public class XYZ extends XY{

	protected XYZ(){}
	
	public   final native double getZ()/*-{
	return this.z;
	}-*/;
}
