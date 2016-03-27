/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013-2015 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r69
 https://github.com/mrdoob/three.js

The MIT License

Copyright &copy; 2010-2014 three.js authors

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

import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.akjava.gwt.three.client.js.textures.CompressedTexture;
import com.google.gwt.core.client.JavaScriptObject;


public class CompressedTextureLoader extends JavaScriptObject{
	protected CompressedTextureLoader() {
	}
	public final native LoadingManager getManager()/*-{
	return this.manager;
	}-*/;

	public final native void setManager(LoadingManager manager)/*-{
	this.manager = manager;
	}-*/;


	public final native void load(String url,CompressedTextureLoadHandler handler)/*-{
	this.load(url,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.loaders.CompressedTextureLoader$CompressedTextureLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/textures/CompressedTexture;)(texture);
		});
	}-*/;
	
	public final native void load(String url,CompressedTextureLoadHandler handler,XHRProgressHandler progressHandler)/*-{
	this.load(url,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.loaders.CompressedTextureLoader$CompressedTextureLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/textures/CompressedTexture;)(texture);
		},function ( onProgress ) {
			progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
			});
	}-*/;

	public final native void load(String url,CompressedTextureLoadHandler handler,XHRProgressHandler progressHandler,XHRErrorHandler errorHandler)/*-{
	this.load(url,function ( texture ) {
		handler.@com.akjava.gwt.three.client.js.loaders.CompressedTextureLoader$CompressedTextureLoadHandler::onLoad(Lcom/akjava/gwt/three/client/js/textures/CompressedTexture;)(texture);
		},function ( onProgress ) {
			progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
			},function ( onError ) {
			errorHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRErrorHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
			});
	}-*/;

public static interface CompressedTextureLoadHandler {
	public void onLoad(CompressedTexture texture);
}

}
