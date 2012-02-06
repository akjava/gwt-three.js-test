package com.akjava.gwt.three.client.gwt.animation.ik;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Quaternion;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.gwt.GWTThreeUtils;

public class CDDIK {

	public Matrix4  doStep(Vector3 lastJointPos,Vector3 jointPos,Matrix4 jointRot,Vector3 targetPos){
		
		Vector3 jointVector=lastJointPos.clone().subSelf(jointPos).normalize();
		
		Vector3 targetVector=targetPos.clone().subSelf(jointPos).normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		if(angle<= 1.0e-5f){
			return null;
		}
		//LogUtils.log("angle:"+angle+","+Math.toDegrees(angle));
		Vector3 axis=THREE.Vector3().cross(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().setRotationFromQuaternion(q);
		matrix.multiply(jointRot, matrix);
		
		return matrix;
	}
	
	
	//support root rotation
public Matrix4  getStepAngleMatrix(Vector3 parentAngle,Vector3 lastJointPos,Vector3 jointPos,Matrix4 jointRot,Vector3 targetPos){
		Vector3 parentVec=parentAngle.clone().negate();
		
		Matrix4 mx=GWTThreeUtils.degitRotationToMatrix4(parentVec.getX(),parentVec.getY(), parentVec.getZ());
		
		/*
		Vector3 jointPosParent=jointPos.clone();
		mx.multiplyVector3(jointPosParent);
		
		Vector3 jointVector=mx.multiplyVector3(lastJointPos.clone()).subSelf(jointPosParent).normalize();	
		Vector3 targetVector=mx.multiplyVector3(targetPos.clone()).subSelf(jointPosParent).normalize();
		*/
		
		Vector3 jointVector=lastJointPos.clone().subSelf(jointPos);	
		
		mx.multiplyVector3(jointVector);
		
		jointVector.normalize();
		
		Vector3 targetVector=targetPos.clone().subSelf(jointPos);
		
		mx.multiplyVector3(targetVector);
		
		targetVector.normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		if(angle<= 1.0e-5f){
			return null;
		}
		//LogUtils.log("angle:"+angle+","+Math.toDegrees(angle));
		Vector3 axis=THREE.Vector3().cross(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().setRotationFromQuaternion(q);
		
		return matrix;
	}

	
public Matrix4  getStepAngleMatrix(Vector3 lastJointPos,Vector3 jointPos,Matrix4 jointRot,Vector3 targetPos){
		
		Vector3 jointVector=lastJointPos.clone().subSelf(jointPos).normalize();
		
		Vector3 targetVector=targetPos.clone().subSelf(jointPos).normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		if(angle<= 1.0e-5f){
			return null;
		}
		//LogUtils.log("angle:"+angle+","+Math.toDegrees(angle));
		Vector3 axis=THREE.Vector3().cross(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().setRotationFromQuaternion(q);
		
		return matrix;
	}
	
	
	
}
