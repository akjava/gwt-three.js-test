package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Quaternion;

/**
 * @deprecated who use this?
 * @author aki
 *
 */
public class ThreeValueUtils {
private ThreeValueUtils(){}
	
	public static String toString(Quaternion q,String separator){
	return q.getX()+separator+q.getY()+separator+separator+q.getZ()+separator+q.getW();
	}
	
	public static Quaternion fromString(String text,String separator){
		String[] vs=text.split(separator);
			if(vs.length!=4){
			LogUtils.log("fromString not size 4");
			return null;
			}
		return THREE.Quaternion(Double.parseDouble(vs[0]), Double.parseDouble(vs[1]), Double.parseDouble(vs[2]), Double.parseDouble(vs[3]));
	}
}
