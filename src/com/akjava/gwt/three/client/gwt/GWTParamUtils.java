package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.examples.gwt.geometries.TextGeometryParameter;
import com.akjava.gwt.three.client.gwt.core.MorphTarget;
import com.akjava.gwt.three.client.gwt.core.Offset;
import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshPhongMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.ShaderMaterialParameter;
import com.akjava.gwt.three.client.gwt.renderers.WebGLRenderTargetParameter;
import com.akjava.gwt.three.client.gwt.renderers.WebGLRendererParameter;

//TODO support more?
public class GWTParamUtils {
private GWTParamUtils(){}

public static MeshLambertMaterialParameter MeshLambertMaterial(){
	return MeshLambertMaterialParameter.create();
}

public static MeshBasicMaterialParameter MeshBasicMaterial(){
	return MeshBasicMaterialParameter.create();
}

public static MeshPhongMaterialParameter MeshPhongMaterial(){
	return MeshPhongMaterialParameter.create();
}

public static WebGLRendererParameter WebGLRenderer(){
	return WebGLRendererParameter.create();
}

public static ShaderMaterialParameter ShaderMaterial(){
	return ShaderMaterialParameter.create();
}

public static MorphTarget MorphTarget() {
	return MorphTarget.createObject().cast();
}

public static Offset Offset() {
	return Offset.createObject().cast();
}

public static WebGLRenderTargetParameter WebGLRenderTarget(){
	return WebGLRenderTargetParameter.create();
}

//TODO move example paramutils
public static TextGeometryParameter TextGeometry(){
	return TextGeometryParameter.create();
}



}
