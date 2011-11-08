package com.akjava.gwt.three.client.core;

import com.akjava.gwt.three.client.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class Face extends JavaScriptObject{
protected Face(){}

/**
 * @deprecated dont touch direct?
 * @return
 */
public final native Color color()/*-{
return this.color;
}-*/;

public final native JsArray<Material> materials()/*-{
return this.materials;
}-*/;
}
