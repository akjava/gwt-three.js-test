/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client.js.math;

import com.akjava.gwt.three.client.gwt.math.XYZ;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class Vector3 extends XYZ{
	protected Vector3(){};
	
public final native Vector3 set(double x,double y,double z)/*-{
return this.set(x,y,z);
}-*/;

public final native Vector3 setX(double x)/*-{
return this.setX(x);
}-*/;

public final native Vector3 setY(double y)/*-{
return this.setY(y);
}-*/;

public final native Vector3 setZ(double z)/*-{
return this.setZ(z);
}-*/;

public final native void setComponent(int index,double value)/*-{
this.setComponent(index,value);
}-*/;

public final native double getComponent(int index)/*-{
return this.getComponent(index);
}-*/;

public final native Vector3 copy(Vector3 v)/*-{
return this.copy(v);
}-*/;

public final native Vector3 add(Vector3 v)/*-{
return this.add(v);
}-*/;

/**
 * @deprecated
 * @param v
 * @param w
 * @return
 */
public final native Vector3 add(Vector3 v,Vector3 w)/*-{
return this.add(v,w);
}-*/;

public final native Vector3 addScalar(double s)/*-{
return this.addScalar(s);
}-*/;

public final native Vector3 addVectors(Vector3 a,Vector3 b)/*-{
return this.addVectors(a,b);
}-*/;

public final native Vector3 sub(Vector3 v)/*-{
return this.sub(v);
}-*/;

/**
 * @deprecated
 * @param v
 * @param w
 * @return
 */
public final native Vector3 sub(Vector3 v,Vector3 w)/*-{
return this.sub(v,w);
}-*/;

public final native Vector3 subVectors(Vector3 a,Vector3 b)/*-{
return this.subVectors(a,b);
}-*/;

public final native Vector3 multiply(Vector3 v)/*-{
return this.multiply(v);
}-*/;
/**
 * @deprecated
 * @param v
 * @param w
 * @return
 */
public final native Vector3 multiply(Vector3 v,Vector3 w)/*-{
return this.multiply(v,w);
}-*/;

public final native Vector3 multiplyScalar(double scalar)/*-{
return this.multiplyScalar(scalar);
}-*/;

public final native Vector3 multiplyVectors(Vector3 a,Vector3 b)/*-{
return this.multiplyVectors(a,b);
}-*/;

public final native Vector3 applyMatrix3(Matrix3 m)/*-{
return this.applyMatrix3(m);
}-*/;

public final native Vector3 applyMatrix4(Matrix4 m)/*-{
return this.applyMatrix4(m);
}-*/;

public final native Vector3 applyProjection(Matrix4 m)/*-{
return this.applyProjection(m);
}-*/;

public final native Vector3 applyQuaternion(Quaternion q)/*-{
return this.applyQuaternion(q);
}-*/;

public final native Vector3 transformDirection(Matrix4 m)/*-{
return this.transformDirection(m);
}-*/;

public final native Vector3 divide(Vector3 v)/*-{
return this.divide(v);
}-*/;

public final native Vector3 divideScalar(double scalar)/*-{
return this.divideScalar(scalar);
}-*/;

public final native Vector3 min(Vector3 v)/*-{
return this.min(v);
}-*/;

public final native Vector3 max(Vector3 v)/*-{
return this.max(v);
}-*/;

public final native Vector3 clamp(Vector3 min,Vector3 max)/*-{
return this.clamp(min,max);
}-*/;

public final native Vector3 negate()/*-{
return this.negate();
}-*/;

public final native double dot(Vector3 v)/*-{
return this.dot(v);
}-*/;

public final native double lengthSq()/*-{
return this.lengthSq();
}-*/;

public final native double length()/*-{
return this.length();
}-*/;

public final native double lengthManhattan()/*-{
return this.lengthManhattan();
}-*/;

public final native Vector3 normalize()/*-{
return this.normalize();
}-*/;

public final native Vector3 setLength(double l)/*-{
return this.setLength(l);
}-*/;

public final native Vector3 lerp(Vector3 v,double alpha)/*-{
return this.lerp(v,alpha);
}-*/;

public final native Vector3 cross(Vector3 v)/*-{
return this.cross(v);
}-*/;


/**
 * @deprecated
 * @param v
 * @param w
 * @return
 */
public final native Vector3 cross(Vector3 v,Vector3 w)/*-{
return this.cross(v,w);
}-*/;

public final native Vector3 crossVectors(Vector3 a,Vector3 b)/*-{
return this.crossVectors(a,b);
}-*/;

public final native double angleTo(Vector3 v)/*-{
return this.angleTo(v);
}-*/;

public final native double distanceTo(Vector3 v)/*-{
return this.distanceTo(v);
}-*/;

public final native double distanceToSquared(Vector3 v)/*-{
return this.distanceToSquared(v);
}-*/;

/**
 * @deprecated
 * @param m
 * @param order
 */
public final native void setEulerFromRotationMatrix(Vector3 m,String order)/*-{
this.setEulerFromRotationMatrix(m,order);
}-*/;

/**
 * @deprecated
 * @param q
 * @param order
 */
public final native void setEulerFromQuaternion(Quaternion q,String order)/*-{
this.setEulerFromQuaternion(q,order);
}-*/;

/**
 * @deprecated after r64
 * use setFromMatrixPosition
 * @param m
 * @return
 */
public final native Vector3 getPositionFromMatrix(Matrix4 m)/*-{
return this.getPositionFromMatrix(m);
}-*/;

public final native Vector3 setFromMatrixPosition(Matrix4 m)/*-{
return this.setFromMatrixPosition(m);
}-*/;
/**
 * @deprecated after r64
 * use setFromMatrixScale
 * @param m
 * @return
 */
public final native Vector3 getScaleFromMatrix(Matrix4 m)/*-{
return this.getScaleFromMatrix(m);
}-*/;

public final native Vector3 setFromMatrixScale(Matrix4 m)/*-{
return this.setFromMatrixScale(m);
}-*/;

/**
 * @deprecated after r64
 * use setFromMatrixColumn
 * @param m
 * @return
 */
public final native Vector3 getColumnFromMatrix(int index,Matrix4 matrix)/*-{
return this.getColumnFromMatrix(index,matrix);
}-*/;

public final native Vector3 setFromMatrixColumn(int index,Matrix4 matrix)/*-{
return this.setFromMatrixColumn(index,matrix);
}-*/;


public final native boolean equals(Vector3 v)/*-{
return this.equals(v);
}-*/;

public final native Vector3 fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;

public final native Vector3 clone()/*-{
return this.clone();
}-*/;

public final native Vector3 applyEuler(Euler euler)/*-{
return this.applyEuler(euler);
}-*/;

public final native Vector3 applyAxisAngle(Vector3 axis,double angle)/*-{
return this.applyAxisAngle(axis,angle);
}-*/;

public final native Vector3 projectOnVector(Vector3 vector)/*-{
return this.projectOnVector(vector);
}-*/;

public final native Vector3 projectOnPlane(Vector3 vector)/*-{
return this.projectOnPlane(vector);
}-*/;

public final native Vector3 reflect(Vector3 vector)/*-{
return this.reflect(vector);
}-*/;
	


public native final void gwtIncrementX(double x)/*-{
this.x+=x;
}-*/;

public native final void gwtIncrementY(double y)/*-{
this.y+=y;
}-*/;

public native final void gwtIncrementZ(double z)/*-{
this.z+=z;
}-*/;

public native final void gwtDecrementX(double x)/*-{
this.x-=x;
}-*/;

public native final void gwtDecrementY(double y)/*-{
this.y-=y;
}-*/;

public native final void gwtDecrementZ(double z)/*-{
this.z-=z;
}-*/;

public native final void gwtSet(int index,double value)/*-{
if(index==0){
	this.x=value;
}else if(index==1){
	this.y=value;
}else if(index==2){
	this.z=value;
}
}-*/;

public native final int gwtGet(int index)/*-{
if(index==0){
	return this.x;
}else if(index==1){
	return this.y;
}else {
	return this.z;
}
}-*/;







/**
 * @deprecated
 * @param vec3
 * @return
 */
public native final Vector3 addSelf(Vector3 vec3)/*-{
return this.add(vec3);
}-*/;

/**
 * @deprecated
 * @return
 */
public native final Vector3 subSelf(Vector3 vec3)/*-{
return this.sub(vec3);
}-*/;












/**
 * @deprecated
 * @return
 */
public native final Vector3 crossSelf(Vector3 vec3)/*-{
return this.cross(vec3);
}-*/;




public final Vector3 getRotationFromMatrix(Matrix4 matrix){
	return getRotationFromMatrix(matrix,"XYZ");
}
//public static Euler dummy_euler;
public  final synchronized Vector3 getRotationFromMatrix(Matrix4 matrix,String order){
	//if(dummy_euler==null){
	Euler	dummy_euler=THREE.Euler(0,0,0,order);
	//}
	dummy_euler.setFromRotationMatrix(matrix, order);
	set(dummy_euler.getX(),dummy_euler.getY(), dummy_euler.getZ());
	return this;
}
/**
 * @deprecated
 * @param matrix
 * @return
 */
//public native final Vector3 getRotationFromMatrix(Matrix4 matrix)/*-{
//return this.setEulerFromRotationMatrix(matrix,'XYZ');
//}-*/;

//public native final Vector3 setEulerFromRotationMatrix(Matrix4 matrix,String order)/*-{
//return this.setEulerFromRotationMatrix(matrix,order);
//}-*/;

/**
 * @deprecated
 * @param vec3
 */
public native final void divideSelf(Vector3 vec3)/*-{
this.divide(vec3);
}-*/;

public final native Vector3 clampScalar(double minVal,double maxVal)/*-{
return this.clampScalar(minVal,maxVal);
}-*/;

public final native Vector3 floor()/*-{
return this.floor();
}-*/;

public final native Vector3 ceil()/*-{
return this.ceil();
}-*/;

public final native Vector3 round()/*-{
return this.round();
}-*/;

public final native Vector3 roundToZero()/*-{
return this.roundToZero();
}-*/;

public final native Vector3 fromArray(JsArrayNumber array,int offset)/*-{
return this.fromArray(array,offset);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array)/*-{
return this.toArray(array);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array,int offset)/*-{
return this.toArray(array,offset);
}-*/;

public final native Vector3 project(Camera camera)/*-{

return this.project(camera);

}-*/;
public final native Vector3 unproject(Camera camera)/*-{

return this.unproject(camera);

}-*/;

public final native Vector3 fromAttribute(JavaScriptObject attribute,int index,int offset)/*-{
return this.fromAttribute(attribute,index,offset);
}-*/;

public final native Vector3 subScalar(double s)/*-{
return this.subScalar(s);
}-*/;

public final native Vector3 lerpVectors(Vector3 v,Vector3 v2,double alpha)/*-{
return this.lerpVectors(v,v2,alpha);
}-*/;

public final native Vector3 addScaledVector(Vector3 value,double s)/*-{
return this.addScaledVector(value,s);
}-*/;

public final native Vector3 clampLength(double min,double max)/*-{
return this.clampLength(min,max);
}-*/;

public final  native Vector3 setScalar(double  param)/*-{
return this.setScalar(param);
}-*/;
}

