package com.akjava.gwt.three.client.gwt.animation;

import com.akjava.gwt.three.client.core.Matrix4;
import com.akjava.gwt.three.client.core.Vector3;

public class AngleAndPosition {
public AngleAndPosition(Vector3 angle,Vector3 positions,Matrix4 matrix){
	this.angle=angle;
	this.matrix=matrix;
	this.positions=positions;
}
private Vector3 positions;
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
public AngleAndPosition clone(){
	Vector3 copyVector3=null;
	Vector3 copyPos3=null;
	Matrix4 copyMatrix4=null;
	if(angle!=null){
		copyVector3=angle.clone();
	}
	if(positions!=null){
		copyPos3=positions.clone();
	}
	if(matrix!=null){
		copyMatrix4=matrix.clone();
	}
	return new AngleAndPosition(copyVector3,positions, copyMatrix4);
}
}
