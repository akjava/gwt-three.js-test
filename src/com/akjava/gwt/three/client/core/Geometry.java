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
package com.akjava.gwt.three.client.core;

import com.akjava.gwt.three.client.gwt.animation.AnimationBone;
import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.math.Color;
import com.akjava.gwt.three.client.math.Matrix4;
import com.akjava.gwt.three.client.math.UV;
import com.akjava.gwt.three.client.math.Vector3;
import com.akjava.gwt.three.client.math.Vector4;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class Geometry extends JavaScriptObject{
protected Geometry(){}

public final native JsArray<Face3> faces()/*-{
return this.faces;
}-*/;

public final native JsArray<Vector3> vertices()/*-{
return this.vertices;
}-*/;

/**
 * should call computeBoundingBox
 * @return
 */
public final native BoundingBox getBoundingBox()/*-{	
return this.boundingBox;
}-*/;

public final native void computeBoundingSphere()/*-{
this.computeBoundingSphere();
}-*/;

public final native void computeFaceNormals()/*-{
 this.computeFaceNormals();
}-*/;
public final native void computeCentroids()/*-{
this.computeFaceNormals();
}-*/;

public final native void computeVertexNormals()/*-{
 this.computeVertexNormals();
}-*/;

public final native void computeBoundingBox()/*-{
 this.computeBoundingBox();
}-*/;

/**
 * @deprecated
 * @return
 */
public final native boolean getDirtyVertices()/*-{
return this.verticesNeedUpdate;
}-*/;



/**
 * @deprecated
 * @param bool
 */
public final native void setDirtyVertices(boolean bool)/*-{
this.verticesNeedUpdate=bool;
}-*/;

public final native boolean isVerticesNeedUpdate()/*-{
return this.verticesNeedUpdate;
}-*/;
public final native void setVerticesNeedUpdate(boolean bool)/*-{
this.verticesNeedUpdate=bool;
}-*/;
public final native void setElementsNeedUpdate (boolean bool)/*-{
this.elementsNeedUpdate =bool;
}-*/;
public final native boolean isElementsNeedUpdate()/*-{
return this.elementsNeedUpdate ;
}-*/;
public final native void setMorphTargetsNeedUpdate (boolean bool)/*-{
this.morphTargetsNeedUpdate =bool;
}-*/;
public final native boolean isMorphTargetsNeedUpdate ()/*-{
return this.morphTargetsNeedUpdate ;
}-*/;
public final native void setUvsNeedUpdate (boolean bool)/*-{
this.uvsNeedUpdate =bool;
}-*/;
public final native boolean isUvsNeedUpdate ()/*-{
return this.uvsNeedUpdate ;
}-*/;
public final native void setNormalsNeedUpdate (boolean bool)/*-{
this.normalsNeedUpdate =bool;
}-*/;
public final native boolean isNormalsNeedUpdate ()/*-{
return this.normalsNeedUpdate ;
}-*/;
public final native void setColorsNeedUpdate (boolean bool)/*-{
this.colorsNeedUpdate =bool;
}-*/;
public final native boolean isColorsNeedUpdate ()/*-{
return this.colorsNeedUpdate ;
}-*/;
public final native void setTangentsNeedUpdate (boolean bool)/*-{
this.tangentsNeedUpdate =bool;
}-*/;
public final native boolean isTangentsNeedUpdate ()/*-{
return this.tangentsNeedUpdate ;
}-*/;


 

public final native boolean getDynamic()/*-{
return this.dynamic;
}-*/;

public final native void setDynamic(boolean bool)/*-{
this.dynamic=bool;
}-*/;


public final native void applyMatrix(Matrix4 matrix)/*-{
this.applyMatrix(matrix);
}-*/;

public final native void computeTangents()/*-{
this.computeTangents();
}-*/;

public final native JsArray<MorphTarget> getMorphTargets()/*-{
return this.morphTargets;
}-*/;


public final native AnimationData getAnimation()/*-{
return this.animation;
}-*/;
public final native JsArray<AnimationBone> getBones()/*-{
return this.bones;
}-*/;


public final native void setBones(JsArray<AnimationBone> bones)/*-{
this.bones=bones;
}-*/;

//dont't call after meshed geometry
/**
 @deprecated
 */
public final native JsArrayNumber getSkinIndicesAsRaw()/*-{
return this.skinIndices;
}-*/;


//dont't call after meshed geometry
/**
@deprecated
*/
public final native JsArrayNumber getSkinWeightAsRaw()/*-{
return this.skinWeights;
}-*/;

//dont't call after meshed geometry
public final native void setSkinIndices(JsArray<Vector4> skinIndices)/*-{
this.skinIndices=skinIndices;
}-*/;

public final native void setSkinWeight(JsArray<Vector4> skinWeights)/*-{
this.skinWeights=skinWeights;
}-*/;

//dont't call after meshed geometry
public final native JsArray<Vector4> getSkinIndices()/*-{
return this.skinIndices;
}-*/;

public final native JsArray<Vector4>  getSkinWeight()/*-{
return this.skinWeights;
}-*/;

public native final JsArray<JsArray<UV>> getFaceVertexUvs ()/*-{
return this["faceVertexUvs"][0];
}-*/;

public native final Geometry clone()/*-{
return this.clone();
}-*/;


public final native JsArray<Vector3> getVertices()/*-{
return this.vertices;
}-*/;

public final native void setVertices(JsArray<Vector3> vertices)/*-{
this.vertices = vertices;
}-*/;


public final native JsArray<Color> getColors()/*-{
return this.colors;
}-*/;

public final native void setColors(JsArray<Color> colors)/*-{
this.colors = colors;
}-*/;


public final native JsArray<Face3> getFaces()/*-{
return this.faces;
}-*/;

public final native void setFaces(JsArray<Face3> faces)/*-{
this.faces = faces;
}-*/;



public final native void setFaceVertexUvs(JsArray<JavaScriptObject> faceVertexUvs)/*-{
this.faceVertexUvs = faceVertexUvs;
}-*/;




public final native void setMorphTargets(JsArray<MorphTarget> morphTargets)/*-{
this.morphTargets = morphTargets;
}-*/;


public final native JsArray<Color> getMorphColors()/*-{
return this.morphColors;
}-*/;

public final native void setMorphColors(JsArray<Color> morphColors)/*-{
this.morphColors = morphColors;
}-*/;


public final native JsArray<Vector3> getMorphNormals()/*-{
return this.morphNormals;
}-*/;

public final native void setMorphNormals(JsArray<Vector3> morphNormals)/*-{
this.morphNormals = morphNormals;
}-*/;


public final native JsArray<Vector4> getSkinWeights()/*-{
return this.skinWeights;
}-*/;

public final native void setSkinWeights(JsArray<Vector4> skinWeights)/*-{
this.skinWeights = skinWeights;
}-*/;






public final native JsArrayNumber getLineDistances()/*-{
return this.lineDistances;
}-*/;

public final native void setLineDistances(JsArrayNumber lineDistances)/*-{
this.lineDistances = lineDistances;
}-*/;




public final native void setBoundingBox(Object boundingBox)/*-{
this.boundingBox = boundingBox;
}-*/;


public final native Object getBoundingSphere()/*-{
return this.boundingSphere;
}-*/;

public final native void setBoundingSphere(Object boundingSphere)/*-{
this.boundingSphere = boundingSphere;
}-*/;


public final native boolean isHasTangents()/*-{
return this.hasTangents;
}-*/;

public final native void setHasTangents(boolean hasTangents)/*-{
this.hasTangents = hasTangents;
}-*/;




public final native void setDynamic(Object dynamic)/*-{
this.dynamic = dynamic;
}-*/;









public final native boolean isLineDistancesNeedUpdate()/*-{
return this.lineDistancesNeedUpdate;
}-*/;

public final native void setLineDistancesNeedUpdate(boolean lineDistancesNeedUpdate)/*-{
this.lineDistancesNeedUpdate = lineDistancesNeedUpdate;
}-*/;


public final native boolean isBuffersNeedUpdate()/*-{
return this.buffersNeedUpdate;
}-*/;

public final native void setBuffersNeedUpdate(boolean buffersNeedUpdate)/*-{
this.buffersNeedUpdate = buffersNeedUpdate;
}-*/;

public final native void applyMatrix(Object matrix)/*-{
this.applyMatrix(matrix);
}-*/;



public final native void computeVertexNormals(Object areaWeighted)/*-{
this.computeVertexNormals(areaWeighted);
}-*/;

public final native void computeMorphNormals()/*-{
this.computeMorphNormals();
}-*/;



public final native Object mergeVertices()/*-{
return this.mergeVertices();
}-*/;



public final native void dispose()/*-{
this.dispose();
}-*/;


}
