package com.akjava.gwt.three.client.extras.geometries;

import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.materials.Material;
import com.google.gwt.core.client.JsArray;

public class CubeGeometry extends Geometry{
protected CubeGeometry(){}

/**
 * @deprecated
 * @return
 */
public final native JsArray<Material> getMaterials()/*-{	
return null;
}-*/;

/**
 * @deprecated
 * @return
 */
public final native void setMaterials(Material material)/*-{	
this.materials=[material];
}-*/;

}
