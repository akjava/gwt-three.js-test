package com.akjava.gwt.three.client.gwt.boneanimation.ik;

import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;

public class CDDIK {

	public Matrix4  doStep(Vector3 lastJointPos,Vector3 jointPos,Matrix4 jointRot,Vector3 targetPos){
		
		Vector3 jointVector=lastJointPos.clone().sub(jointPos).normalize();
		
		Vector3 targetVector=targetPos.clone().sub(jointPos).normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		if(angle<= 1.0e-5f){
			return null;
		}
		//LogUtils.log("angle:"+angle+","+Math.toDegrees(angle));
		Vector3 axis=THREE.Vector3().crossVectors(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().makeRotationFromQuaternion(q);
		matrix.multiplyMatrices(jointRot, matrix);
		
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
		
		Vector3 jointVector=lastJointPos.clone().sub(jointPos);	
		
		
		//mx.multiplyVector3(jointVector);
		jointVector.applyProjection(mx);
		
		jointVector.normalize();
		
		Vector3 targetVector=targetPos.clone().sub(jointPos);
		targetVector.applyProjection(mx);
		//mx.multiplyVector3(targetVector);
		
		targetVector.normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		if(angle<= 1.0e-5f){
			return null;
		}
		//LogUtils.log("angle:"+angle+","+Math.toDegrees(angle));
		Vector3 axis=THREE.Vector3().crossVectors(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().makeRotationFromQuaternion(q);
		
		return matrix;
	}

	
public Matrix4  getStepAngleMatrix(Vector3 lastJointPos,Vector3 jointPos,Matrix4 jointRot,Vector3 targetPos){
		
		Vector3 jointVector=lastJointPos.clone().sub(jointPos).normalize();
		
		Vector3 targetVector=targetPos.clone().sub(jointPos).normalize();
		
		double acv=jointVector.dot(targetVector);
		double angle=Math.acos(acv);
		
		if(angle<= 1.0e-5f){
			return null;
		}
		//LogUtils.log("angle:"+angle+","+Math.toDegrees(angle));
		Vector3 axis=THREE.Vector3().crossVectors(jointVector,targetVector);
		axis.normalize();
		Quaternion q=THREE.Quaternion().setFromAxisAngle(axis,angle);
		
		
		
		
		
		
		Matrix4 matrix=THREE.Matrix4().makeRotationFromQuaternion(q);
		
		return matrix;
	}
	
	
	
}
