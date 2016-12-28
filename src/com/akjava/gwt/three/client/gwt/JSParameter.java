package com.akjava.gwt.three.client.gwt;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayBoolean;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

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
	
	
	public final native JsArrayString getArrayString(String key)/*-{
	return this[key];
	}-*/;
	
	public final native JsArrayNumber getArrayNumber(String key)/*-{
	return this[key];
	}-*/;
	public final native JsArrayBoolean getArrayBoolean(String key)/*-{
	return this[key];
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
	
	public final native JsArrayString getKeys()/*-{
	return $wnd.Object.keys(this);
	}-*/;
	
	public final native boolean exists(String key)/*-{
	return this[key]!=undefined && this[key]!=null;
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
