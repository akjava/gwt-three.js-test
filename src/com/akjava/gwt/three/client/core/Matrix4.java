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


public native final Matrix4 multiply(Matrix4 a,Matrix4 b)/*-{
return this.multiply(a,b);
}-*/;

public native final Matrix4 multiplySelf(Matrix4 b)/*-{
return this.multiply(this,b);
}-*/;

public native final Matrix4 setRotationFromQuaternion(Quaternion q)/*-{
return this.setRotationFromQuaternion(q);
}-*/;


}
