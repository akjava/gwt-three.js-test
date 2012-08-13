package com.akjava.gwt.three.client.gwt.ui;

import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.google.gwt.core.client.GWT;

public class RendererBuilder {

	public static WebGLRenderer createRenderer(){
		WebGLBuilder builder=GWT.create(WebGLBuilder.class);
		return builder.createRenderer();
	}
}
