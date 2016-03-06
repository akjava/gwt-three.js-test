package com.akjava.gwt.three.client.gwt.boneanimation;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class AnimationHierarchyItem extends JavaScriptObject {
	protected AnimationHierarchyItem(){}
	
	public native final int getParent ()/*-{
	return this['parent'];
	}-*/;

	public native final void setParent (int parent)/*-{
	this['parent']=parent;
	}-*/;
	
	public native final JsArray<AnimationKey> getKeys ()/*-{
	return this['keys'];
	}-*/;

	public native final void setKeys (JsArray<AnimationKey> keys)/*-{
	this['keys']=keys;
	}-*/;
}
