package com.akjava.gwt.three.client.java.ui.experiments;

import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.lib.client.json.JSONFormatConverter;
import com.google.common.base.Converter;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;

public class JSONMorphTargetsFileConverter extends Converter<JSONMorphTargetsFile,JSONObject>{
	
	@Override
	protected JSONObject doForward(JSONMorphTargetsFile file) {
		return new JSONObject(file);
	}

	@Override
	protected JSONMorphTargetsFile doBackward(JSONObject object) {
		return object.getJavaScriptObject().cast();
	}

	
	public static String toJsonText(Iterable<JSONMorphTargetsFile> files){
		JSONFormatConverter converter=new JSONFormatConverter("JSONMorphTargetsFileConverter", "jsonmorphtargetfile");
		JSONValue value=converter.fromJsonObjectList(new JSONMorphTargetsFileConverter().convertAll(files));
		return converter.reverse().convert(value);
		//return Joiner.on("\r\n").join();
	 }
	
	public static Iterable<JSONMorphTargetsFile> fromJsonText(String text){
		
		JSONFormatConverter converter=new JSONFormatConverter("JSONMorphTargetsFileConverter","jsonmorphtargetfile");
		//todo check validate
		JSONValue jsonValue=null;
		
		
		// * converter make null error 
		 
		try{
			jsonValue=converter.convert(text);
		}catch (Exception e) {
			LogUtils.log(e.getMessage());
			return null;
		}
		
		List<JSONObject> datas=converter.toJsonObjectList(jsonValue);
		
		 Iterable<JSONMorphTargetsFile> newDatas=new JSONMorphTargetsFileConverter().reverse().convertAll(datas);
		 return newDatas;
	}
}
