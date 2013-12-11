package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.gwt.GWTThreeUtils;
import com.akjava.gwt.three.client.math.Matrix4;
import com.akjava.gwt.three.client.math.Vector3;

public class AngleAndPosition {
public AngleAndPosition(Vector3 angle,Vector3 positions,Matrix4 matrix){
	this.angle=angle;
	this.matrix=matrix;
	this.position=positions;
}
private Vector3 position;
public Vector3 getPosition() {
	return position;
}
public void setPosition(Vector3 positions) {
	this.position = positions;
}
private Vector3 angle;
private Matrix4 matrix;
public Vector3 getAngle() {
	return angle;
}
public void setAngle(Vector3 angle) {
	this.angle = angle;
}
public Matrix4 getMatrix() {
	return matrix;
}
public void setMatrix(Matrix4 matrix) {
	this.matrix = matrix;
}

public void updateMatrix(){
	matrix=THREE.Matrix4();
	matrix.setTranslation(position.getX(), position.getY(), position.getZ());
	matrix.setRotationFromEuler(GWTThreeUtils.degreeToRagiant(angle), "XYZ");
}

public AngleAndPosition clone(){
	Vector3 copyVector3=null;
	Vector3 copyPos3=null;
	Matrix4 copyMatrix4=null;
	if(angle!=null){
		copyVector3=angle.clone();
	}
	if(position!=null){
		copyPos3=position.clone();
	}
	if(matrix!=null){
		copyMatrix4=matrix.clone();
	}
	return new AngleAndPosition(copyVector3,copyPos3, copyMatrix4);
}
}
