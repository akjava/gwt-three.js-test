package com.akjava.gwt.threetest.client;

import com.akjava.gwt.three.client.gwt.materials.MeshBasicMaterialParameter;
import com.akjava.gwt.three.client.gwt.materials.MeshLambertMaterialParameter;

public class GWTMaterialParamUtils {
private GWTMaterialParamUtils(){}

public static MeshLambertMaterialParameter MeshLambertMaterial(){
	return MeshLambertMaterialParameter.create();
}

public static MeshBasicMaterialParameter MeshBasicMaterial(){
	return MeshBasicMaterialParameter.create();
}

}
