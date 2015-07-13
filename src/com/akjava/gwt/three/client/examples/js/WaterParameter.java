package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.textures.Texture;

public class WaterParameter  extends JSParameter {
	protected WaterParameter(){}
	public final static WaterParameter create(){
		return (WaterParameter) WaterParameter.createObject();
	}
	
	public final native WaterParameter textureWidth(int width)/*-{
		this.textureWidth = width;
		return this;
	}-*/;

	public final native WaterParameter textureHeight(int height)/*-{
		this.textureHeight = height;
		return this;
	}-*/;

	public final native WaterParameter clipBias(double clipBias)/*-{
		this.clipBias = clipBias;
		return this;
	}-*/;

	public final native WaterParameter alpha(double alpha)/*-{
		this.alpha = alpha;
		return this;
	}-*/;

	public final native WaterParameter time(double time)/*-{
		this.time = time;
		return this;
	}-*/;

	public final native WaterParameter waterNormals(Texture normalSampler)/*-{
		this.waterNormals = normalSampler;
		return this;
	}-*/;

	public final native WaterParameter sunDirection(Vector3 sunDirection)/*-{
		this.sunDirection = sunDirection;
		return this;
	}-*/;

	public final native WaterParameter sunColor(int sunColor)/*-{
		this.sunColor = sunColor;
		return this;
	}-*/;

	public final native WaterParameter waterColor(int waterColor)/*-{
		this.waterColor = waterColor;
		return this;
	}-*/;

	public final native WaterParameter eye(Vector3 eye)/*-{
		this.eye = eye;
		return this;
	}-*/;

	public final native WaterParameter distortionScale(double distortionScale)/*-{
		this.distortionScale = distortionScale;
		return this;
	}-*/;
}