package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public class Quaternion extends JavaScriptObject{
protected Quaternion(){}

public native final Quaternion setFromRotationMatrix(Matrix4 b)/*-{
return this.setFromRotationMatrix(b);
}-*/;

public native final Quaternion setFromAxisAngle(Vector3 axis,double angle)/*-{
return this.setFromAxisAngle(axis,angle);
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
