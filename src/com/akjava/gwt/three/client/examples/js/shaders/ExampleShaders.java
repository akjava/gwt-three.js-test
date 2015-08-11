package com.akjava.gwt.three.client.examples.js.shaders;

import com.akjava.gwt.three.client.gwt.extras.Shader;

public class ExampleShaders {
private ExampleShaders(){}

public static  native final Shader TriangleBlurShader()/*-{
return $wnd.THREE.TriangleBlurShader;
}-*/;
}
