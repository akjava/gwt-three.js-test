package com.akjava.gwt.three.client.java;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.boneanimation.AnimationBone;
import com.akjava.gwt.three.client.gwt.core.BoundingBox;
import com.akjava.gwt.three.client.java.utils.GWTThreeUtils;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Euler;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Sphere;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.akjava.gwt.three.client.js.objects.SkinnedMesh;
import com.google.gwt.core.client.JsArrayNumber;

public class ThreeLog extends LogUtils{

	public static String getAngle(Matrix4 mx){
		if(mx==null){
			return "Null";
		}
		Vector3 vec=THREE.Vector3();
		vec.getRotationFromMatrix(mx);
		return getAngle(vec);
	}
	public static String getAngle(Vector3 vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+Math.toDegrees(vec.getX());
		ret+=",y:"+Math.toDegrees(vec.getY());
		ret+=",z:"+Math.toDegrees(vec.getZ());
		return ret;
	}
	public static String getAsDegree(Vector3 vec){
		return get(GWTThreeUtils.radiantToDegree(vec));
	}
	public static String get(Vector3 vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+vec.getX();
		ret+=",y:"+vec.getY();
		ret+=",z:"+vec.getZ();
		return ret;
	}
	
	public static String get(Sphere vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+vec.getCenter().getX();
		ret+=",y:"+vec.getCenter().getY();
		ret+=",z:"+vec.getCenter().getZ();
		ret+=",radius:"+vec.getRadius();
		return ret;
	}
	
	public static String get(BoundingBox vec){
		if(vec==null){
			return "Null";
		}
		String ret="min{x:"+vec.getMin().getX();
		ret+=",y:"+vec.getMin().getY();
		ret+=",z:"+vec.getMin().getZ();
		ret+="} ";
		ret+="max{x:"+vec.getMax().getX();
		ret+=",y:"+vec.getMax().getY();
		ret+=",z:"+vec.getMax().getZ();
		ret+="} ";
		return ret;
	}
	
	public static String get(Euler vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+Math.toDegrees(vec.getX());
		ret+=",y:"+Math.toDegrees(vec.getY());
		ret+=",z:"+Math.toDegrees(vec.getZ());
		
		ret+=","+vec.getOrder();
		return ret;
	}
	public static String get(Vector2 vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+vec.getX();
		ret+=",y:"+vec.getY();
		return ret;
	}
	public static String get(Vector4 vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+vec.getX();
		ret+=",y:"+vec.getY();
		ret+=",z:"+vec.getZ();
		ret+=",w:"+vec.getW();
		return ret;
	}
	
	public static String get(AnimationBone bone){
		if(bone==null){
			return "Null";
		}
		String ret=get(THREE.Vector3().fromArray(bone.getPos()));
		
		return ret;
	}
	
	public static String get(Quaternion vec){
		if(vec==null){
			return "Null";
		}
		String ret="x:"+vec.getX();
		ret+=",y:"+vec.getY();
		ret+=",z:"+vec.getZ();
		ret+=",w:"+vec.getW();
		return ret;
	}
	public static String get(JsArrayNumber numbers){
		if(numbers==null){
			return "Null";
		}
		
		String ret="";
		for(int i=0;i<numbers.length();i++){
			ret+=numbers.get(i)+",";
		}
		return ret;
	}
	
	public static void log(Vector2 vec){
		LogUtils.log(get(vec));
	}
	
	public static void log(String header,double vec){
		LogUtils.log(header+" "+vec);
	}
	
	public static void log(String header,Vector2 vec){
		LogUtils.log(header+" "+get(vec));
	}
	
	public static void log(Vector3 vec){
		LogUtils.log(get(vec));
	}
	
	public static void log(String header,Vector3 vec){
		LogUtils.log(header+" "+get(vec));
	}
	public static void log(Vector4 vec){
		LogUtils.log(get(vec));
	}
	public static void log(String header,AnimationBone vec){
		LogUtils.log(header+" "+get(vec));
	}
	public static void log(AnimationBone vec){
		LogUtils.log(get(vec));
	}
	
	public static void log(String header,Euler vec){
		LogUtils.log(header+" "+get(vec));
	}
	
	public static void log(Euler vec){
		LogUtils.log(get(vec));
	}
	
	public static void log(String header,Vector4 vec){
		LogUtils.log(header+" "+get(vec));
	}
	
	public static void logBoneNames(SkinnedMesh characterMesh) {
		if(characterMesh.getGeometry().getBones()==null){
			LogUtils.log("no bone");
			return;
		}
		for(int i=0;i<characterMesh.getGeometry().getBones().length();i++){
			LogUtils.log(i+","+characterMesh.getGeometry().getBones().get(i).getName());
		}
	}
	public static void log(String header, Quaternion quaternion) {
		LogUtils.log(header+" "+get(quaternion));
	}
	public static void log(String header, BoundingBox box) {
		log(header+" "+get(box));
	}
	public static void log(String header, Sphere sphere) {
		log(header+" "+get(sphere));
	}
}
