package com.akjava.gwt.three.client.gwt.ui;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;

public class WebGLBuilder {
	WebGLRenderer createRenderer(){
		return THREE.WebGLRenderer();
	}
}
