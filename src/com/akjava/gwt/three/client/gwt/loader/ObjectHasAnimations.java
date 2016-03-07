package com.akjava.gwt.three.client.gwt.loader;

import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ObjectHasAnimations extends JavaScriptObject{
	protected ObjectHasAnimations(){}
	
	public final native JsArray<AnimationClip> getAnimations()/*-{
	return this.animations;
	}-*/;
}
