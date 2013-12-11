package com.akjava.gwt.three.client.math;

import com.akjava.gwt.three.client.core.Vector4;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class Matrix4 extends JavaScriptObject {
protected Matrix4(){}

public final native Matrix4 set(double n11,double n12,double n13,double n14,double n21,double n22,double n23,double n24,double n31,double n32,double n33,double n34,double n41,double n42,double n43,double n44)/*-{
return this.set(n11,n12,n13,n14,n21,n22,n23,n24,n31,n32,n33,n34,n41,n42,n43,n44);
}-*/;

public final native Matrix4 identity()/*-{
return this.identity();
}-*/;

public final native Matrix4 copy(Matrix4 m)/*-{
return this.copy(m);
}-*/;

/**
 * @deprecated
 * @param m
 * @return
 */
public final native Matrix4 extractPosition(Object m)/*-{
return this.extractPosition(m);
}-*/;

public final native Matrix4 copyPosition(Matrix4 m)/*-{
return this.copyPosition(m);
}-*/;

public final native Matrix4 makeRotationFromEuler(Euler euler)/*-{
return this.makeRotationFromEuler(euler);
}-*/;

/**
 * @deprecated
 * @param vec
 * @param order
 */
public native final void setRotationFromEuler(Vector3 vec,String order)/*-{
this.setRotationFromEuler(vec,order);
}-*/;


public final native Matrix4 makeRotationFromQuaternion(Quaternion q)/*-{
return this.makeRotationFromQuaternion(q);
}-*/;

public native final Matrix4 lookAt(Vector3 eye,Vector3 center,Vector3 up)/*-{
return this.lookAt(eye,center,up);
}-*/;

/**
 * @deprecated
 * @return
 */
public native final Matrix4 multiply(Matrix4 a,Matrix4 b)/*-{
return this.multiply(a,b);
}-*/;

public native final Matrix4 multiply(Matrix4 a)/*-{
return this.multiply(a);
}-*/;

public final native Matrix4 multiplyMatrices(Matrix4 a,Matrix4 b)/*-{
return this.multiplyMatrices(a,b);
}-*/;

public final native Matrix4 multiplyToArray(Matrix4 a,Matrix4 b,JsArrayNumber r)/*-{
return this.multiplyToArray(a,b,r);
}-*/;

public final native Matrix4 multiplyScalar(double s)/*-{
return this.multiplyScalar(s);
}-*/;



/**
 * @deprecated
 * @return
 */
public final native Object multiplyVector4(Vector4 vector)/*-{
return this.multiplyVector4(vector);
}-*/;

public final native JsArrayNumber multiplyVector3Array(JsArrayNumber array)/*-{
return this.multiplyVector3Array(array);
}-*/;

/**
 * @deprecated
 */
public final native void rotateAxis(Vector3 v)/*-{
this.rotateAxis(v);
}-*/;

/**
 * @deprecated
 */
public final native Vector4 crossVector(Vector4 vector)/*-{
return this.crossVector(vector);
}-*/;

public final native double determinant()/*-{
return this.determinant();
}-*/;

public final native Matrix4 transpose()/*-{
return this.transpose();
}-*/;

public final native JsArrayNumber flattenToArray(JsArrayNumber flat)/*-{
return this.flattenToArray(flat);
}-*/;

public final native JsArrayNumber flattenToArrayOffset(JsArrayNumber flat,int offset)/*-{
return this.flattenToArrayOffset(flat,offset);
}-*/;

public native final void setPosition(Vector3 vec)/*-{
this.setPosition(vec);
}-*/;

public final native Matrix4  clone()/*-{
return this.clone();
}-*/;

/**
 * @deprecated
 * @return
 */
//value is shared usually got a problem
//return THREE.Matrix4.__v1.set( this.n14, this.n24, this.n34 );
public native final Vector3 getPosition()/*-{
return this.getPosition().clone();
}-*/;
public native final Vector3 getColumnX()/*-{
return this.getColumnX().clone();
}-*/;
public native final Vector3 getColumnY()/*-{
return this.getColumnY().clone();
}-*/;
public native final Vector3 getColumnZ()/*-{
return this.getColumnZ().clone();
}-*/;


public native final Matrix4 makeRotationX(double v)/*-{
return this.makeRotationX(v);
}-*/;
public native final Matrix4 makeRotationY(double v)/*-{
return this.makeRotationY(v);
}-*/;
public native final Matrix4 makeRotationZ(double v)/*-{
return this.makeRotationZ(v);
}-*/;


/**
 * @deprecated use multiply
 */
public native final Matrix4 multiplySelf(Matrix4 b)/*-{
return this.multiply(this,b);
}-*/;

/**
 * @deprecated use makeRotationFromQuaternion
 */

public native final Matrix4 setRotationFromQuaternion(Quaternion q)/*-{
return this.setRotationFromQuaternion(q);
}-*/;


public native final Matrix4 getInverse(Matrix4 b)/*-{
return this.getInverse(b);
}-*/;

public native final Matrix4 getInverse(Matrix4 b,boolean throwOnInvertible)/*-{
return this.getInverse(b,throwOnInvertible);
}-*/;

/**
 * @deprecated
 * @return
 */
public native final Vector3 multiplyVector3(Vector3 vec)/*-{
return this.multiplyVector3(vec);
}-*/;



/**
 * @deprecated
 * @param thera
 */
public native final void setRotationX(double thera)/*-{
this.setRotationX(thera);
}-*/;
/**
 * @deprecated
 * @param thera
 */
public native final void setRotationY(double thera)/*-{
this.setRotationY(thera);
}-*/;
/**
 * @deprecated
 * @param thera
 */
public native final void setRotationZ(double thera)/*-{
this.setRotationZ(thera);
}-*/;
/**
 * @deprecated
 * @param thera
 */
public native final void setTranslation(double x,double y,double z)/*-{
this.setTranslation(x,y,z);
}-*/;

public final native Matrix4 scale(double v)/*-{
return this.scale(v);
}-*/;

public final native double getMaxScaleOnAxis()/*-{
return this.getMaxScaleOnAxis();
}-*/;

public final native Matrix4 makeTranslation(double x,double y,double z)/*-{
return this.makeTranslation(x,y,z);
}-*/;



public final native Matrix4 makeRotationAxis(Vector3 axis,double angle)/*-{
return this.makeRotationAxis(axis,angle);
}-*/;

public final native Matrix4 makeScale(double x,double y,double z)/*-{
return this.makeScale(x,y,z);
}-*/;

public final native Matrix4 compose(Vector3 position,Quaternion quaternion,double scale)/*-{
return this.compose(position,quaternion,scale);
}-*/;
public final native Matrix4 decompose(Vector3 position,Quaternion quaternion,double scale)/*-{
return this.decompose(position,quaternion,scale);
}-*/;

public final native Matrix4 makeFrustum(double left,double right,double bottom,double top,double near,double far)/*-{
return this.makeFrustum(left,right,bottom,top,near,far);
}-*/;

public final native Matrix4 makePerspective(double fov,double aspect,double near,double far)/*-{
return this.makePerspective(fov,aspect,near,far);
}-*/;

public final native Matrix4 makeOrthographic(double left,double right,double top,double bottom,double near,double far)/*-{
return this.makeOrthographic(left,right,top,bottom,near,far);
}-*/;

public final native Matrix4 fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;
}
