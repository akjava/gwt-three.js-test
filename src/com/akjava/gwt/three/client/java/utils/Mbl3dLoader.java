package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.gwt.loader.JSONLoaderObject;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRLoadHandler;
import com.akjava.gwt.three.client.js.math.THREEMath;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;


/*
 * for mbl3d 1.1 and three.js r74
 * 
 * I'm not confirmed this bug fixed newer three.js.I'm still developing gwt-wrapper with r74
 * anyway only way to load with shapekeys
 * 
 * T
 */
public class Mbl3dLoader {


	

	private boolean forceApplyAxisAngle=false;
	private boolean applyAxisAngle=true;
	public boolean isApplyAxisAngle() {
		return applyAxisAngle;
	}
	public void setApplyAxisAngle(boolean applyAxisAngle) {
		this.applyAxisAngle = applyAxisAngle;
	}

	private boolean fixVertices=true;
	public boolean isFixVertices() {
		return fixVertices;
	}
	public void setFixVertices(boolean fixVertices) {
		this.fixVertices = fixVertices;
	}
	/**
	 *
	 * @param text
	 * @param loadHandler
	 * @return anyway return json object
	 */
	public JSONValue  parse(String text,final JSONLoadHandler loadHandler){

		//final JSONValue json=JSONParser.parseStrict(text);
		
		//fixing  jsonobj inside
		JSONObject jsonObj=GWTThreeUtils.parseJSONGeometryObject(text);
		
		
		
		if(fixVertices){//TODO check need fix
		JSONValue jsonMorph=jsonObj.get("morphTargets");
		if(jsonMorph!=null){
			
		JSONArray morphArray=jsonMorph.isArray();
		
		if(morphArray!=null){
		for(int i=0;i<morphArray.size();i++){
			
			JSONValue jsonMorphTarget=morphArray.get(i);
			JSONObject morphTarget=jsonMorphTarget.isObject();
			
			
			JSONValue jsonVertices=morphTarget.get("vertices");
			
			if(jsonVertices!=null){
				
				JSONArray vertices=jsonVertices.isArray();
				
				if(vertices!=null){
					
					
				JsArrayNumber fixed=convertMorphVertices(vertices);
				if(fixed!=null){
					JSONArray fixedArray=new JSONArray(fixed);
					morphTarget.put("vertices", fixedArray);
				}else{
					LogUtils.log("no need to fix");
				}
			}
			
			}else{
				LogUtils.log("1 length vertices maybe safe");
			}
		}
		LogUtils.log("fixed morph targets:"+morphArray.size());
		}
		}else{
			LogUtils.log("Mbl3dLoader:no morphTargets.skip fixing");
		}
		}
		//LogUtils.log(jsonObj.getJavaScriptObject());
		JSONLoader jsonLoader=THREE.JSONLoader();
		JSONLoaderObject loadedObject=jsonLoader.parse(jsonObj.getJavaScriptObject());
		
		loadHandler.loaded(loadedObject.getGeometry(), loadedObject.getMaterials());
		
		return jsonObj;
	}
	public void load(String url,final JSONLoadHandler loadHandler){
		THREE.XHRLoader().load(url,new XHRLoadHandler() {
			@Override
			public void onLoad(String text) {
				parse(text,loadHandler);
			}
		});
		
	}
	
	public Mbl3dLoader applyAxisAngle(boolean  value){
		applyAxisAngle=value;
		return this;
	}
	public Mbl3dLoader forceApplyAxisAngle(boolean  value){
		forceApplyAxisAngle=value;
		return this;
	}
	
	
	//fix r74 blender exporter blend keys
	//TODO make method
	public JsArrayNumber convertMorphVertices(JSONArray morphTargetsVertices){
		JsArrayNumber arrays=JavaScriptObject.createArray().cast();
		Vector3 axis = THREE.Vector3( 1, 0, 0 );
		double angle = THREEMath.degToRad( -90 );
		
		boolean needApplyAxisAngle=false;
		LOOP:for(int i=0;i<morphTargetsVertices.size();i++){
			JSONValue avalue=morphTargetsVertices.get(i);
			JSONArray verticesArray=avalue.isArray();
			if(verticesArray==null){//no need fix
				if(!forceApplyAxisAngle){
				return null;
				}else{
					needApplyAxisAngle=true;
					break LOOP;
				}
			}
			JsArrayNumber verticesNumber=verticesArray.getJavaScriptObject().cast();
			
			Vector3 vec=THREE.Vector3().fromArray(verticesNumber);
			if(applyAxisAngle){
				vec.applyAxisAngle( axis, angle );
			}
			
			//should i make options?
			arrays.push(fixNumber(vec.getX()));
			arrays.push(fixNumber(vec.getY()));
			arrays.push(fixNumber(vec.getZ()));
		}
		
		if(needApplyAxisAngle){
			for(int i=0;i<morphTargetsVertices.size();i+=3){
				double x=morphTargetsVertices.get(i).isNumber().doubleValue();
				double y=morphTargetsVertices.get(i+1).isNumber().doubleValue();
				double z=morphTargetsVertices.get(i+2).isNumber().doubleValue();
				Vector3 vec=THREE.Vector3(x,y,z);
				vec.applyAxisAngle( axis, angle );
				arrays.push(fixNumber(vec.getX()));
				arrays.push(fixNumber(vec.getY()));
				arrays.push(fixNumber(vec.getZ()));
			}
			LogUtils.log("force apply axis");
		}
		
		
		return arrays;
	}
	/*
	 * without fix 1 to 0.99999999999999999997 and this make file too big
	 */
	public double fixNumber(double number){
		String fixed=toFixed(number, 6);
		return Double.valueOf(fixed);
	}
	
	  private  native String toFixed(double number, int n) /*-{
	    return number.toFixed(n);
	  }-*/;

}
