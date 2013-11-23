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
import com.google.gwt.dom.client.Element;


public class Loader extends JavaScriptObject{
	protected Loader() {
	}

public final native boolean isShowStatus()/*-{
return this.showStatus;
}-*/;

public final native Element getStatusDomElement()/*-{
return this.statusDomElement;
}-*/;

public final native void onLoadStart()/*-{
this.onLoadStart();
}-*/;

public final native void onLoadProgress()/*-{
this.onLoadProgress();
}-*/;

public final native void onLoadComplete()/*-{
this.onLoadComplete();
}-*/;

public final native void setLoadHandler(LoadHandler handler)/*-{
	this.onLoadStart=function (  ) {
	handler.@com.akjava.gwt.three.client.loaders.Loader$LoadHandler::onLoadStart()();
	};
	this.onLoadProgress=function (  ) {
	handler.@com.akjava.gwt.three.client.loaders.Loader$LoadHandler::onLoadProgress()();
	};
	this.onLoadComplete=function (  ) {
	handler.@com.akjava.gwt.three.client.loaders.Loader$LoadHandler::onLoadComplete()();
	};
}-*/;

public static interface LoadHandler {
	public void onLoadStart();
	public void onLoadProgress();
	public void onLoadComplete();
}
}
