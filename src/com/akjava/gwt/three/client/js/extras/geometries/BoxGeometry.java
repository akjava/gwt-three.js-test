package com.akjava.gwt.three.client.js.extras.geometries;

import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JsArray;

public class BoxGeometry extends Geometry{
protected BoxGeometry(){}


public final native double getWidth()/*-{
return this.width;
}-*/;


public final native double getHeight()/*-{
return this.height;
}-*/;


public final native double getDepth()/*-{
return this.depth;
}-*/;


public final native int getWidthSegments()/*-{
return this.widthSegments;
}-*/;


public final native int getHeightSegments()/*-{
return this.heightSegments;
}-*/;


public final native int getDepthSegments()/*-{
return this.depthSegments;
}-*/;

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
