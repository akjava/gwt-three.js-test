package com.akjava.gwt.three.client.gwt.renderers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
/**
 * 
 * should i rename
 * @author aki
 *
 */
public class WebGLRendererParameter extends JavaScriptObject{

	protected WebGLRendererParameter(){
		
	}
	
	public static WebGLRendererParameter create(){
		
		return (WebGLRendererParameter) WebGLRendererParameter.createObject();
	}
	
	public  native final WebGLRendererParameter canvas(CanvasElement canvas)/*-{
	this["canvas"]=canvas;
	return this;
	}-*/;
	
	/** what is context?*/
	public  native final WebGLRendererParameter context(JavaScriptObject context)/*-{
	this["context"]=context;
	return this;
	}-*/;
	
	public  native final WebGLRendererParameter precision(String precision)/*-{
	this["precision"]=precision;
	return this;
	}-*/;
	
	public  native final WebGLRendererParameter preserveDrawingBuffer(boolean preserveDrawingBuffer)/*-{
	this["preserveDrawingBuffer"]=preserveDrawingBuffer;
	return this;
	}-*/;
	public  native final WebGLRendererParameter premultipliedAlpha(boolean premultipliedAlpha)/*-{
	this["premultipliedAlpha"]=premultipliedAlpha;
	return this;
	}-*/;
	public  native final WebGLRendererParameter antialias(boolean antialias)/*-{
	this["antialias"]=antialias;
	return this;
	}-*/;

	
	public  native final WebGLRendererParameter alpha(boolean alpha)/*-{
	this["alpha"]=alpha;
	return this;
	}-*/;
	
	public  native final WebGLRendererParameter stencil()/*-{
	this["stencil"]=true;
	return this;
	}-*/;
	
	public  native final WebGLRendererParameter depth(boolean depth)/*-{
	this["depth"]=depth;
	return this;
	}-*/;
	
	public  native final WebGLRendererParameter stencil(boolean stencil)/*-{
	this["stencil"]=stencil;
	return this;
	}-*/;
	
	public  native final WebGLRendererParameter logarithmicDepthBuffer(boolean logarithmicDepthBuffer)/*-{
	this["logarithmicDepthBuffer"]=logarithmicDepthBuffer;
	return this;
	}-*/;
	
	
	
}
