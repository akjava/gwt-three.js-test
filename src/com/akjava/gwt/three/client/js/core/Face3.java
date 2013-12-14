package com.akjava.gwt.three.client.js.core;

import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Face3 extends JavaScriptObject{
protected Face3(){}


public final native Color getColor()/*-{
return this.color;
}-*/;

public final native JsArray<Material> materials()/*-{
return this.materials;
}-*/;

/**
 * no more support it,always false
 * @return
 */
public  final native boolean isFace4()/*-{
if(this instanceof $wnd.THREE.Face4){
	return false;
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
/**
 * @deprecated
 * @param d
 */
public native final void setD(double d)/*-{
this.d=d;
}-*/;









public final native Object getNormal()/*-{
return this.normal;
}-*/;

public final native void setNormal(Object normal)/*-{
this.normal = normal;
}-*/;


public final native Object getVertexNormals()/*-{
return this.vertexNormals;
}-*/;

public final native void setVertexNormals(Object vertexNormals)/*-{
this.vertexNormals = vertexNormals;
}-*/;




public final native void setColor(Color color)/*-{
this.color = color;
}-*/;


public final native Object getVertexColors()/*-{
return this.vertexColors;
}-*/;

public final native void setVertexColors(Object vertexColors)/*-{
this.vertexColors = vertexColors;
}-*/;


/**
 * maybe vector3
 * @return
 */
public final native JsArray<Vector3> getVertexTangents()/*-{
return this.vertexTangents;
}-*/;

/**
 * maybe vector3
 * @return
 */
public final native void setVertexTangents(JsArray<Vector3> vertexTangents)/*-{
this.vertexTangents = vertexTangents;
}-*/;


public final native Object getMaterialIndex()/*-{
return this.materialIndex;
}-*/;

public final native void setMaterialIndex(Object materialIndex)/*-{
this.materialIndex = materialIndex;
}-*/;


public final native Vector3 getCentroid()/*-{
return this.centroid;
}-*/;

public final native void setCentroid(Vector3 centroid)/*-{
this.centroid = centroid;
}-*/;

public final native Face3 clone()/*-{
return this.clone();
}-*/;

}
