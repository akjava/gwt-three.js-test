package com.akjava.gwt.three.client.java.file;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

/*
 * extreamlly similar morphtarget animation clip
 * 
 * but direct index make problem,when use difference skin-mesh
 * some mesh not have target or some time have different order.
 * somt time value need fix for fit the model.
 * 
 */
public class JSONMorphTargetsFile extends JSParameter{
protected JSONMorphTargetsFile(){}

public final static JSONMorphTargetsFile create(){
	
	JSONMorphTargetsFile file=JSONMorphTargetsFile.createObject().cast();
	
	JSParameter meta=JSParameter.createParameter();
	meta.set("version", 1.0);
	meta.set("type", "morphTargets");
	
	file.set("metadata", meta);
	
	JSParameter data=JSParameter.createParameter();
	file.set("data", data);
	
	//empty
	JsArray<JavaScriptObject> morphTargetDatas=JavaScriptObject.createArray().cast();
	data.set("morphtargetDatas", morphTargetDatas);
	
	return file;
}

public native final JsArray<JSParameter> getMorphTargetData ()/*-{
return this["data"]["morphtargetDatas"];
}-*/;



public final static JSParameter createMorphTargetData(String name,JsArrayNumber times,JsArrayNumber values){
	JSParameter data=JSParameter.createParameter();
	data.set("name", name);
	
	data.set("times",times);
	
	data.set("values",values);
	return data;
}

}
