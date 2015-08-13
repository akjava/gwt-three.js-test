package com.akjava.gwt.threejsexamples.client;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

public class JsUtils {

	//TODO move JavaScriptUtils
	/*
	 * helping convert from ["",""] to Utils.of("","")
	 */
	public static final JsArrayString of(String... string){
	JsArrayString strings=JavaScriptUtils.createJSArray().cast();
	for(String v:string){
		strings.push(v);
	}
	return strings;
	}
	
	public static final JsArrayNumber of(Number... numbers){
		JsArrayNumber values=JavaScriptUtils.createJSArray().cast();
		for(Number v:numbers){
			values.push(v.doubleValue());
		}
		return values;
		}
	
	public static final JsArray<JavaScriptObject>  of(JavaScriptObject... js){
		JsArray<JavaScriptObject> values=JavaScriptUtils.createJSArray().cast();
		for(JavaScriptObject v:js){
			values.push(v);
		}
		return values;
		}

}
