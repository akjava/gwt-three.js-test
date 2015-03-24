package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshPhongMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.ShaderMaterialParameter;
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


}
