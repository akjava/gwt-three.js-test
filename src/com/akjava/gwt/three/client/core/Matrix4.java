package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public class Matrix4 extends JavaScriptObject {
protected Matrix4(){}

public native final void setRotationFromEuler(Vector3 vec,String order)/*-{
this.setRotationFromEuler(vec,order);
}-*/;

public native final void setPosition(Vector3 vec)/*-{
this.setPosition(vec);
}-*/;

public final native Matrix4  clone()/*-{
return this.clone();
}-*/;

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

public native final Matrix4 multiply(Matrix4 a,Matrix4 b)/*-{
return this.multiply(a,b);
}-*/;

public native final Matrix4 multiplySelf(Matrix4 b)/*-{
return this.multiply(this,b);
}-*/;

public native final Matrix4 setRotationFromQuaternion(Quaternion q)/*-{
return this.setRotationFromQuaternion(q);
}-*/;


public native final Matrix4 getInverse(Matrix4 b)/*-{
return this.getInverse(b);
}-*/;

public native final Vector3 multiplyVector3(Vector3 vec)/*-{
return this.multiplyVector3(vec);
}-*/;

/**
 * @deprecated
 * @param x
 * @param y
 * @param z
 */
public native final void setRotationX(double thera)/*-{
this.makeRotationX(thera);
}-*/;
/**
 * @deprecated
 * @param x
 * @param y
 * @param z
 */
public native final void setRotationY(double thera)/*-{
this.makeRotationY(thera);
}-*/;
/**
 * @deprecated
 * @param x
 * @param y
 * @param z
 */
public native final void setRotationZ(double thera)/*-{
this.makeRotationZ(thera);
}-*/;
/**
 * @deprecated
 * @param x
 * @param y
 * @param z
 */
public native final void setTranslation(double x,double y,double z)/*-{
this.makeTranslation(x,y,z);
}-*/;

public native final void makeTranslation(double x,double y,double z)/*-{
this.makeTranslation(x,y,z);
}-*/;

public native final Matrix4 lookAt(Vector3 eye,Vector3 center,Vector3 up)/*-{
return this.lookAt(eye,center,up);
}-*/;



}
