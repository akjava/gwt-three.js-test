package com.akjava.gwt.three.client.examples.js.shaders;

import com.akjava.gwt.three.client.gwt.extras.Shader;

public class ExampleShaders {
private ExampleShaders(){}

public static  native final Shader TriangleBlurShader()/*-{
return $wnd.THREE.TriangleBlurShader;
}-*/;

public static  native final Shader DotScreenShader()/*-{
return $wnd.THREE.DotScreenShader;
}-*/;

public static  native final Shader RGBShiftShader()/*-{
return $wnd.THREE.RGBShiftShader;
}-*/;

public static  native final Shader CopyShader()/*-{
return $wnd.THREE.CopyShader;
}-*/;

public static  native final Shader BleachBypassShader()/*-{
return $wnd.THREE.BleachBypassShader;
}-*/;

public static  native final Shader SepiaShader()/*-{
return $wnd.THREE.SepiaShader;
}-*/;

public static  native final Shader VignetteShader()/*-{
return $wnd.THREE.VignetteShader;
}-*/;

public static  native final Shader HorizontalBlurShader()/*-{
return $wnd.THREE.HorizontalBlurShader;
}-*/;
public static  native final Shader VerticalBlurShader()/*-{
return $wnd.THREE.VerticalBlurShader;
}-*/;
public static  native final Shader ColorifyShader()/*-{
return $wnd.THREE.ColorifyShader;
}-*/;

//TODO implement all
}
