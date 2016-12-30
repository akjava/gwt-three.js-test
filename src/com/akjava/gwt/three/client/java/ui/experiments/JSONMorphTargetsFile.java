package com.akjava.gwt.three.client.java.ui.experiments;

import java.util.Map;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

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

public native final JSParameter getMorphTargetData ()/*-{
return this["data"]["morphtargetDatas"];
}-*/;

/*
 * TODO make class
 * time double
 * keys arraystring
 * values arraynumber
 */
public final static JSParameter createMorphTargetDataByMap(double time,Map<String,Double> keyValues){
	
	JsArrayString keys=JsArrayNumber.createArray().cast();
	JsArrayNumber values=JsArrayNumber.createArray().cast();
	
	for(String key:keyValues.keySet()){
		keys.push(key);
		values.push(keyValues.get(key));
	}
	
	return createMorphTargetData(time,keys,values);
}

public final static JSParameter createMorphTargetData(double time,JsArrayString keys,JsArrayNumber values){
	JSParameter data=JSParameter.createParameter();
	data.set("time", time);
	
	data.set("keys",keys);
	
	data.set("values",values);
	return data;
}

}
