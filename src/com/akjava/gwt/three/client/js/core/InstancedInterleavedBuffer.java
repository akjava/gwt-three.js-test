package com.akjava.gwt.three.client.js.core;

public class InstancedInterleavedBuffer extends InterleavedBuffer{
	protected InstancedInterleavedBuffer(){}
	
	public final native int getMeshPerAttribute()/*-{
	return this.meshPerAttribute;
	}-*/;
	
	public final  native void  copy(InstancedInterleavedBuffer  param)/*-{
	 this.copy(param);
	}-*/;
	
	//InterleavedBuffer has clone(),can't overwrite.clone().cast();
	public final  native InstancedInterleavedBuffer  cloneAsInstancedInterleavedBuffer()/*-{
	 return clone();
	}-*/;
}
