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


public native final Vector3 multiplyVector3(Vector3 vec)/*-{
return this.multiplyVector3(vec);
}-*/;


public native final void setRotationX(double thera)/*-{
this.setRotationX(thera);
}-*/;
public native final void setRotationY(double thera)/*-{
this.setRotationY(thera);
}-*/;
public native final void setRotationZ(double thera)/*-{
this.setRotationZ(thera);
}-*/;
public native final void setTranslation(double x,double y,double z)/*-{
this.setTranslation(x,y,z);
}-*/;

public native final Matrix4 lookAt(Vector3 eye,Vector3 center,Vector3 up)/*-{
return this.lookAt(eye,center,up);
}-*/;



}
