package com.akjava.gwt.three.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

/*
 * i'm not sure 
 * 
 * TODO null check,should rename JSParameter to GWT
 */
public class JSParameter extends JavaScriptObject{
	protected JSParameter(){}
	public final static JSParameter createParameter(){
		return (JSParameter) JSParameter.createObject();
	}
	public final native String getString(String key)/*-{
	return this[key];
	}-*/;
	public final native int getInt(String key)/*-{
	return this[key];
	}-*/;
	public final native double getDouble(String key)/*-{
	return this[key];
	}-*/;
	public final native boolean getBoolean(String key)/*-{
	return this[key];
	}-*/;
	public final native JavaScriptObject getObject(String key)/*-{
	return this[key];
	}-*/;
	
	public final native JSParameter set(String key,String value)/*-{
	return this[key]=value;
	}-*/;
	
	
	public final native JSParameter set(String key,int value)/*-{
	this[key]=value;
	return this;
	}-*/;
	
	public final native JSParameter set(String key,double value)/*-{
	this[key]=value;
	return this;
	}-*/;
	
	public final native JSParameter set(String key,boolean value)/*-{
	this[key]=value;
	return this;
	}-*/;
	
	public final native JSParameter set(String key,JavaScriptObject value)/*-{
	this[key]=value;
	return this;
	}-*/;
	
	//work?
	public  final void setArray(String key,double... values){
		JsArrayNumber arrays=JsArrayNumber.createArray().cast();
		for(double v:values){
			arrays.push(v);
		}
		set(key,arrays);
	}
}
