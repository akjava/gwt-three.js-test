package com.akjava.gwt.three.client.java.ui.experiments;

import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;

public class MorphTargetKeyFrameConverter extends Converter<List<MorphTargetKeyFrame>,JSONMorphTargetsFile>{

	@Override
	protected JSONMorphTargetsFile doForward(List<MorphTargetKeyFrame> list) {
		JSONMorphTargetsFile file=new JSONMorphTargetsFile();
		file.set("name", list.get(0).getKeyName());
		
		JsArrayNumber times=JsArray.createArray().cast();
		JsArrayNumber values=JsArray.createArray().cast();
		
		for(MorphTargetKeyFrame frame:list){
			times.push(frame.getTime());
			values.push(frame.getValue());
		}
		file.set("times", times);
		file.set("values", values);
		
		return file;
	}

	@Override
	protected List<MorphTargetKeyFrame> doBackward(JSONMorphTargetsFile morphTargetFile) {
		List<MorphTargetKeyFrame> list=Lists.newArrayList();
		
		JsArrayNumber times=morphTargetFile.getArrayNumber("times");
		if(times==null){
			LogUtils.log("MorphTargetKeyFrameConverter:not contain times");
			return null;
		}
		JsArrayNumber values=morphTargetFile.getArrayNumber("values");
		if(values==null){
			LogUtils.log("MorphTargetKeyFrameConverter:not contain values");
			return null;
		}
		if(times.length()!=values.length()){
			LogUtils.log("MorphTargetKeyFrameConverter:difference length");
			return null;
		}
		
		String name=morphTargetFile.getString("name");
		if(name==null){
			LogUtils.log("MorphTargetKeyFrameConverter:not contain name");
			return null;
		}
		
		for(int i=0;i<times.length();i++){
			MorphTargetKeyFrame frame=new MorphTargetKeyFrame(name,times.get(i),values.get(i));
			list.add(frame);
		}
		
		return list;
	}


}
