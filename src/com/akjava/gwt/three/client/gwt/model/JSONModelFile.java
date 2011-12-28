package com.akjava.gwt.three.client.gwt.model;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Face;
import com.akjava.gwt.three.client.core.Vertex;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class JSONModelFile extends JavaScriptObject{
protected JSONModelFile(){}

@SuppressWarnings("unchecked")
public static JSONModelFile create(){
	JSONModelFile f=(JSONModelFile) JSONModelFile.createObject();
	MetaData mdata=(MetaData) MetaData.createObject();
	mdata.setFormatVersion(3);
	f.setMetaData(mdata);
	
	f.setUvs((JsArrayNumber) JsArrayNumber.createArray());
	f.setMaterials((JsArray<ModelMaterials>) JsArray.createArray());
	return f;
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

public native final JsArrayNumber getFaces ()/*-{
return this["faces"];
}-*/;

public native final void setUvs (JsArrayNumber uvs)/*-{
this["uvs"]=uvs;
}-*/;

public native final JsArrayNumber getUvs ()/*-{
return this["uvs"];
}-*/;

public native final void setMaterials (JsArray<ModelMaterials> materials)/*-{
this["materials"]=materials;
}-*/;

public native final JsArrayNumber getMaterials ()/*-{
return this["materials"];
}-*/;


public final void setVertices(JsArray<Vertex> vx){
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	for(int i=0;i<vx.length();i++){
		nums.push(vx.get(i).getPosition().getX());
		nums.push(vx.get(i).getPosition().getY());
		nums.push(vx.get(i).getPosition().getZ());
	}
	setVertices(nums);
}

public final void setFaces(JsArray<Face> faces){
	JsArrayNumber nums=(JsArrayNumber) JsArrayNumber.createArray();
	for(int i=0;i<faces.length();i++){
		Face face=faces.get(i);
		if(face.isFace4()){
			nums.push(1); // quad
			nums.push(face.getA());
			nums.push(face.getB());
			nums.push(face.getC());
			nums.push(face.getD());
		}else{
			nums.push(0); // triangle
			nums.push(face.getA());
			nums.push(face.getB());
			nums.push(face.getC());
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
