package com.akjava.gwt.three.client.gwt.animation.ik;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Quaternion;
import com.akjava.gwt.three.client.core.Vector3;

public class CDDIK {

	public Matrix4  doStep(Vector3 lastJointPos,Vector3 jointPos,Matrix4 jointRot,Vector3 targetPos){
		
		Vector3 jointVector=lastJointPos.clone().subSelf(jointPos).normalize();
		
		Vector3 targetVector=targetPos.clone().subSelf(jointPos).normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		Vector3 axis=THREE.Vector3().cross(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().setRotationFromQuaternion(q);
		
		
		Vector3 vec=THREE.Vector3();
		vec.setRotationFromMatrix(matrix);
		//do limit rotation
		
		matrix.setRotationFromEuler(vec, "XYZ");
		matrix.multiply(jointRot, matrix);
		
		return matrix;
	}
}
