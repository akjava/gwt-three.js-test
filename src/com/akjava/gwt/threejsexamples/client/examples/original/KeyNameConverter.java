package com.akjava.gwt.threejsexamples.client.examples.original;

import java.util.Collections;
import java.util.List;

import com.akjava.gwt.lib.client.LogUtils;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class KeyNameConverter {
	public static final String EYES="eyes";
	public static final String BROW="brow";
	public static final String MOUTH="mouth";
	public static final String KEY_HEADER="Expressions_";

	
	/*
	 *  Expressions_EYES_02_max > 02_max
	 */
	public static String convertToSimpleName(String fullName){
		if(!fullName.startsWith(KEY_HEADER)){
			LogUtils.log("possible invalid id:"+fullName);
			return fullName;
		}
		String name=fullName.substring(KEY_HEADER.length());
		
		//ommit eyes,brow,mouth
		if(name.startsWith(EYES)){
			name=name.substring(EYES.length());
		}
		if(name.startsWith(BROW)){
			name=name.substring(BROW.length());
		}
		if(name.startsWith(MOUTH)){
			name=name.substring(MOUTH.length());
		}
		
		return name;
	}
	
	/*
	 * 02_max > Expressions_EYES_02_max
	 * 
	 */
	public static String convertToFullName(String type,String simpleName){
		if(!type.startsWith(EYES) && !type.startsWith(BROW) && !type.startsWith(MOUTH)){
			LogUtils.log("invalid type:"+type);
			return simpleName;
		}
		
		return KEY_HEADER+type+simpleName;
	}
	
	public static String convertToSimpleId(Mblb3dExpression expression){
		List<String> list=Lists.newArrayList(expression.getKeys());
		Collections.sort(list);
		List<String> brows=Lists.newArrayList();
		List<String> eyes=Lists.newArrayList();
		List<String> mouths=Lists.newArrayList();
		
		for(String key:list){
			if(key.contains(BROW)){
				brows.add(convertToSimpleName(key));
			}else if(key.contains(EYES)){
				eyes.add(convertToSimpleName(key));
			}else if(key.contains(MOUTH)){
				mouths.add(convertToSimpleName(key));
			}
		}
		
		Joiner joiner=Joiner.on(",");
		return joiner.join(brows)+"-"+joiner.join(eyes)+"-"+joiner.join(mouths);
	}
	
}
