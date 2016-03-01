package com.akjava.gwt.three.client.js.core;

import com.akjava.gwt.three.client.js.cameras.Camera;
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


public native final int getA()/*-{
return this.a;
}-*/;
public native final int getB()/*-{
return this.b;
}-*/;
public native final int getC()/*-{
return this.c;
}-*/;
public native final int getD()/*-{
return this.d;
}-*/;

public native final void setA(int a)/*-{
this.a=a;
}-*/;
public native final void setB(int b)/*-{
this.b=b;
}-*/;
public native final void setC(int c)/*-{
this.c=c;
}-*/;
/**
 * @deprecated
 * @param d
 */
public native final void setD(int d)/*-{
this.d=d;
}-*/;









public final native Vector3 getNormal()/*-{
return this.normal;
}-*/;

public final native void setNormal(Vector3 normal)/*-{
this.normal = normal;
}-*/;


public final native JsArray<Vector3> getVertexNormals()/*-{
return this.vertexNormals;
}-*/;

public final native void setVertexNormals(JsArray<Vector3> vertexNormals)/*-{
this.vertexNormals = vertexNormals;
}-*/;




public final native void setColor(Color color)/*-{
this.color = color;
}-*/;


public final native JsArray<Color> getVertexColors()/*-{
return this.vertexColors;
}-*/;

public final native void setVertexColors(JsArray<Color> vertexColors)/*-{
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


public final native int getMaterialIndex()/*-{
return this.materialIndex;
}-*/;

public final native void setMaterialIndex(Object materialIndex)/*-{
this.materialIndex = materialIndex;
}-*/;

/**
 * @deprecated no more exist after r67
 */
public final native Vector3 getCentroid()/*-{
return this.centroid;
}-*/;

/**
 * @deprecated no more exist after r67
 * @param centroid
 */
public final native void setCentroid(Vector3 centroid)/*-{
this.centroid = centroid;
}-*/;



public final native Face3 copy(Face3 source)/*-{
return this.copy(source);
}-*/;

public final  native Face3 clone()/*-{
return this.clone();
}-*/;

}
