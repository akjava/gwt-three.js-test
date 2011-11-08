package com.akjava.gwt.three.client.materials;


public class ParticleBasicMaterial extends Material{
	protected ParticleBasicMaterial(){}
	public final native void setSize(double size)/*-{
	this.size=size;
	}-*/;

	public final native double getSize()/*-{
	return this.size;
	}-*/;
}
