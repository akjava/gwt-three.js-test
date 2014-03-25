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
package com.akjava.gwt.three.client.js.core;

import com.akjava.gwt.three.client.gwt.core.Offsets;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.typedarrays.shared.ArrayBuffer;


public class BufferGeometry extends EventDispatcher{
	protected BufferGeometry() {
	}



	//TODO make return class
	public final native JsArray<JavaScriptObject> computeOffsets(int indexBufferSize)/*-{
	return this.computeOffsets(indexBufferSize);
	}-*/;

	public final native void reorderBuffers(ArrayBuffer indexBuffer,ArrayBuffer indexMap,int vertexCount)/*-{
	this.reorderBuffers(indexBuffer,indexMap,vertexCount);
	}-*/;




public final native Object getAttributes()/*-{
return this.attributes;
}-*/;

public final native void setAttributes(Object attributes)/*-{
this.attributes = attributes;
}-*/;





public final native JsArray<Offsets> getOffsets()/*-{
return this.offsets;
}-*/;

public final native void setOffsets(JsArray<Offsets> offsets)/*-{
this.offsets = offsets;
}-*/;


public final native Object getBoundingBox()/*-{
return this.boundingBox;
}-*/;

public final native void setBoundingBox(Object boundingBox)/*-{
this.boundingBox = boundingBox;
}-*/;


public final native Object getBoundingSphere()/*-{
return this.boundingSphere;
}-*/;

public final native void setBoundingSphere(Object boundingSphere)/*-{
this.boundingSphere = boundingSphere;
}-*/;


public final native boolean isHasTangents()/*-{
return this.hasTangents;
}-*/;

public final native void setHasTangents(boolean hasTangents)/*-{
this.hasTangents = hasTangents;
}-*/;

/**
 * i have no idea what is it type?
 * @return
 */
public final native JsArray getMorphTargets()/*-{
return this.morphTargets;
}-*/;
/**
 * i have no idea what is it type?
 * @return
 */
public final native void setMorphTargets(JsArray morphTargets)/*-{
this.morphTargets = morphTargets;
}-*/;

public final native void addAttribute(Object name,Object type,Object numItems,Object itemSize)/*-{
this.addAttribute(name,type,numItems,itemSize);
}-*/;

public final native void applyMatrix(Object matrix)/*-{
this.applyMatrix(matrix);
}-*/;

public final native void computeBoundingBox()/*-{
this.computeBoundingBox();
}-*/;

public final native Object computeBoundingSphere()/*-{
return this.computeBoundingSphere();
}-*/;

public final native void computeVertexNormals()/*-{
this.computeVertexNormals();
}-*/;

public final native void normalizeNormals()/*-{
this.normalizeNormals();
}-*/;

public final native Object computeTangents()/*-{
return this.computeTangents();
}-*/;

public final native Object clone()/*-{
return this.clone();
}-*/;

public final native void dispose()/*-{
this.dispose();
}-*/;


}
