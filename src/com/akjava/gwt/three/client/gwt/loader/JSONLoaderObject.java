package com.akjava.gwt.three.client.gwt.loader;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
public class JSONLoaderObject extends JavaScriptObject{
protected JSONLoaderObject(){}

public final native JsArray<Material> getMaterials()/*-{
return this.materials;
}-*/;

public final  native Geometry getGeometry()/*-{
return this.geometry;
}-*/;

}