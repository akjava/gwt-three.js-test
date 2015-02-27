package com.akjava.gwt.three.client.gwt.renderers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
/**
 * what is this?
 * @author aki
 *
 */
public class GWTRenderObject extends JavaScriptObject{

	protected GWTRenderObject(){
		
	}
	
	public static GWTRenderObject create(){
		
		return (GWTRenderObject) GWTRenderObject.createObject();
	}
	
	public  native final GWTRenderObject canvas(CanvasElement canvas)/*-{
	this["canvas"]=canvas;
	return this;
	}-*/;
	
	/** what is context?*/
	public  native final GWTRenderObject context(JavaScriptObject context)/*-{
	this["context"]=context;
	return this;
	}-*/;
	
	public  native final GWTRenderObject precision(String precision)/*-{
	this["precision"]=precision;
	return this;
	}-*/;
	
	public  native final GWTRenderObject preserveDrawingBuffer(boolean preserveDrawingBuffer)/*-{
	this["preserveDrawingBuffer"]=preserveDrawingBuffer;
	return this;
	}-*/;
	public  native final GWTRenderObject premultipliedAlpha(boolean premultipliedAlpha)/*-{
	this["premultipliedAlpha"]=premultipliedAlpha;
	return this;
	}-*/;
	public  native final GWTRenderObject antialias(boolean antialias)/*-{
	this["antialias"]=antialias;
	return this;
	}-*/;

	
	public  native final GWTRenderObject alpha(boolean alpha)/*-{
	this["alpha"]=alpha;
	return this;
	}-*/;
	
	public  native final GWTRenderObject stencil()/*-{
	this["stencil"]=true;
	return this;
	}-*/;
	
	public  native final GWTRenderObject depth(boolean depth)/*-{
	this["depth"]=depth;
	return this;
	}-*/;
	
	public  native final GWTRenderObject stencil(boolean stencil)/*-{
	this["stencil"]=stencil;
	return this;
	}-*/;
	
	public  native final GWTRenderObject logarithmicDepthBuffer(boolean logarithmicDepthBuffer)/*-{
	this["logarithmicDepthBuffer"]=logarithmicDepthBuffer;
	return this;
	}-*/;
	
	
	
}
