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
package com.akjava.gwt.three.client.objects;

import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.materials.Material;
import com.google.gwt.core.client.JsArray;

public class Mesh extends Object3D{
protected Mesh(){}



public final native void testSwap(int index)/*-{
this.geometry.vertices=this.geometry.morphTargets[index].vertices;
//this.geometry.computeFaceNormals();
//this.geometry.computeTangents();
this.geometry.__dirtyVertices=true;
this.geometry.computeTangents();
this.geometry.computeFaceNormals();
}-*/;

public final native void setMaterial(Material material)/*-{	
this.material=material;
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
public final native Material getMaterial()/*-{	
return this.material;
}-*/;

public final native void setCastShadow(boolean bool)/*-{
this.castShadow=bool;
}-*/;

public final native void setReceiveShadow(boolean bool)/*-{
this.receiveShadow=bool;
}-*/;

public final native void setOverdraw(boolean bool)/*-{
this.overdraw=bool;
}-*/;
public final native boolean isOverdraw()/*-{
return this.overdraw;
}-*/;



public final native Geometry getGeometry()/*-{
return this.geometry;
}-*/;
public final native void setGeometry(Geometry geo)/*-{
return this.geometry=geo;
}-*/;
}
