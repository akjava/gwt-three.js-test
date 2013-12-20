package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.core.MorphTarget;
import com.akjava.gwt.three.client.gwt.materials.LineBasicMaterialParameter;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.extras.GeometryUtils;
import com.akjava.gwt.three.client.js.extras.geometries.CubeGeometry;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.akjava.gwt.three.client.js.objects.Line;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class GWTGeometryUtils {

	private GWTGeometryUtils(){}
	
	
	/*
	 * from ,to used in vetex.clone by yourselef if it's necessaly
	 */
	public final static  Geometry createLineGeometry(Vector3 from,Vector3 to){
		Geometry lineG = THREE.Geometry();
		
		lineG.vertices().push(from);
		lineG.vertices().push(to);
		
		return lineG;
	}
	public final static boolean isSquare(CubeGeometry geometry){
		return geometry.getWidth()==geometry.getHeight() && geometry.getHeight()==geometry.getDepth();
	}
	
	public final static  Line createLineMesh(Vector3 from,Vector3 to,int color){
		return THREE.Line(GWTGeometryUtils.createLineGeometry(from, to),
				THREE.LineBasicMaterial(LineBasicMaterialParameter.create().color(color)));
	}
	
	public final static  Line createLineMesh(Vector3 from,Vector3 to,int color,double lineWidth){
		return THREE.Line(GWTGeometryUtils.createLineGeometry(from, to),
				THREE.LineBasicMaterial().color(color).linewidth(lineWidth).build());
	}
	
	public final static  Geometry clonePlusWeights(Geometry geo){
		Geometry cloned=GeometryUtils.clone(geo);
		for(int i=0;i<geo.getSkinIndices().length();i++){
			cloned.getSkinIndices().push(geo.getSkinIndices().get(i).clone());
		}
		for(int i=0;i<geo.getSkinWeight().length();i++){
			cloned.getSkinWeight().push(geo.getSkinWeight().get(i).clone());
		}
		return cloned;
	}
	public final static  Geometry mergeGeometryPlusWeights(Geometry geo1,Geometry geo2){
		
		GeometryUtils.merge(geo1, geo2);
		
		for(int i=0;i<geo2.getSkinIndices().length();i++){
			geo1.getSkinIndices().push(geo2.getSkinIndices().get(i));
		}
		
		for(int i=0;i<geo2.getSkinWeight().length();i++){
			geo1.getSkinWeight().push(geo2.getSkinWeight().get(i));
		}
				
		return geo1;
	}
/**
 * somehow Blender 2.65 Exporter make  all zero "skinIndices" & skinWeights,this geometry not sweat for skin
 * use this for avoid that.
 * @param geometry
 * @return
 */
	public final static boolean isValidSkinIndicesAndWeight(Geometry geometry){
		if(geometry.getSkinIndices()==null||geometry.getSkinWeight()==null){
			return false;
		}else if(geometry.getSkinIndices().length()==0 || geometry.getSkinWeight().length()==0){
			return false;
		}else if(geometry.getSkinIndices().length()!=geometry.getSkinWeight().length()){
			LogUtils.log("isValidSkinIndicesAndWeight():getSkinIndices and getSkinWeight length is difference");
			return false;
		}else{
			Vector4 zero=THREE.Vector4(0,0,0,0);
			boolean allzero=true;
			for(int i=0;i<geometry.getSkinWeight().length();i++){
				Vector4 weight=geometry.getSkinWeight().get(i);
				if(!weight.equals(zero)){
					allzero=false;
					break;
				}
			}
			if(allzero){
				LogUtils.log("isValidSkinIndicesAndWeight():all-zero weight");
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Warning center way is different of GeometryUtils.center()
	 * use center
	 * @param vertices
	 */
	public static final void centerOfVertices(JsArray<Vector3> vertices){
		Vector3 center=getCenter(vertices);
		for(int i=0;i<vertices.length();i++){
			vertices.get(i).subSelf(center);
		}
	}
	
	//set center for animation
	public static final void centerOfMorphTargets(Geometry geometry){
		JsArray<MorphTarget> mofs=geometry.getMorphTargets();
		GWT.log("mofs:"+mofs.length());
		for(int i=0;i<mofs.length();i++){
			GWT.log("mofs:-docenter"+i);
			centerOfVertices(mofs.get(i).getVertices());
		}
	}
	
	
	public static final native Vector3 getCenter(JsArray<Vector3> vertices)/*-{
	var center = new $wnd.THREE.Vector3();

for ( var i = 0, l = vertices.length; i < l; i ++ ) {

    center.addSelf(vertices[ i ].position );

} 
	center.divideScalar( vertices.length );
	return center;
	}-*/;
	
	
	public static final JSONObject loadJsonModel(String jsonText,JSONLoadHandler handler){
		JSONLoader loader=THREE.JSONLoader();
		JSONValue lastJsonValue = JSONParser.parseStrict(jsonText);
		JSONObject object=lastJsonValue.isObject();
		if(object==null){
			return null;
		}
		
		JavaScriptObject jsobject=loader.parse(object.getJavaScriptObject(), null);
		JSONObject newobject=new JSONObject(jsobject);
		handler.loaded((Geometry) newobject.get("geometry").isObject().getJavaScriptObject(),null);
		
		//loader.createModel(object.getJavaScriptObject(), handler, "");
		//loader.onLoadComplete();
		return object;
	}
	
	//TODO create return class
	public static final JSONObject loadJsonModelWithMaterial(String jsonText){
		JSONLoader loader=THREE.JSONLoader();
		JSONValue lastJsonValue = JSONParser.parseStrict(jsonText);
		JSONObject object=lastJsonValue.isObject();
		if(object==null){
			return null;
		}
		
		JavaScriptObject jsobject=loader.parse(object.getJavaScriptObject(), null);
		JSONObject newobject=new JSONObject(jsobject);
		
		return newobject;
	}
	
	
}
