/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client.js.objects;

import com.akjava.gwt.three.client.gwt.core.Intersect;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.core.Raycaster;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayNumber;

public class Mesh extends Object3D{
protected Mesh(){}


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

public final native void updateMorphTargets()/*-{
this.updateMorphTargets();
}-*/;

public final native int getMorphTargetIndexByName(String name)/*-{
return this.getMorphTargetIndexByName(name);
}-*/;

public final native Mesh clone(Mesh object)/*-{
return this.clone(object);
}-*/;


/**
 * @deprecated
 * @param index
 */
public final native void testSwap(int index)/*-{
this.geometry.vertices=this.geometry.morphTargets[index].vertices;
//this.geometry.computeFaceNormals();
//this.geometry.computeTangents();
this.geometry.verticesNeedUpdate =true;
this.geometry.computeTangents();
this.geometry.computeFaceNormals();
}-*/;


/**
 * @deprecated no more array
 * @return
 */
public final native void setMaterials(Material material)/*-{	
this.materials=[material];
}-*/;


/**
 * @deprecated dont work 
 * @return
 */
public final native void gwtBoundingSphere()/*-{	
this.boundRadius = geometry.boundingSphere.radius;
}-*/;




/**
 * @deprecated no more array
 * @return
 */
public final native JsArray<Material> getMaterials()/*-{	
return this.materials;
}-*/;


/**
 * @deprecated
 * @return
 */
public final native void setOverdraw(boolean bool)/*-{
this.overdraw=bool;
}-*/;

/**
 * @deprecated
 * @return
 */
public final native boolean isOverdraw()/*-{
return this.overdraw;
}-*/;

/**
 * @deprecated
 * @return
 */
public final native void setPhase(double phase)/*-{
this.phase=phase;
}-*/;

/**
 * @deprecated
 * @return
 */
public final native double getPhase()/*-{
return this.phase;
}-*/;
/**
 * @deprecated no more  use materials side THREE.DoubleSide
 * @param sided
 */
public final native void setDoubleSided(boolean sided)/*-{
this.doubleSided=sided;
}-*/;

/**
 * @deprecated no more  use materials side
 * @param sided
 */
public final native void setFlipSided(boolean sided)/*-{
this.flipSided=sided;
}-*/;
 

public final native void raycast(Raycaster raycaster,JsArray<Intersect> intersects)/*-{
this.raycast(raycaster,intersects);
}-*/;





public final  native int getMorphTargetBase()/*-{
return this.morphTargetBase;
}-*/;
public final  native void setMorphTargetBase(int  param)/*-{
this.morphTargetBase=param;
}-*/;


public final  native JsArrayInteger getMorphTargetForcedOrder()/*-{
return this.morphTargetForcedOrder;
}-*/;
public final  native void setMorphTargetForcedOrder(JsArrayInteger  param)/*-{
this.morphTargetForcedOrder=param;
}-*/;


public final  native JsArrayNumber getMorphTargetInfluences()/*-{
return this.morphTargetInfluences;
}-*/;
public final  native void setMorphTargetInfluences(JsArrayNumber  param)/*-{
this.morphTargetInfluences=param;
}-*/;


public final  native JavaScriptObject getMorphTargetDictionary()/*-{
return this.morphTargetDictionary;
}-*/;
public final  native void setMorphTargetDictionary(JavaScriptObject  param)/*-{
this.morphTargetDictionary=param;
}-*/;



}
