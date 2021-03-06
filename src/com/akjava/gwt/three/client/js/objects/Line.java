package com.akjava.gwt.three.client.js.objects;

import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JsArray;

public class Line extends Object3D{
public static final int LineStrip=0;
public static final int LinePieces = 1;

	protected Line(){}


public final native Geometry getGeometry()/*-{
return this.geometry;
}-*/;

public final native void setGeometry(Geometry geometry)/*-{
this.geometry = geometry;
}-*/;


public final native Material getMaterial()/*-{
return this.material;
}-*/;

public final native void setMaterial(Material material)/*-{
this.material = material;
}-*/;


public final native int getMode()/*-{
return this.mode;
}-*/;

public final native void setMode(int mode)/*-{
this.mode = mode;
}-*/;


public final native Line clone(Line object)/*-{
return this.clone(object);
}-*/;


public final native void raycast(Raycaster raycaster,JsArray<Intersect> intersects)/*-{
this.raycast(raycaster,intersects);
}-*/;

public final native Line copy(Line source)/*-{
return this.copy(source);
}-*/;

public final  native Line clone()/*-{
return this.clone();
}-*/;
}
