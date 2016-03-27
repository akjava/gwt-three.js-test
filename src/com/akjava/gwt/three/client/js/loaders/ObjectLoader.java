/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r63
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2013 three.js Authors. All rights reserved.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
  
 */
package com.akjava.gwt.three.client.js.loaders;

import com.akjava.gwt.three.client.js.animation.AnimationClip;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/**
 * not test yet
 * @author aki
 *
 */
public class ObjectLoader extends JavaScriptObject{
	protected ObjectLoader() {
	}

	public final native LoadingManager getManager()/*-{
	return this.manager;
	}-*/;

	public final native void setManager(LoadingManager manager)/*-{
	this.manager = manager;
	}-*/;

	public final native void load(String url,ObjectLoadHandler handler)/*-{
	this.load(url,function ( object ) {
		handler.@com.akjava.gwt.three.client.js.loaders.ObjectLoader$ObjectLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/core/Object3D;)(object);
		}
		);
	}-*/;
	
	public final native void load(String url,ObjectLoadHandler handler,XHRProgressHandler progressHandler)/*-{
	this.load(url,function ( object ) {
		handler.@com.akjava.gwt.three.client.js.loaders.ObjectLoader$ObjectLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/core/Object3D;)(object);
		},function ( onProgress ) {
			progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
			});
	}-*/;

	public final native void load(String url,ObjectLoadHandler handler,XHRProgressHandler progressHandler,XHRErrorHandler errorHandler)/*-{
	this.load(url,function ( object ) {
		handler.@com.akjava.gwt.three.client.js.loaders.ObjectLoader$ObjectLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/core/Object3D;)(object);
		},function ( onProgress ) {
			progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
			},function ( onError ) {
			errorHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRErrorHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
			});
	}-*/;

	public final native void setCrossOrigin(String value)/*-{
	this.setCrossOrigin(value);
	}-*/;

	public final native void setPath(String value)/*-{
	this.setPath(value);
	}-*/;
	

public final native Object3D parse(JavaScriptObject json)/*-{
return this.parse(json);
}-*/;

public final native JavaScriptObject parseGeometries(JavaScriptObject json)/*-{
return this.parseGeometries(json);
}-*/;

public final native JavaScriptObject parseMaterials(JavaScriptObject json,JavaScriptObject textures)/*-{
return this.parseMaterials(json);
}-*/;

public final native JsArray<AnimationClip> parseAnimations(JavaScriptObject json)/*-{
return this.parseAnimations(json);
}-*/;

public final native JavaScriptObject parseImages(JavaScriptObject json,ObjectLoadHandler onLoad)/*-{
return this.parseImages(json);
}-*/;

public final native JavaScriptObject parseTextures(JavaScriptObject json,JavaScriptObject images)/*-{
return this.parseTextures(json,images);
}-*/;

public final native Object3D parseObject(JavaScriptObject object,JavaScriptObject geometrys,JavaScriptObject materials)/*-{
return this.parseObject(object,geometrys,materials);
}-*/;

public static interface ObjectLoadHandler {
	/**
	 * possible scene or other type,and contain animations
	 * @param object
	 */
	public void onLoad(Object3D object);
}

}
