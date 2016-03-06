package com.akjava.gwt.three.client.js.core;

import com.google.gwt.core.client.JavaScriptObject;

public class Channels extends JavaScriptObject{
	protected Channels(){}
	
	public final native double getMask()/*-{
	this.mask;
	}-*/;
	
	public final native void set(int channel)/*-{
	this.set(channel);
	}-*/;
	
	public final native void enable(int channel)/*-{
	this.enable(channel);
	}-*/;
	
	public final native void toggle(int channel)/*-{
	this.toggle(channel);
	}-*/;
	
	public final native void disable(int channel)/*-{
	this.disable(channel);
	}-*/;
}
