package com.akjava.gwt.three.client.js.objects;

import com.akjava.gwt.three.client.js.math.Matrix4;
import com.google.gwt.core.client.JsArray;

public class SkinnedMesh extends Mesh{
protected SkinnedMesh(){}


public final native boolean isUseVertexTexture()/*-{
return this.useVertexTexture;
}-*/;

public final native void setUseVertexTexture(boolean useVertexTexture)/*-{
this.useVertexTexture = useVertexTexture;
}-*/;


public final native Matrix4 getIdentityMatrix()/*-{
return this.identityMatrix;
}-*/;

public final native void setIdentityMatrix(Matrix4 identityMatrix)/*-{
this.identityMatrix = identityMatrix;
}-*/;


public final native JsArray<Bone> getBones()/*-{
return this.bones;
}-*/;

public final native void setBones(JsArray<Bone> bones)/*-{
this.bones = bones;
}-*/;

//TODO support float32array
public final native JsArray getBoneMatrices()/*-{
return this.boneMatrices;
}-*/;

//TODO support float32array
public final native void setBoneMatrices(JsArray boneMatrices)/*-{
this.boneMatrices = boneMatrices;
}-*/;




public final native Bone addBone(Bone bone)/*-{
return this.addBone(bone);
}-*/;



public final native void pose()/*-{
this.pose();
}-*/;

public final native void normalizeSkinWeights()/*-{
this.normalizeSkinWeights();
}-*/;

public final native SkinnedMesh clone(SkinnedMesh object)/*-{
return this.clone(object);
}-*/;


}
