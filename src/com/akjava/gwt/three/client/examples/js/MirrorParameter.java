package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.gwt.JSParameter;

public class MirrorParameter  extends JSParameter {
	protected MirrorParameter(){}
	public final static MirrorParameter create(){
		return (MirrorParameter) MirrorParameter.createObject();
	}
	
	public final native MirrorParameter textureWidth(double textureWidth)/*-{
	this.textureWidth=textureWidth;
	return this;
	}-*/;
	public final native MirrorParameter textureHeight(double textureHeight)/*-{
	this.textureHeight=textureHeight;
	return this;
	}-*/;
	
	public final native MirrorParameter clipBias(double clipBias)/*-{
	this.clipBias=clipBias;
	return this;
	}-*/;
	
	public final native MirrorParameter color(int color)/*-{
	this.color=color;
	return this;
	}-*/;
}
