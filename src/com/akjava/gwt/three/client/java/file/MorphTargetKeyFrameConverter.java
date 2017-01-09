package com.akjava.gwt.three.client.java.file;

import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.animation.KeyframeTrack;
import com.akjava.gwt.three.client.js.animation.tracks.NumberKeyframeTrack;
import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONString;

public class MorphTargetKeyFrameConverter extends Converter<List<MorphTargetKeyFrame>,JSONMorphTargetsFile>{

	@Override
	protected JSONMorphTargetsFile doForward(List<MorphTargetKeyFrame> list) {
		LogUtils.log("debug MorphTargetKeyFrameConverter:size:"+list.size());
		if(list.isEmpty()){
			throw new RuntimeException("MorphTargetKeyFrameConverter:list is empty.cant get keyName");
		}
		JSONMorphTargetsFile file=new JSONMorphTargetsFile();
		file.put("name", new JSONString(list.get(0).getKeyName()));
		
		JsArrayNumber times=JsArray.createArray().cast();
		JsArrayNumber values=JsArray.createArray().cast();
		
		for(MorphTargetKeyFrame frame:list){
			times.push(frame.getTime());
			values.push(frame.getValue());
		}
		file.put("times",new JSONArray( times));
		file.put("values",new JSONArray( values));
		
		LogUtils.log("debug MorphTargetKeyFrameConverter:converted:"+list.get(0).getKeyName());
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


	public static AnimationClip converToAnimationClip(Iterable<List<MorphTargetKeyFrame>> framesList,String animationClipName,MorphtargetsModifier modifier,JSParameter morphTargetDictionary){
		
		JsArray<KeyframeTrack> tracks=JavaScriptObject.createArray().cast();
		for(List<MorphTargetKeyFrame> list:framesList){
			String key=list.get(0).getKeyName();//TODO check size?
		
			if(!morphTargetDictionary.exists(key)){
				LogUtils.log("MorphTargetKeyFrameConverter-converToAnimationClip:call not exist key="+key+".skipped creating track");
				continue;
			}
			int index=morphTargetDictionary.getInt(key);//possible null?
			NumberKeyframeTrack track=morphTargetKeyFrameToTrack(key,index,list,modifier);
			tracks.push(track);
		}
		
		AnimationClip clip=THREE.AnimationClip(animationClipName, -1, tracks);
		return clip;
	}
	
	public static NumberKeyframeTrack morphTargetKeyFrameToTrack(String keyName,int index,List<MorphTargetKeyFrame> frames,MorphtargetsModifier modifier){
		String trackName=".morphTargetInfluences["+index+"]";
		
		
		JsArrayNumber times=JavaScriptObject.createArray().cast();
		JsArrayNumber values=JavaScriptObject.createArray().cast();
		for(MorphTargetKeyFrame frame:frames){
			times.push(frame.getTime()/1000);//millisecond to second
			values.push(toModifyValue(keyName,frame.getValue(),modifier));
		}
		
		NumberKeyframeTrack track=THREE.NumberKeyframeTrack(trackName, times, values);
		return track;
	}

	//TODO BasicExpressionPanel to better location
	private static double toModifyValue(String key,double value,MorphtargetsModifier modifier) {
		return modifier.getModifiedValue(key, value);
	}
}
