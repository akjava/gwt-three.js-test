package com.akjava.gwt.three.client.core;

import com.akjava.gwt.three.client.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Face extends JavaScriptObject{
protected Face(){}


public final native Color getColor()/*-{
return this.color;
}-*/;

public final native JsArray<Material> materials()/*-{
return this.materials;
}-*/;

public  final native boolean isFace4()/*-{
if(this instanceof $wnd.THREE.Face4){
	return true;
}else{
	return false;
}
}-*/;


public native final double getA()/*-{
return this.a;
}-*/;
public native final double getB()/*-{
return this.b;
}-*/;
public native final double getC()/*-{
return this.c;
}-*/;
public native final double getD()/*-{
return this.d;
}-*/;

public native final void setA(double a)/*-{
this.a=a;
}-*/;
public native final void setB(double b)/*-{
this.b=b;
}-*/;
public native final void setC(double c)/*-{
this.c=c;
}-*/;
public native final void setD(double d)/*-{
this.d=d;
}-*/;
}
