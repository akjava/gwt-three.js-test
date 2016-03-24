/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013-2016 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r73
 https://github.com/mrdoob/three.js

The MIT License

Copyright &copy; 2010-2016 three.js authors

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
package com.akjava.gwt.three.client.js.animation;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * mainly used internal
 * @author aki
 *
 */
public class PropertyBinding extends JavaScriptObject{
	protected PropertyBinding() {
	}

	
public final native JavaScriptObject getRootNode()/*-{
return this.rootNode;
}-*/;

public final native String getPath()/*-{
return this.path;
}-*/;

public final native JavaScriptObject getParsedPath()/*-{
return this.parsedPath;
}-*/;

public final native JavaScriptObject getNode()/*-{
return this.node;
}-*/;



public static final native PropertyBinding create(JavaScriptObject root,String path,JavaScriptObject parsedPath)/*-{
return $wnd.THREE.PropertyBinding.create(root,path,parsedPath);
}-*/;

/**
 * 
 * @param trackName
 * @return
 	var results = {
		// directoryName: matches[1], // (tschw) currently unused
		nodeName: matches[3], 	// allowed to be null, specified root node.
		objectName: matches[5],
		objectIndex: matches[7],
		propertyName: matches[9],
		propertyIndex: matches[11]	// allowed to be null, specifies that the whole property is set.
	};
 */

public static final native JavaScriptObject parseTrackName(String trackName)/*-{
return $wnd.THREE.PropertyBinding.parseTrackName(trackName);
}-*/;

public static final native JavaScriptObject findNode(JavaScriptObject root,String nodeName)/*-{
return $wnd.THREE.PropertyBinding.findNode(root,nodeName);
}-*/;


}
