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

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.NativeEvent;


public class LoadingManager extends JavaScriptObject{
	protected LoadingManager() {
	}

public final native void itemStart(String url)/*-{
this.itemStart(url);
}-*/;

public final native void itemEnd(String url)/*-{
this.itemEnd(url);
}-*/;


public final native void setLoadHandler(LoadingManagerHandler handler)/*-{
this.onLoad=function (  ) {
handler.@com.akjava.gwt.three.client.js.loaders.LoadingManager$LoadingManagerHandler::onLoad()();
};
this.onProgress=function ( url,loaded,total ) {
handler.@com.akjava.gwt.three.client.js.loaders.LoadingManager$LoadingManagerHandler::onProgress(Ljava/lang/String;II)(url,loaded,total);
};
this.onError=function ( onError ) {
handler.@com.akjava.gwt.three.client.js.loaders.LoadingManager$LoadingManagerHandler::onError(Lcom/google/gwt/dom/client/NativeEvent;)(onError);
};
}-*/;

public static interface LoadingManagerHandler {
public void onLoad();
public void onProgress(String url,int loaded,int total);
public void onError(NativeEvent error);
}


public final native void setOnStartHandler(LoadingManagerOnStartHandler handler)/*-{

this.onStart=function ( url,loaded,total ) {
handler.@com.akjava.gwt.three.client.js.loaders.LoadingManager$LoadingManagerOnStartHandler::onStart(Ljava/lang/String;II)(url,loaded,total);
};
}-*/;
public static interface LoadingManagerOnStartHandler {
public void onStart(String url,int loaded,int total);
}
}
