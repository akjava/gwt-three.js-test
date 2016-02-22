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

import com.akjava.gwt.three.client.gwt.core.Offset;
import com.akjava.gwt.three.client.js.math.Box3;
import com.akjava.gwt.three.client.js.math.Sphere;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
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




public final native JavaScriptObject getAttributes()/*-{
return this.attributes;
}-*/;

public final native void setAttributes(JavaScriptObject attributes)/*-{
this.attributes = attributes;
}-*/;


//TODO support settings
public final native BufferGeometry fromGeometry(Geometry geometry, JavaScriptObject settings)/*-{
return this.fromGeometry(geometry,settings);
}-*/;



public final native JsArray<Offset> getOffsets()/*-{
return this.offsets;
}-*/;

public final native void setOffsets(JsArray<Offset> offsets)/*-{
this.offsets = offsets;
}-*/;


public final native Box3 getBoundingBox()/*-{
return this.boundingBox;
}-*/;

public final native void setBoundingBox(Box3 boundingBox)/*-{
this.boundingBox = boundingBox;
}-*/;


public final native Sphere getBoundingSphere()/*-{
return this.boundingSphere;
}-*/;

public final native void setBoundingSphere(Sphere boundingSphere)/*-{
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

/**
 * @deprecated
 * it's gone
 */
public final native void addAttribute(Object name,Object type,Object numItems,Object itemSize)/*-{
this.addAttribute(name,type,numItems,itemSize);
}-*/;

public final native void addDrawCall(int start,int count,int indexOffset)/*-{
this.addDrawCall(start,count,indexOffset);
}-*/;


public final native void addAttribute(String name,BufferAttribute attribute)/*-{
this.addAttribute(name,attribute);
}-*/;

public final native BufferAttribute getAttribute(String name)/*-{
return this.getAttribute(name);
}-*/;

public final native void applyMatrix(Object matrix)/*-{
this.applyMatrix(matrix);
}-*/;

public final native void computeBoundingBox()/*-{
this.computeBoundingBox();
}-*/;

public final native Sphere computeBoundingSphere()/*-{
return this.computeBoundingSphere();
}-*/;

public final native void computeVertexNormals()/*-{
this.computeVertexNormals();
}-*/;

public final native void normalizeNormals()/*-{
this.normalizeNormals();
}-*/;

public final native void computeTangents()/*-{
 this.computeTangents();
}-*/;

public final native BufferGeometry clone()/*-{
return this.clone();
}-*/;

public final native Vector3 center()/*-{
return this.center();
}-*/;

public final native void dispose()/*-{
this.dispose();
}-*/;

public  native final BufferGeometry merge(BufferGeometry geo,int offset)/*-{
return this.merge(geo,offset);
}-*/;

}
