package com.akjava.gwt.three.client.java.file;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.json.client.JSONValue;

/*
 * extreamlly similar morphtarget animation clip
 * 
 * but direct index make problem,when use difference skin-mesh
 * some mesh not have target or some time have different order.
 * somt time value need fix for fit the model.
 * 
 */
public class JSONMorphTargetsFile extends JSONObject{
public JSONMorphTargetsFile(){
	super();
}
public JSONMorphTargetsFile(JavaScriptObject object){
	super(object);
}
/*
public final static JSONMorphTargetsFile create(){
	
	JSONMorphTargetsFile file=new JSONMorphTargetsFile();
	
	JSParameter meta=JSParameter.createParameter();
	meta.set("version", 1.0);
	meta.set("type", "morphTargets");
	
	JSONObject metaJson=new JSONObject(meta);
	
	file.put("metadata", metaJson);
	
	JSParameter data=JSParameter.createParameter();
	
	
	//empty
	JsArray<JavaScriptObject> morphTargetDatas=JavaScriptObject.createArray().cast();
	data.set("morphtargetDatas", morphTargetDatas);
	
	file.put("data", new JSONArray(morphTargetDatas));
	
	return file;
}*/

public JsArray<JSParameter> getMorphTargetData(){
	JSONValue data=get("data");
	JSONObject object=data.isObject();
	JSONValue array=object.get("morphtargetDatas");
	JSONArray jsonarray=array.isArray();
	return jsonarray.getJavaScriptObject().cast();
}

public String getString(String key){
	JSONValue value=get(key);
	JSONString string=value.isString();
	return string.stringValue();
}

public JsArrayNumber getArrayNumber(String key){
	JSONValue value=get(key);
	JSONArray array=value.isArray();
	return array.getJavaScriptObject().cast();
}


/*public final static JSParameter createMorphTargetData(String name,JsArrayNumber times,JsArrayNumber values){
	JSParameter data=JSParameter.createParameter();
	data.set("name", name);
	
	data.set("times",times);
	
	data.set("values",values);
	return data;
}*/

}
