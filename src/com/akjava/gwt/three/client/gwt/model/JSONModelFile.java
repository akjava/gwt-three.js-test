package com.akjava.gwt.three.client.gwt.model;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.core.Face;
import com.akjava.gwt.three.client.core.UV;
import com.akjava.gwt.three.client.core.Vector4;
import com.akjava.gwt.three.client.core.Vertex;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONObject;

public class JSONModelFile extends JavaScriptObject{
protected JSONModelFile(){}

@SuppressWarnings("unchecked")
public static JSONModelFile create(){
	JSONModelFile f=(JSONModelFile) JSONModelFile.createObject();
	MetaData mdata=(MetaData) MetaData.createObject();
	mdata.setFormatVersion(3);
	f.setMetaData(mdata);
	
	f.setUvs((JsArray<JsArrayNumber>) JsArray.createArray());
	f.setMaterials((JsArray<ModelMaterials>) JsArray.createArray());
	
	f.getMaterials().push(ModelMaterials.createDefault());
	return f;
}

public final String getJsonText(){
	
	return new JSONObject(this).toString();
}

public native final void setVertices (JsArrayNumber vertices)/*-{
this["vertices"]=vertices;
}-*/;

public native final JsArrayNumber getVertices ()/*-{
return this["vertices"];
}-*/;

public native final void setFaces (JsArrayNumber faces)/*-{
this["faces"]=faces;
}-*/;

public native final void setSkinWeights(JsArrayNumber skinWeights)/*-{
this["skinWeights"]=skinWeights;
}-*/;

public native final void setSkinIndices (JsArrayNumber skinIndices)/*-{
this["skinIndices"]=skinIndices;
}-*/;

public native final JsArrayNumber getFaces ()/*-{
return this["faces"];
}-*/;

public native final void setUvs (JsArray<JsArrayNumber> uvs)/*-{
this["uvs"]=uvs;
}-*/;

public native final JsArray<JsArrayNumber> getUvs ()/*-{
return this["uvs"];
}-*/;

public native final void setMaterials (JsArray<ModelMaterials> materials)/*-{
this["materials"]=materials;
}-*/;

public native final JsArray<ModelMaterials> getMaterials ()/*-{
return this["materials"];
}-*/;


public final void setSkinIndicesAndWeights(JsArray<Vector4> indices,JsArray<Vector4> weights){
	JsArrayNumber indicesArray=(JsArrayNumber) JsArrayNumber.createArray();
	for(int i=0;i<indices.length();i++){
		indicesArray.push(indices.get(i).getX());
		indicesArray.push(indices.get(i).getY());
	}
	JsArrayNumber weightsArray=(JsArrayNumber) JsArrayNumber.createArray();
	for(int i=0;i<weights.length();i++){
		weightsArray.push(weights.get(i).getX());
		weightsArray.push(weights.get(i).getY());
	}
	LogUtils.log("indicesArray.length"+indicesArray.length());
	LogUtils.log("weightsArray.length"+weightsArray.length());
	setSkinIndices(indicesArray);
	setSkinWeights(weightsArray);
}

public final void setVertices(JsArray<Vertex> vx){
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	for(int i=0;i<vx.length();i++){
		nums.push(vx.get(i).getPosition().getX());
		nums.push(vx.get(i).getPosition().getY());
		nums.push(vx.get(i).getPosition().getZ());
	}
	setVertices(nums);
}
/*
 * single uv only
 */
public final void setGeometryUvs(JsArray<JsArray<UV>> uvs){
	@SuppressWarnings("unchecked")
	JsArray<JsArrayNumber> uvArray=(JsArray<JsArrayNumber>) JsArray.createArray();
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	uvArray.push(nums);
	
	//LogUtils.log("uvs:"+uvs.length());
	for(int i=0;i<uvs.length();i++){
		
		JsArray<UV> u=uvs.get(i);
		//LogUtils.log("uvs:-u"+u.length());
		
		for(int j=0;j<u.length();j++){
			UV uv=u.get(j);
			nums.push(uv.getU());
			nums.push(uv.getV());
		}
		
	}
	setUvs(uvArray);
}
/**
 * call setUvs first
 * @param faces
 */
public final void setFaces(JsArray<Face> faces){
	boolean hasUv=getUvs().length()>0;
	
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	int faceIndex=0;
	for(int i=0;i<faces.length();i++){
		Face face=faces.get(i);
		if(face.isFace4()){
			int v=1;if(hasUv){v=8+1;};
			nums.push(v); // quad
			nums.push(face.getA());
			nums.push(face.getB());
			nums.push(face.getC());
			nums.push(face.getD());
			
			if(hasUv){//uv is same as vx
				nums.push(faceIndex);
				nums.push(faceIndex+1);
				nums.push(faceIndex+2);
				nums.push(faceIndex+3);
			}
			faceIndex+=4;
			
		}else{
			int v=0;if(hasUv){v=8+0;};
			nums.push(v); // triangle
			nums.push(face.getA());
			nums.push(face.getB());
			nums.push(face.getC());
			
			if(hasUv){//uv is same as vx
				nums.push(faceIndex);
				nums.push(faceIndex+1);
				nums.push(faceIndex+2);
			}
			faceIndex+=3;
		}
		
	}
	setFaces(nums);
}



public native final void setMetaData(MetaData meta)/*-{
this["metadata"]=meta;
}-*/;

public native final double getMetaData()/*-{
return this["metadata"];
}-*/;

}
