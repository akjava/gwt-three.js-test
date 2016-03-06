package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.textures.DataTexture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;

public class ImageUtils extends JavaScriptObject{
	protected ImageUtils(){}

	public static final native CanvasElement getNormalMap(ImageElement image,int depth)/*-{
	return $wnd.THREE.ImageUtils.getNormalMap(image,depth);
	}-*/;

	public static final native DataTexture generateDataTexture(int width,int height,Color color)/*-{
	return $wnd.THREE.ImageUtils.generateDataTexture(width,height,color);
	}-*/;
}
