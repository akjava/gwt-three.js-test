package com.akjava.gwt.three.client.js.loaders;
import com.akjava.gwt.three.client.js.extras.core.Font;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.google.gwt.core.client.JavaScriptObject;
public class FontLoader extends JavaScriptObject{
protected FontLoader(){}
public final native LoadingManager getManager()/*-{
return this.manager;
}-*/;

public final native void setManager(LoadingManager manager)/*-{
this.manager = manager;
}-*/;
public final native void load(String url,FontLoadHandler handler)/*-{
this.load(url,function ( font ) {
	handler.@com.akjava.gwt.three.client.js.loaders.FontLoader$FontLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/extras/core/Font;)(font);
	});
}-*/;

public final native void load(String url,FontLoadHandler handler,XHRProgressHandler progressHandler)/*-{
this.load(url,function ( font ) {
	handler.@com.akjava.gwt.three.client.js.loaders.FontLoader$FontLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/extras/core/Font;)(font);
	},function ( onProgress ) {
		progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
		});
}-*/;

public final native void load(String url,FontLoadHandler handler,XHRProgressHandler progressHandler,XHRErrorHandler errorHandler)/*-{
this.load(url,function ( font ) {
	handler.@com.akjava.gwt.three.client.js.loaders.FontLoader$FontLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/extras/core/Font;)(font);
	},function ( onProgress ) {
		progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
		},function ( onError ) {
		errorHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRErrorHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
		});
}-*/;

public static interface FontLoadHandler {
	public void onLoad(Font font);
}
}