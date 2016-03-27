package com.akjava.gwt.three.client.js.loaders;

import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.akjava.gwt.three.client.js.materials.Material;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JSONLoader extends Loader{

	protected JSONLoader(){
		
	}
	
	public final native LoadingManager getManager()/*-{
	return this.manager;
	}-*/;

	public final native void setManager(LoadingManager manager)/*-{
	this.manager = manager;
	}-*/;
	/**
	 * don't set null ,set JavaScriptUtils.createUndefinedValue();
	 * @param path
	 */
	public final  native void setTexturePath(String path)/*-{
	this.setTexturePath(path);
	}-*/;

	

	/**
	 * @deprecated texturePath is set by setTexturePath();
	 * @param path
	 * @param handler
	 * @param texturePath
	 */
	public final native void load(String path,JSONLoadHandler handler,String texturePath)/*-{
	if(texturePath==null){
		texturePath=undefined;
	}
	this.load(path,function ( geometry,materials ) {
		handler.@com.akjava.gwt.three.client.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/js/core/Geometry;Lcom/google/gwt/core/client/JsArray;)(geometry,materials);
		},texturePath);
	}-*/;
	
	public final native void load(String path,JSONLoadHandler handler)/*-{
	if(texturePath==null){
		texturePath=undefined;
	}
	this.load(path,function ( geometry,materials ) {
		handler.@com.akjava.gwt.three.client.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/js/core/Geometry;Lcom/google/gwt/core/client/JsArray;)(geometry,materials);
		},texturePath);
	}-*/;
	
	public final native void load(String path,JSONLoadHandler handler,XHRProgressHandler progressHandler,XHRErrorHandler errorHandler)/*-{
	if(texturePath==null){
		texturePath=undefined;
	}
	this.load(path,function ( geometry,materials ) {
		handler.@com.akjava.gwt.three.client.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/js/core/Geometry;Lcom/google/gwt/core/client/JsArray;)(geometry,materials);
		},function ( onProgress ) {
		progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
		},function ( onError ) {
		errorHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRErrorHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
		});
	}-*/;
	public final native void load(String path,JSONLoadHandler handler,XHRProgressHandler progressHandler)/*-{
	if(texturePath==null){
		texturePath=undefined;
	}
	this.load(path,function ( geometry,materials ) {
		handler.@com.akjava.gwt.three.client.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/js/core/Geometry;Lcom/google/gwt/core/client/JsArray;)(geometry,materials);
		},function ( onProgress ) {
		progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
		});
	}-*/;
	
	
	
	public static interface JSONLoadHandler {
		public void loaded(Geometry geometry,JsArray<Material> materials);
	}
	
	

	//TODO implement class to easy access
	public final native JavaScriptObject parse(JavaScriptObject json,String texturePath)/*-{
	return this.parse(json,texturePath);
	}-*/;
	
	/** @deprecated don't work anymore*/
	//public final native void createModel(JavaScriptObject object,JSONLoadHandler handler,String texturepath)/*-{
	//this.createModel(object,function ( geometry ) {
	//	handler.@com.akjava.gwt.three.client.js.loaders.JSONLoader$JSONLoadHandler::loaded(Lcom/akjava/gwt/three/client/core/Geometry;)(geometry);
	//	},texturepath);

	//}-*/;
	
	

	
	
}
