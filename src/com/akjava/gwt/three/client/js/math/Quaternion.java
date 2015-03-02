package com.akjava.gwt.three.client.js.math;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;

public class Quaternion extends JavaScriptObject{
protected Quaternion(){}


public final native Quaternion set(double x,double y,double z,double w)/*-{
return this.set(x,y,z,w);
}-*/;

public final native Quaternion copy(Quaternion quaternion)/*-{
return this.copy(quaternion);
}-*/;

public final native Quaternion setFromEuler(Euler euler,boolean update)/*-{
return this.setFromEuler(euler,update);
}-*/;

public final native Quaternion setFromAxisAngle(Vector3 axis,double angle)/*-{
return this.setFromAxisAngle(axis,angle);
}-*/;

public final native Quaternion setFromRotationMatrix(Matrix4 m)/*-{
return this.setFromRotationMatrix(m);
}-*/;

public final native Quaternion inverse()/*-{
return this.inverse();
}-*/;

public final native Quaternion conjugate()/*-{
return this.conjugate();
}-*/;

public final native double lengthSq()/*-{
return this.lengthSq();
}-*/;

public final native double length()/*-{
return this.length();
}-*/;

public final native Quaternion normalize()/*-{
return this.normalize();
}-*/;

public final native Quaternion multiply(Quaternion q)/*-{
return this.multiply(q);
}-*/;

public final native Quaternion multiplyQuaternions(Quaternion a,Quaternion b)/*-{
return this.multiplyQuaternions(a,b);
}-*/;

/**
 * @deprecated
 * @param vector
 * @return
 */
public final native Object multiplyVector3(Vector3 vector)/*-{
return this.multiplyVector3(vector);
}-*/;

public final native Quaternion slerp(Quaternion qb,double t)/*-{
return this.slerp(qb,t);
}-*/;

public final native boolean equals(Quaternion quaternion)/*-{
return this.equals(quaternion);
}-*/;

public final native Quaternion fromArray(JsArrayNumber array)/*-{
return this.fromArray(array);
}-*/;

public final native JsArrayNumber toArray()/*-{
return this.toArray();
}-*/;

public final native Quaternion clone()/*-{
return this.clone();
}-*/;








public static native final Quaternion slerp( Quaternion qa,Quaternion qb,Quaternion qm,double t)/*-{
return $wnd.THREE.Quaternion.slerp( qa, qb, qm, t);
}-*/;

/**
 * @deprecated
 * @return
 */
public native final Quaternion multiplySelf(Quaternion q)/*-{
return this.multiply(q);
}-*/;
/**
 * @deprecated
 * @return
 */
public native final Quaternion multiply(Quaternion q,Quaternion q2)/*-{
return this.multiply(q,q2);
}-*/;


public native final double getX()/*-{
return this.x;
}-*/;
public native final double getY()/*-{
return this.y;
}-*/;
public native final double getZ()/*-{
return this.z;
}-*/;

public native final double getW()/*-{
return this.w;
}-*/;

public native final void setX(double x)/*-{
this.x=x;
}-*/;
public native final void setY(double y)/*-{
this.y=y;
}-*/;
public native final void setZ(double z)/*-{
this.z=z;
}-*/;
public native final void setW(double w)/*-{
this.w=w;
}-*/;

public final native double dot(Vector4 vector)/*-{
return this.dot(vector);
}-*/;

public final native Quaternion fromArray(JsArrayNumber array,int offset)/*-{
return this.fromArray(array,offset);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array)/*-{
return this.toArray(array);
}-*/;

public final native JsArrayNumber toArray(JsArrayNumber array,int offset)/*-{
return this.toArray(array,offset);
}-*/;
}
