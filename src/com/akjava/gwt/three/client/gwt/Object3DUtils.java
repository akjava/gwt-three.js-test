package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.core.client.JsArray;

public class Object3DUtils {

	/**
	 * 
	 * @param target
	 * @param bool
	 */
	public static void setVisibleAll(Object3D target,boolean bool){
	target.setVisible(bool);
	JsArray<Object3D> array=target.getChildren();
	for(int i=0;i<array.length();i++){
		setVisibleAll(array.get(i),bool);
		}
	}
}
