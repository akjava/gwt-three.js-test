package com.akjava.gwt.three.client.gwt.core;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.google.gwt.core.client.JavaScriptObject;

public class ThreeEvent extends JavaScriptObject{
protected ThreeEvent(){}
	
	public final native String getType()/*-{
	return this.type;
	}-*/;
	
	public final native Scene getScene()/*-{
	return this.scene;
	}-*/;
	
	public final native Object3D getObject()/*-{
	return this.object;
	}-*/;
	
}
