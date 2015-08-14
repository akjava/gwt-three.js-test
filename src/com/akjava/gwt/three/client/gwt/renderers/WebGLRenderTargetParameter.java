package com.akjava.gwt.three.client.gwt.renderers;

import com.google.gwt.core.client.JavaScriptObject;

public class WebGLRenderTargetParameter extends JavaScriptObject{

	protected WebGLRenderTargetParameter(){}
	
public static WebGLRenderTargetParameter create(){
		
		return (WebGLRenderTargetParameter) WebGLRenderTargetParameter.createObject();
	}


public  native final WebGLRenderTargetParameter minFilter(int minFilter)/*-{
this["minFilter"]=minFilter;
return this;
}-*/;

public  native final WebGLRenderTargetParameter magFilter(int magFilter)/*-{
this["magFilter"]=magFilter;
return this;
}-*/;

public  native final WebGLRenderTargetParameter format(int format)/*-{
this["format"]=format;
return this;
}-*/;

public  native final WebGLRenderTargetParameter stencilBuffer(boolean stencilBuffer)/*-{
this["stencilBuffer"]=stencilBuffer;
return this;
}-*/;
}

