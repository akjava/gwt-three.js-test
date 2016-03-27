package com.akjava.gwt.three.client.js.loaders;
import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
public class AnimationLoader extends JavaScriptObject{
protected AnimationLoader(){}


public static interface AnimationLoadHandler {
	public void loaded(JsArray<AnimationClip> animations);
}

public final native LoadingManager getManager()/*-{
return this.manager;
}-*/;

public final native void setManager(LoadingManager manager)/*-{
this.manager = manager;
}-*/;

public final native void load(String path,AnimationLoadHandler handler)/*-{
if(texturePath==null){
	texturePath=undefined;
}
this.load(path,function ( animations) {
	handler.@com.akjava.gwt.three.client.js.loaders.AnimationLoader$AnimationLoadHandler::loaded(Lcom/google/gwt/core/client/JsArray;)(animations);
	},texturePath);
}-*/;

public final native void load(String path,AnimationLoadHandler handler,XHRProgressHandler progressHandler,XHRErrorHandler errorHandler)/*-{
if(texturePath==null){
	texturePath=undefined;
}
this.load(path,function ( geometry,materials ) {
	handler.@com.akjava.gwt.three.client.js.loaders.AnimationLoader$AnimationLoadHandler::loaded(Lcom/google/gwt/core/client/JsArray;)(animations);
	},function ( onProgress ) {
	progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
	},function ( onError ) {
	errorHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRErrorHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
	});
}-*/;
public final native void load(String path,AnimationLoadHandler handler,XHRProgressHandler progressHandler)/*-{
if(texturePath==null){
	texturePath=undefined;
}
this.load(path,function ( geometry,materials ) {
	handler.@com.akjava.gwt.three.client.js.loaders.AnimationLoader$AnimationLoadHandler::loaded(Lcom/google/gwt/core/client/JsArray;)(animations);
	},function ( onProgress ) {
	progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
	});
}-*/;

}