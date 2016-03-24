package com.akjava.gwt.three.client.js.animation;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class AnimationObjectGroup extends JavaScriptObject{
	protected AnimationObjectGroup(){}
	
	public final native void add(JavaScriptObject... object)/*-{
	this.add(object);
	}-*/;
	
	public final native void remove(JavaScriptObject... object)/*-{
	this.remove(object);
	}-*/;
	
	public final native void uncache(JavaScriptObject... object)/*-{
	this.uncache(object);
	}-*/;
	
	
	/**
	 * TODO check and implements
	 * @param objects
	 */
	//public final native void add(JsArray<JavaScriptObject> objects)/*-{
	//this.add.apply(this,objects);
	//}-*/;
}
