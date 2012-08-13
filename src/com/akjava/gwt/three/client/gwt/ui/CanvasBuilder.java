package com.akjava.gwt.three.client.gwt.ui;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;

public class CanvasBuilder extends WebGLBuilder{
	
	WebGLRenderer createRenderer(){
		return THREE.CanvasRenderer();
	}
}
