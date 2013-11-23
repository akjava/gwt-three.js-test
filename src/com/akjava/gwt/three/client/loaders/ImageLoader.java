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
package com.akjava.gwt.three.client.loaders;

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


	public final native void load(String url,LoadHandler handler)/*-{
	this.load(url,function ( geometry ) {
		handler.@com.akjava.gwt.three.client.loaders.ImageLoader$LoadHandler::onLoad(Lcom/google/gwt/dom/client/ImageElement;)(geometry);
		}
		,function ( onProgress ) {
		handler.@com.akjava.gwt.three.client.loaders.ImageLoader$LoadHandler::onProgress(Lcom/google/gwt/dom/client/NativeEvent;)(onProgress);
		},function ( onError ) {
		handler.@com.akjava.gwt.three.client.loaders.ImageLoader$LoadHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
		});
}-*/;

public final native Object load(Object url,Object onLoad,Object onProgress,Object onError)/*-{
return this.load(url,onLoad,onProgress,onError);
}-*/;

public final native void setCrossOrigin(String value)/*-{
this.setCrossOrigin(value);
}-*/;

public static interface LoadHandler {
	public void onLoad(ImageElement imageElement);
	public void onProgress(NativeEvent progress);
	public void onError(NativeEvent error);
}

}
