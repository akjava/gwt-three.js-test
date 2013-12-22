package com.akjava.gwt.three.client.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.loaders.JSONLoader;
import com.akjava.gwt.three.client.js.loaders.JSONLoader.JSONLoadHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;


//TODO retry and timeout
public class MultiGeometryLoader {
private Map<String,String> lists;
private LoadMonitor monitor;
	public MultiGeometryLoader(Map<String,String> lists,LoadMonitor monitor){
		this.lists=lists;
		this.monitor=monitor;
	}
private Map<String,Geometry> geometries;
private List<String> remains;
	public void startLoad(){
		geometries=new HashMap<String,Geometry>();
		JSONLoader loader=THREE.JSONLoader();
		remains=new ArrayList<String>();
		for(String name:lists.keySet()){
			remains.add(name);
		}
		for(String name:lists.keySet()){
			String path=lists.get(name);
			loader.load(path,new Loaded(name));
		}
	}
	public synchronized void done(String name){
		remains.remove(name);
		if(remains.size()==0){
			monitor.loadComplete(geometries);
		}
	}
	
	public class Loaded implements JSONLoadHandler{
		private String name;
		public Loaded(String name){
			this.name=name;
		}
		@Override
		public void loaded(Geometry geometry,JsArray<Material> ms) {
			log("loaded:"+name);
			log(geometry);
			// TODO Auto-generated method stub
			geometries.put(name, geometry);
			done(name);
		}
		
	}
	
	
	public interface LoadMonitor{
		public void loadComplete(Map<String,Geometry> geos);
	}
	

	public static final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;
	public static final native void log(String object)/*-{
	console.log(object);
	}-*/;
}
