package com.akjava.gwt.three.client.js.objects;

import com.akjava.gwt.three.client.js.math.Matrix4;
import com.google.gwt.core.client.JsArray;

public class SkinnedMesh extends Mesh{
protected SkinnedMesh(){}


public final native Skeleton getSkeleton()/*-{
return this.skeleton;
}-*/;

public final native void setSkeleton(Skeleton skelton)/*-{
this.skeleton=skelton;
}-*/;

/**
 * 
 * @deprecated
 * use getSkelton()
 */
public final native boolean isUseVertexTexture()/*-{
return this.skelton.useVertexTexture;
}-*/;

/**
 * 
 * @deprecated
 * use getSkelton()
 */
public final native void setUseVertexTexture(boolean useVertexTexture)/*-{
this.skelton.useVertexTexture = useVertexTexture;
}-*/;


public final native Matrix4 getIdentityMatrix()/*-{
return this.identityMatrix;
}-*/;

public final native void setIdentityMatrix(Matrix4 identityMatrix)/*-{
this.identityMatrix = identityMatrix;
}-*/;

/**
 * 
 * @deprecated
 * use getSkelton()
 */
public final native JsArray<Bone> getBones()/*-{
return this.skelton.bones;
}-*/;
/**
 * 
 * @deprecated
 * use getSkelton()
 */
public final native void setBones(JsArray<Bone> bones)/*-{
this.skelton.bones = bones;
}-*/;

/**
 * 
 * @deprecated
 * use getSkelton()
 */
//TODO support float32array
public final native JsArray getBoneMatrices()/*-{
return this.skelton.boneMatrices;
}-*/;

/**
 * 
 * @deprecated
 * use getSkelton()
 */
//TODO support float32array
public final native void setBoneMatrices(JsArray boneMatrices)/*-{
this.skelton.boneMatrices = boneMatrices;
}-*/;



/**
 * 
 * @deprecated
 * use getSkelton()
 */
public final native Bone addBone(Bone bone)/*-{
return this.skelton.addBone(bone);
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
