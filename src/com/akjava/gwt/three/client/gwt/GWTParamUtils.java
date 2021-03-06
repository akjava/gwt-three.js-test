package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.gwt.core.MorphTarget;
import com.akjava.gwt.three.client.gwt.core.Offset;
import com.akjava.gwt.three.client.gwt.extras.TextGeometryParameter;
import com.akjava.gwt.three.client.gwt.extras.geometries.ExtrudeGeometryParameter;
import com.akjava.gwt.three.client.gwt.materials.LineBasicMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshPhongMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.PointsMaterialParameter;
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

public static MeshPhongMaterialParameter MeshPhongMaterial(){
	return MeshPhongMaterialParameter.create();
}

public static PointsMaterialParameter PointsMaterial(){
	return PointsMaterialParameter.create();
}

public static LineBasicMaterialParameter LineBasicMaterial() {
	// TODO Auto-generated method stub
	return LineBasicMaterialParameter.create();
}

public static ExtrudeGeometryParameter ExtrudeGeometry() {
	// TODO Auto-generated method stub
	return ExtrudeGeometryParameter.create();
}

}
