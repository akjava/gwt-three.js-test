package com.akjava.gwt.three.client.js.core;

public class InstancedBufferGeometry extends BufferGeometry{
	protected InstancedBufferGeometry(){}
	
	//should give a way to access maxInstancedCount?
	
	public final native InstancedBufferGeometry copy()/*-{
	return this.copy();
	}-*/;
	
	//addGroup,i guess instances is int.and same as parent class
	
	
}
