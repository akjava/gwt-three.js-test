package com.akjava.gwt.three.client.js.core;


public class InstancedBufferAttribute extends BufferAttribute{
	protected InstancedBufferAttribute(){}
	
	public final native InstancedBufferAttribute copy()/*-{
	return this.copy();
	}-*/;
	
	
	
	public final native int getMeshPerAttribute()/*-{
	return this.meshPerAttribute;
	}-*/;
}
