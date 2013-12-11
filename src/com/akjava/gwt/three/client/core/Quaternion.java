package com.akjava.gwt.three.client.core;

import com.akjava.gwt.three.client.math.Matrix4;
import com.google.gwt.core.client.JavaScriptObject;

public class Quaternion extends JavaScriptObject{
protected Quaternion(){}

public native final Quaternion setFromRotationMatrix(Matrix4 b)/*-{
return this.setFromRotationMatrix(b);
}-*/;

public native final Quaternion setFromAxisAngle(Vector3 axis,double angle)/*-{
return this.setFromAxisAngle(axis,angle);
}-*/;




public native final Quaternion slerp( Quaternion qa,Quaternion qb,Quaternion qm,double t)/*-{
return $wnd.THREE.Quaternion.slerp( qa, qb, qm, t);
}-*/;

public native final Quaternion multiplySelf(Quaternion q)/*-{
return this.multiplySelf(q);
}-*/;

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
}
