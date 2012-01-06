package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Vector3;

public class GWTUtils {

	/*
	 * get angle from p1 to p2 ,use Z vector 
	 */
	public Vector3 getRotation(Vector3 p1,Vector3 p2){
	Vector3 up=THREE.Vector3(0, 1, 0);
	Matrix4 mx=THREE.Matrix4();
	mx.lookAt(p2,p1,up);
	
	Vector3 ret=THREE.Vector3();
	ret.setRotationFromMatrix(mx);
	return ret;
	}
}
