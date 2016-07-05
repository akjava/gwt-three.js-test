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
package com.akjava.gwt.three.client.js.core;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.lib.client.JsonValueUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationBone;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationData;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.gwt.core.MorphTarget;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Sphere;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONNumber;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class Geometry extends EventDispatcher{
protected Geometry(){}

public final native JsArray<Face3> faces()/*-{
return this.faces;
}-*/;

public final native JsArray<Vector3> vertices()/*-{
return this.vertices;
}-*/;

/**
 * must call first computeBoundingBox() or Uncaught TypeError: Cannot read property 'min' of null
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

/**
 * @deprecated no more exist after r67
 */
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


 

public final native boolean isDynamic()/*-{
return this.dynamic;
}-*/;

public final native void setDynamic(boolean bool)/*-{
this.dynamic=bool;
}-*/;


public final native void applyMatrix(Matrix4 matrix)/*-{
this.applyMatrix(matrix);
}-*/;

/**
 * @deprecated on r72
 */
public final native void computeTangents()/*-{
this.computeTangents();
}-*/;

public final native JsArray<MorphTarget> getMorphTargets()/*-{
return this.morphTargets;
}-*/;



/**
 * if parsed by jsonloader on r73
 * @return
 */
public final native JsArray<AnimationClip> getAnimations()/*-{
return this.animations;
}-*/;
/*
 * I'm not sure maybe this is for compatible,should youse 
 */
/**
 * @deprecated maybe better to avoid
 */
public final native AnimationData getAnimation()/*-{
return this.animation;
}-*/;


/*
 * on r74 cloned geometry not contain this.
 */
public final native JsArray<AnimationBone> getBones()/*-{
return this.bones;
}-*/;

public final boolean gwtHasBone(){
	return getBones()!=null && getBones().length()!=0;
}
public final boolean gwtHasSkinIndicesAndWeights(){
	return getSkinIndices()!=null && getSkinIndices().length()!=0 && getSkinWeights()!=null || getSkinWeights().length()!=0;
}

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

/**
 * @deprecated
 * @param skinWeights
 */
public final native void setSkinWeight(JsArray<Vector4> skinWeights)/*-{
this.skinWeights=skinWeights;
}-*/;

//dont't call after meshed geometry
public final native JsArray<Vector4> getSkinIndices()/*-{
return this.skinIndices;
}-*/;

/**
 * @deprecated
 * @return
 */
public final native JsArray<Vector4>  getSkinWeight()/*-{
return this.skinWeights;
}-*/;

/*
 * usually just 1 but possible multiple uvs.
 * JsArray<JsArray<Vector2>> is same as faces
 * JsArray<Vector2> is usually 3 point 
 * Vector2 x,y point of texture
 */
public native final JsArray<JsArray<JsArray<Vector2>>> getFaceVertexUvs ()/*-{
	return this["faceVertexUvs"];
	//return this["faceVertexUvs"];
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

/**
 * @deprecated on r73
 */
public final native JsArray<Color> getMorphColors()/*-{
return this.morphColors;
}-*/;
/**
 * @deprecated on r73
 */
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


public final native Sphere getBoundingSphere()/*-{
return this.boundingSphere;
}-*/;

public final native void setBoundingSphere(Sphere boundingSphere)/*-{
this.boundingSphere = boundingSphere;
}-*/;


public final native boolean isHasTangents()/*-{
return this.hasTangents;
}-*/;

public final native void setHasTangents(boolean hasTangents)/*-{
this.hasTangents = hasTangents;
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




public final native void computeVertexNormals(boolean areaWeighted)/*-{
this.computeVertexNormals(areaWeighted);
}-*/;

public final native void computeMorphNormals()/*-{
this.computeMorphNormals();
}-*/;



public final native int mergeVertices()/*-{
return this.mergeVertices();
}-*/;



public final native void dispose()/*-{
this.dispose();
}-*/;


public  native final void merge(Geometry geo,Matrix4 matrix,int materialIndexOffset)/*-{
this.merge(geo,matrix,materialIndexOffset);
}-*/;

public  native final void merge(Geometry geo,Matrix4 matrix)/*-{
this.merge(geo,matrix);
}-*/;

public  native final void merge(Geometry geo)/*-{
this.merge(geo);
}-*/;
public  native final void mergeMesh(Mesh mesh)/*-{
this.mergeMesh(mesh);
}-*/;


public  native final Geometry fromBufferGeometry(BufferGeometry geo)/*-{
return this.fromBufferGeometry(geo);
}-*/;

public  native final JSParameter getParameter()/*-{
return this.parameters;
}-*/;

public final native Geometry copy(Geometry source)/*-{
return this.copy(source);
}-*/;

/*
 * on r74 only clone
this.vertices = [];
this.faces = [];
this.faceVertexUvs = [ [] ];	 
 * 
 */
public final native Geometry clone()/*-{
return this.clone();
}-*/;

public final native JavaScriptObject toJSON()/*-{
return this.toJSON();
}-*/;

public final native void rotateX(double angle)/*-{
this.rotateX(angle);
}-*/;

public final native void rotateY(double angle)/*-{
this.rotateY(angle);
}-*/;

public final native void rotateZ(double angle)/*-{
this.rotateZ(angle);
}-*/;

public final native void translate(double x,double y,double z)/*-{
this.translate(x,y,z);
}-*/;

public final native void scale(double x,double y,double z)/*-{
this.scale(x,y,z);
}-*/;

public final native void lookAt(Vector3 vector)/*-{
this.lookAt(vector);
}-*/;

public final native void sortFacesByMaterialIndex()/*-{
this.sortFacesByMaterialIndex();
}-*/;



/**
 * cant read directly JSONParse 
 * use data.data
 * @return
 */
public final JSONObject gwtJSONWithBone(){
	JavaScriptObject core=toJSON();
	JSONObject root=new JSONObject(core);
	
	JSONObject object=root.get("data").isObject();
	
	//set bone
	JsArray<AnimationBone> bones=getBones();
	if(bones!=null){
		JSONArray array=new JSONArray(bones);
		object.put("bones", array);
	}else{
	//	object.put("bones", new JSONArray());
	}
	int influencesPerVertex=gwtGetInfluencesPerVertex();
	object.put("influencesPerVertex", new JSONNumber(influencesPerVertex));
	
	JsArray<Vector4> skinIndices=getSkinIndices();
	if(skinIndices!=null){
		JsArrayNumber indices=JavaScriptObject.createArray().cast();
		for(int i=0;i<skinIndices.length();i++){
			for(int j=0;j<influencesPerVertex;j++){
				indices.push(skinIndices.get(i).gwtGet(j));
			}
		}
		object.put("skinIndices", new JSONArray(indices));
	}else{
	//	object.put("skinIndices", new JSONArray());
	}
	
	JsArray<Vector4> skinWeights=getSkinWeights();
	if(skinWeights!=null){
		JsArrayNumber weights=JavaScriptObject.createArray().cast();
		for(int i=0;i<skinWeights.length();i++){
			for(int j=0;j<influencesPerVertex;j++){
				weights.push(skinWeights.get(i).gwtGet(j));
			}
		}
		object.put("skinWeights", new JSONArray(weights));
	}else{
	//	object.put("skinWeights", new JSONArray());
	}
	
	//object.put("colors", new JSONArray());
	//object.put("normals", new JSONArray());
	
	//object.put("animation", new JSONArray());
	//object.put("morphTargets", new JSONArray());
	
	//based gwtGetInfluencesPerVertex
	//set weight & influence
	
	return root;
}

public final  native int gwtGetInfluencesPerVertex()/*-{
if(!this.influencesPerVertex){
	return 2;
}
return this.influencesPerVertex;
}-*/;
/*
 * you have to set by hand when load or made
 */
public final  native void gwtSetInfluencesPerVertex(int  param)/*-{
this.influencesPerVertex=param;
}-*/;

public final void gwtHardCopyToWeightsAndIndices(Geometry geometryToCopy) {
	JsArray<Vector4> indices=JavaScriptObject.createArray().cast();
	JsArray<Vector4> weights=JavaScriptObject.createArray().cast();
	
	for(int i=0;i<getSkinWeights().length();i++){
		indices.push(getSkinIndices().get(i).clone());
		weights.push(getSkinWeights().get(i).clone());
	}
	
	geometryToCopy.setSkinIndices(indices);
	geometryToCopy.setSkinWeights(weights);
}
public final void gwtSoftCopyToWeightsAndIndicesAndBone(Geometry geometryToCopy) {
	geometryToCopy.setBones(getBones());
	
	geometryToCopy.setSkinIndices(getSkinIndices());
	geometryToCopy.setSkinWeights(getSkinWeights());
}

}
