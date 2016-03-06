package com.akjava.gwt.three.client.gwt.animation;

import com.google.gwt.core.client.JavaScriptObject;

public class KeyframeTrackKey extends JavaScriptObject{
	protected KeyframeTrackKey(){}
	
	public final native double getTime()/*-{
	return this.time;
	}-*/;
	
	public final native void setTime(double time)/*-{
	this.time=time;
	}-*/;
	

	public static final native KeyframeTrackKey create(double value,double time)/*-{
	return {value:value,time:time};
	}-*/;
	
	public static final native KeyframeTrackKey create(String value,double time)/*-{
	return {value:value,time:time};
	}-*/;
	
	public static final native KeyframeTrackKey create(boolean value,double time)/*-{
	return {value:value,time:time};
	}-*/;
	
	public static final native KeyframeTrackKey create(JavaScriptObject value,double time)/*-{
	return {value:value,time:time};
	}-*/;
	
	public final native void setValue(double value)/*-{
	this.value=value;
	}-*/;
	
	public final native void setValue(String value)/*-{
	this.value=value;
	}-*/;
	
	public final native void setValue(boolean value)/*-{
	this.value=value;
	}-*/;
	
	public final native void setValue(JavaScriptObject value)/*-{
	this.value=value;
	}-*/;
	
	//TODO how to get?
	
}
