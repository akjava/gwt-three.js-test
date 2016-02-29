package com.akjava.gwt.three.client.gwt.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 *  for clone
 * @author aki
 *
 */
public class ThreeObject extends JavaScriptObject{
	protected ThreeObject(){}
	
	public final native ThreeObject clone()/*-{
	return this.clone();
	}-*/;

}
