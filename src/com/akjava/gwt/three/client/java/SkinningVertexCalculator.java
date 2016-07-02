package com.akjava.gwt.three.client.java;

import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.google.common.collect.Lists;

/**
 * for attach something with skinning-geometry
 * @author aki
 *
 */
public class SkinningVertexCalculator {
	private SkinnedMesh skinnedMesh;
	
	public SkinningVertexCalculator(SkinnedMesh skinnedMesh) {
		super();
		this.skinnedMesh = skinnedMesh;
	}


	public SkinnedMesh getSkinnedMesh() {
		return skinnedMesh;
	}

	public void setSkinnedMesh(SkinnedMesh skinnedMesh) {
		this.skinnedMesh = skinnedMesh;
	}


	private List<Vector3> result=Lists.newArrayList();
	public List<Vector3> getResult() {
		return result;
	}


	private List<SkinningVertex> skinningVertexs=Lists.newArrayList();
	
	public List<SkinningVertex> getSkinningVertexs() {
		return skinningVertexs;
	}

	//add from skinnedMesh vertex
	public SkinningVertex createSkinningVertex(int index,int targetClothIndex){
		Vector4 skinIndices =skinnedMesh.getGeometry().getSkinIndices().get(index);
		Vector4 skinWeights =skinnedMesh.getGeometry().getSkinWeights().get(index);
		Vector3 vertex =skinnedMesh.getGeometry().getVertices().get(index).clone();
		SkinningVertex skinningVertex=new SkinningVertex(vertex, skinIndices, skinWeights);
		skinningVertex.setTargetClothIndex(targetClothIndex);
		return skinningVertex;
	}
	
	public int size(){
		return skinningVertexs.size();
	}
	
	public void add(SkinningVertex vertex){
		skinningVertexs.add(vertex);
		
		result.add(THREE.Vector3());
	}
	
	public void update(){
		for(int i=0;i<skinningVertexs.size();i++){
			result.get(i).copy(transformSkinningVertex(skinnedMesh,skinningVertexs.get(i)).applyMatrix4(skinnedMesh.getMatrixWorld()));
		}
	}
	
	/**
	 * only workd geometry ,not buffer geometry
	 * @param vertex
	 * @return
	 //from http://stackoverflow.com/questions/31620194/how-to-calculate-transformed-skin-vertices
	 */
	public static Vector3 transformSkinningVertex(SkinnedMesh skinnedMesh,SkinningVertex vertex){
		//for thread safe
		Vector3 vec3=THREE.Vector3();
		vec3.copy(vertex.getVertex()).applyMatrix4(skinnedMesh.getBindMatrix());
		Vector3 result = THREE.Vector3 ();
		Vector3 temp = THREE.Vector3 ();
		Matrix4 tempMatrix = THREE.Matrix4 (); 
		//properties = ['x', 'y', 'z', 'w'];
	    
		for (int i = 0; i < 4; i++) {
	        int boneIndex;
	        double boneWeight;
	        if(i==0){
	        	boneIndex=(int)vertex.getSkinIndices().getX();
	        	boneWeight=vertex.getSkinWeights().getX();
	        }else if(i==1){
	        	boneIndex=(int)vertex.getSkinIndices().getY();
	        	boneWeight=vertex.getSkinWeights().getY();
	        }else if(i==2){
	        	boneIndex=(int)vertex.getSkinIndices().getZ();
	        	boneWeight=vertex.getSkinWeights().getZ();
	        }else{
	        	boneIndex=(int)vertex.getSkinIndices().getW();
	        	boneWeight=vertex.getSkinWeights().getW();
	        }
	        if(boneIndex<0 || boneIndex>=skinnedMesh.getSkeleton().getBones().length()){
	        	LogUtils.log("boneIndex="+boneIndex+",but bones below");
	        	LogUtils.log(skinnedMesh.getSkeleton().getBones());
	        	throw new RuntimeException("out of index");
	        }
	        
	        tempMatrix.multiplyMatrices (skinnedMesh.getSkeleton().getBones().get(boneIndex).getMatrixWorld(), skinnedMesh.getSkeleton().getBoneInverses().get(boneIndex));
	        result.add (temp.copy (vec3).applyMatrix4 (tempMatrix).multiplyScalar (boneWeight));
	    }
	    return result.applyMatrix4 (skinnedMesh.getBindMatrixInverse());
	}
	public static Vector3 transformSkinningVertex(SkinnedMesh skinnedMesh,int index,Vector3 vertex){
		//for thread safe
		Vector3 vec3=THREE.Vector3();
		vec3.copy(vertex).applyMatrix4(skinnedMesh.getBindMatrix());
		Vector3 result = THREE.Vector3 ();
		Vector3 temp = THREE.Vector3 ();
		Matrix4 tempMatrix = THREE.Matrix4 (); 
		//properties = ['x', 'y', 'z', 'w'];
	    
		for (int i = 0; i < 4; i++) {
	        int boneIndex;
	        double boneWeight;
	        if(i==0){
	        	boneIndex=(int)skinnedMesh.getGeometry().getSkinIndices().get(index).getX();
	        	boneWeight=skinnedMesh.getGeometry().getSkinWeights().get(index).getX();
	        }else if(i==1){
	        	boneIndex=(int)skinnedMesh.getGeometry().getSkinIndices().get(index).getY();
	        	boneWeight=skinnedMesh.getGeometry().getSkinWeights().get(index).getY();
	        }else if(i==2){
	        	boneIndex=(int)skinnedMesh.getGeometry().getSkinIndices().get(index).getZ();
	        	boneWeight=skinnedMesh.getGeometry().getSkinWeights().get(index).getZ();
	        }else{
	        	boneIndex=(int)skinnedMesh.getGeometry().getSkinIndices().get(index).getW();
	        	boneWeight=skinnedMesh.getGeometry().getSkinWeights().get(index).getW();
	        }
	        if(boneIndex<0 || boneIndex>=skinnedMesh.getSkeleton().getBones().length()){
	        	LogUtils.log("boneIndex="+boneIndex+",but bones below");
	        	LogUtils.log(skinnedMesh.getSkeleton().getBones());
	        	throw new RuntimeException("out of index");
	        }
	        
	        tempMatrix.multiplyMatrices (skinnedMesh.getSkeleton().getBones().get(boneIndex).getMatrixWorld(), skinnedMesh.getSkeleton().getBoneInverses().get(boneIndex));
	        result.add (temp.copy (vec3).applyMatrix4 (tempMatrix).multiplyScalar (boneWeight));
	    }
	    return result.applyMatrix4 (skinnedMesh.getBindMatrixInverse());
	}
	
	public static class SkinningVertex{
		private Vector3 vertex;//usually it's copy
		public SkinningVertex(Vector3 vertex, Vector4 skinIndices, Vector4 skinWeights) {
			super();
			this.vertex = vertex;
			this.skinIndices = skinIndices;
			this.skinWeights = skinWeights;
		}
		public Vector3 getVertex() {
			return vertex;
		}
		public void setVertex(Vector3 vertex) {
			this.vertex = vertex;
		}
		public Vector4 getSkinIndices() {
			return skinIndices;
		}
		public void setSkinIndices(Vector4 skinIndices) {
			this.skinIndices = skinIndices;
		}
		public Vector4 getSkinWeights() {
			return skinWeights;
		}
		public void setSkinWeights(Vector4 skinWeights) {
			this.skinWeights = skinWeights;
		}
		private Vector4 skinIndices;//usually from origin don't modify
		private Vector4 skinWeights;//usually from origin don't modify
		
		
		//for custom cloth mapping
		private int targetClothIndex=-1;
		public int getTargetClothIndex() {
			return targetClothIndex;
		}
		public void setTargetClothIndex(int targetClothIndex) {
			this.targetClothIndex = targetClothIndex;
		}
	}
	
	
	//from http://stackoverflow.com/questions/31620194/how-to-calculate-transformed-skin-vertices
	
	public static final native Vector3 transformedSkinVertex (SkinnedMesh skin,int index)/*-{
	
	//var skinIndices = (new $wnd.THREE.Vector4 ()).fromAttribute (skin.geometry.getAttribute ('skinIndex'), index);
    //var skinWeights = (new $wnd.THREE.Vector4 ()).fromAttribute (skin.geometry.getAttribute ('skinWeight'), index);
    //var skinVertex = (new $wnd.THREE.Vector3 ()).fromAttribute (skin.geometry.getAttribute ('position'), index).applyMatrix4 (skin.bindMatrix);
   var skinIndices =skin.geometry.skinIndices[index];
   var skinWeights =skin.geometry.skinWeights[index];
   var skinVertex =skin.geometry.vertices[index].clone().applyMatrix4(skin.bindMatrix);
	
    var result = new $wnd.THREE.Vector3 (), temp = new $wnd.THREE.Vector3 (), tempMatrix = new $wnd.THREE.Matrix4 (); properties = ['x', 'y', 'z', 'w'];
    for (var i = 0; i < 4; i++) {
        var boneIndex = skinIndices[properties[i]];
        tempMatrix.multiplyMatrices (skin.skeleton.bones[boneIndex].matrixWorld, skin.skeleton.boneInverses[boneIndex]);
       // result.add (temp.copy (skinVertex).multiplyScalar (skinWeights[properties[i]]).applyMatrix4 (tempMatrix));
        result.add (temp.copy (skinVertex).applyMatrix4 (tempMatrix).multiplyScalar (skinWeights[properties[i]]));
    }
    return result.applyMatrix4 (skin.bindMatrixInverse);
	}-*/;
}
