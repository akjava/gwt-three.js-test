package com.akjava.gwt.three.client.gwt.model;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.js.core.Face3;
import com.akjava.gwt.three.client.js.math.UV;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.akjava.gwt.three.client.js.math.Vertex;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONObject;

public class JSONModelFile extends JavaScriptObject{
protected JSONModelFile(){}

public static JSONModelFile create(){
	return create("GWT JSONModelFile r63");
}
@SuppressWarnings("unchecked")
public static JSONModelFile create(String generatedBy){
	JSONModelFile f=(JSONModelFile) JSONModelFile.createObject();
	MetaData mdata=(MetaData) MetaData.createObject();
	mdata.setFormatVersion(3.1);
	f.setMetaData(mdata);
	f.setNormals((JsArrayNumber) JavaScriptObject.createArray());
	f.setColors((JsArrayNumber) JavaScriptObject.createArray());
	f.setVertices((JsArrayNumber) JavaScriptObject.createArray());
	f.setFaces((JsArrayNumber) JavaScriptObject.createArray());
	f.setUvs((JsArray<JsArrayNumber>) JsArray.createArray());
	f.setMaterials((JsArray<ModelMaterials>) JsArray.createArray());
	
	f.setSkinIndices((JsArrayNumber) JavaScriptObject.createArray());
	f.setSkinWeights((JsArrayNumber) JavaScriptObject.createArray());
	
	f.getMaterials().push(ModelMaterials.createDefault());
	
	
	return f;
}

public final String getJsonText(){
	
	return new JSONObject(this).toString();
}

public native final void setVertices (JsArrayNumber vertices)/*-{
this["vertices"]=vertices;
}-*/;

public native final double getScale()/*-{
return this["scale"];
}-*/;

public native final void setScale(double scale)/*-{
this["scale"]=scale;
}-*/;

public native final JsArrayNumber getVertices ()/*-{
return this["vertices"];
}-*/;

public native final void setFaces (JsArrayNumber faces)/*-{
this["faces"]=faces;
}-*/;
public native final JsArrayNumber getFaces ()/*-{
return this["faces"];
}-*/;

public native final void setNormals (JsArrayNumber normals)/*-{
this["normals"]=normals;
}-*/;
public native final JsArrayNumber getNormals ()/*-{
return this["normals"];
}-*/;

public native final void setColors (JsArrayNumber colors)/*-{
this["colors"]=colors;
}-*/;
public native final JsArrayNumber getColors ()/*-{
return this["colors"];
}-*/;

public native final JsArrayNumber getSkinWeights ()/*-{
return this["skinWeights"];
}-*/;
public native final void setSkinWeights(JsArrayNumber skinWeights)/*-{
this["skinWeights"]=skinWeights;
}-*/;

public native final void setSkinIndices (JsArrayNumber skinIndices)/*-{
this["skinIndices"]=skinIndices;
}-*/;
public native final JsArrayNumber getSkinIndices ()/*-{
return this["skinIndices"];
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


public native final JavaScriptObject getAnimation ()/*-{
return this["animation"];
}-*/;
public native final void setAnimation (JavaScriptObject animation)/*-{
this["animation"]=animation;
}-*/;

public native final JsArray<JavaScriptObject> getBones ()/*-{
return this["bones"];
}-*/;

public native final void setBones (JsArray<JavaScriptObject> bones)/*-{
this["bones"]=bones;
}-*/;




public native final JsArray<JavaScriptObject> getMorphTargets ()/*-{
return this["morphTargets"];
}-*/;

public native final void setMorphTargets (JsArray<JavaScriptObject> morphTargets)/*-{
this["morphTargets"]=morphTargets;
}-*/;

public native final JsArray<JavaScriptObject> getMorphColors ()/*-{
return this["morphColors"];
}-*/;

public native final void setMorphColors (JsArray<JavaScriptObject> morphColors)/*-{
this["morphColors"]=morphColors;
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
public final void setGeometryUvs(JsArray<JsArray<Vector2>> uvs){
	@SuppressWarnings("unchecked")
	JsArray<JsArrayNumber> uvArray=(JsArray<JsArrayNumber>) JsArray.createArray();
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	uvArray.push(nums);
	
	//LogUtils.log("uvs:"+uvs.length());
	for(int i=0;i<uvs.length();i++){
		
		JsArray<Vector2> u=uvs.get(i);
		//LogUtils.log("uvs:-u"+u.length());
		
		for(int j=0;j<u.length();j++){
			Vector2 uv=u.get(j);
			nums.push(uv.getX());
			nums.push(uv.getY());
		}
		
	}
	setUvs(uvArray);
}
/**
 * call setUvs first
 * @param faces
 */
public final void setFaces(JsArray<Face3> faces){
	boolean hasUv=getUvs().length()>0;
	
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	int faceIndex=0;
	for(int i=0;i<faces.length();i++){
		Face3 face=faces.get(i);
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

public native final MetaData getMetaData()/*-{
return this["metadata"];
}-*/;

public  final JSONModelFile clone(){
	JSONModelFile newFile=create();
	//metadata
	newFile.setMetaData(this.getMetaData().clone());
	
	newFile.setScale(this.getScale());
	//TODO clone completly
	newFile.setMaterials(this.getMaterials());//warning shared
	if(this.getMorphTargets()!=null){
		newFile.setMorphTargets(this.getMorphTargets());
	}
	if(this.getMorphColors()!=null){
		newFile.setMorphColors(this.getMorphColors());
	}
	if(this.getBones()!=null){
		newFile.setBones(this.getBones());
	}
	if(this.getAnimation()!=null){
		newFile.setAnimation(this.getAnimation());
	}
	
	//clone uvs
	if(this.getUvs()!=null){
		JsArray<JsArrayNumber> valuesUvs=this.getUvs();
		for(int i=0;i<valuesUvs.length();i++){
			JsArrayNumber uvs=valuesUvs.get(i);
			JsArrayNumber array=(JsArrayNumber) JavaScriptObject.createArray();
			for(int j=0;j<uvs.length();j++){
				array.push(uvs.get(j));
			}
			newFile.getUvs().push(array);
		}
	}
	
	//clone faces,normals,colors,vertices,skinIndices,skinWeights
	if(this.getFaces()!=null){
		JsArrayNumber values=this.getFaces();
		for(int i=0;i<values.length();i++){
			newFile.getFaces().push(values.get(i));
		}
	}
	if(this.getNormals()!=null){
		JsArrayNumber values=this.getNormals();
		for(int i=0;i<values.length();i++){
			newFile.getNormals().push(values.get(i));
		}
	}
	
	if(this.getColors()!=null){
		JsArrayNumber values=this.getColors();
		for(int i=0;i<values.length();i++){
			newFile.getColors().push(values.get(i));
		}
	}
	if(this.getVertices()!=null){
		JsArrayNumber values=this.getVertices();
		for(int i=0;i<values.length();i++){
			newFile.getVertices().push(values.get(i));
		}
	}
	
	if(this.getSkinIndices()!=null){
		JsArrayNumber values=this.getSkinIndices();
		for(int i=0;i<values.length();i++){
			newFile.getSkinIndices().push(values.get(i));
		}
	}
	
	if(this.getSkinWeights()!=null){
		JsArrayNumber values=this.getSkinWeights();
		for(int i=0;i<values.length();i++){
			newFile.getSkinWeights().push(values.get(i));
		}
	}
	
	return newFile;
}

}
