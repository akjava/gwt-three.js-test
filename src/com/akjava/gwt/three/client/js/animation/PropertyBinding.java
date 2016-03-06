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


public final native String getTrackName()/*-{
return this.trackName;
}-*/;




public final native int getReferenceCount()/*-{
return this.referenceCount;
}-*/;



//return any
public final native JavaScriptObject getOriginalValue()/*-{
return this.originalValue;
}-*/;



public final native String getDirectoryName()/*-{
return this.directoryName;
}-*/;

public final native void setDirectoryName(String directoryName)/*-{
this.directoryName = directoryName;
}-*/;


public final native String getNodeName()/*-{
return this.nodeName;
}-*/;

public final native void setNodeName(String nodeName)/*-{
this.nodeName = nodeName;
}-*/;


public final native String getObjectName()/*-{
return this.objectName;
}-*/;

public final native void setObjectName(String objectName)/*-{
this.objectName = objectName;
}-*/;


public final native int getObjectIndex()/*-{
return this.objectIndex;
}-*/;

public final native void setObjectIndex(int objectIndex)/*-{
this.objectIndex = objectIndex;
}-*/;


public final native String getPropertyName()/*-{
return this.propertyName;
}-*/;

public final native void setPropertyName(int propertyName)/*-{
this.propertyName = propertyName;
}-*/;


public final native int getPropertyIndex()/*-{
return this.propertyIndex;
}-*/;

public final native void setPropertyIndex(int propertyIndex)/*-{
this.propertyIndex = propertyIndex;
}-*/;


public final native JavaScriptObject getNode()/*-{
return this.node;
}-*/;

public final native void setNode(JavaScriptObject node)/*-{
this.node = node;
}-*/;


public final native JavaScriptObject getCumulativeValue()/*-{
return this.cumulativeValue;
}-*/;

public final native void setCumulativeValue(JavaScriptObject cumulativeValue)/*-{
this.cumulativeValue = cumulativeValue;
}-*/;


public final native double getCumulativeWeight()/*-{
return this.cumulativeWeight;
}-*/;

public final native void setCumulativeWeight(double cumulativeWeight)/*-{
this.cumulativeWeight = cumulativeWeight;
}-*/;



public final native void reset()/*-{
this.reset();
}-*/;

/**
 * TODO make other type
 * @param value
 * @param weight
 */
public final native void accumulate(JavaScriptObject value,double weight)/*-{
this.accumulate(value,weight);
}-*/;

public final native void unbind()/*-{
 this.unbind();
}-*/;

public final native void bind()/*-{
this.bind();
}-*/;

public final native void apply()/*-{
this.apply();
}-*/;

public final native JavaScriptObject parseTrackName(String trackName)/*-{
return this.parseTrackName(trackName);
}-*/;

public final native JavaScriptObject findNode(JavaScriptObject root,String nodeName)/*-{
return this.findNode(root,nodeName);
}-*/;


}
