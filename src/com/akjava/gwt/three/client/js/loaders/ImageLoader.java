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

import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRErrorHandler;
import com.akjava.gwt.three.client.js.loaders.XHRLoader.XHRProgressHandler;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.NativeEvent;

/**
 * manager not support yet
 * @author aki
 *
 */
public class ImageLoader extends JavaScriptObject{
	protected ImageLoader() {
	}
	
	public final native void getgManager()/*-{
	return manager;
	}-*/;

	public final native void setManager(LoadingManager manager)/*-{
	this.manager=manager;
	}-*/;


	public final native void load(String url,ImageLoadHandler handler)/*-{
	this.load(url,function ( image ) {
		handler.@com.akjava.gwt.three.client.js.loaders.ImageLoader$ImageLoadHandler::onLoad(Lcom/google/gwt/dom/client/ImageElement;)(image);
		});
}-*/;
	
	public final native void load(String url,ImageLoadHandler handler,XHRProgressHandler progressHandler)/*-{
	this.load(url,function ( image ) {
		handler.@com.akjava.gwt.three.client.js.loaders.ImageLoader$ImageLoadHandler::onLoad(Lcom/google/gwt/dom/client/ImageElement;)(image);
		},function ( onProgress ) {
			progressHandler.@com.akjava.gwt.three.client.js.loaders.XHRLoader$XHRProgressHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
			});
	}-*/;

	public final native void load(String url,ImageLoadHandler handler,XHRProgressHandler progressHandler,XHRErrorHandler errorHandler)/*-{
	this.load(url,function ( image ) {
		handler.@com.akjava.gwt.three.client.js.loaders.ImageLoader$ImageLoadHandler::onLoad(Lcom/google/gwt/dom/client/ImageElement;)(image);
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

public static interface ImageLoadHandler {
	public void onLoad(ImageElement imageElement);
	/**
	 * @deprecated
	 * @param progress
	 */
	public void onProgress(NativeEvent progress);
	/**
	 * @deprecated
	 * @param progress
	 */
	public void onError(NativeEvent error);
}


}
