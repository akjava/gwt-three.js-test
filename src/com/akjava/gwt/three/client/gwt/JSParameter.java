package com.akjava.gwt.three.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;

/*
 * i'm not sure 
 */
public class JSParameter extends JavaScriptObject{
	protected JSParameter(){}
	public final static JSParameter createParameter(){
		return (JSParameter) JSParameter.createObject();
	}
	public final native String getString(String key)/*-{
	return this[key]=value;
	}-*/;
	public final native int getInt(String key)/*-{
	return this[key]=value;
	}-*/;
	public final native double getDouble(String key)/*-{
	return this[key]=value;
	}-*/;
	public final native boolean getBoolean(String key)/*-{
	return this[key]=value;
	}-*/;
	public final native JavaScriptObject getObject(String key)/*-{
	return this[key]=value;
	}-*/;
	
	public final native void set(String key,String value)/*-{
	return this[key]=value;
	}-*/;
	
	
	public final native void set(String key,int value)/*-{
	this[key]=value;
	}-*/;
	
	public final native void set(String key,double value)/*-{
	this[key]=value;
	}-*/;
	
	public final native void set(String key,boolean value)/*-{
	this[key]=value;
	}-*/;
	
	public final native void set(String key,JavaScriptObject value)/*-{
	this[key]=value;
	}-*/;
}
