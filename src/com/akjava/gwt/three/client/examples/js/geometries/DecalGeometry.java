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
package com.akjava.gwt.three.client.examples.js.geometries;

import com.akjava.gwt.three.client.examples.gwt.geometries.DecalVertex;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Matrix4;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;


public class DecalGeometry extends Geometry{
	protected DecalGeometry() {
	}



public final native JsArray<JavaScriptObject> getUvs()/*-{
return this.uvs;
}-*/;

public final native void setUvs(JsArray<JavaScriptObject> uvs)/*-{
this.uvs = uvs;
}-*/;


public final native Mesh getCube()/*-{
return this.cube;
}-*/;

public final native void setCube(Mesh cube)/*-{
this.cube = cube;
}-*/;


public final native Matrix4 getICubeMatrix()/*-{
return this.iCubeMatrix;
}-*/;

public final native void setICubeMatrix(Matrix4 iCubeMatrix)/*-{
this.iCubeMatrix = iCubeMatrix;
}-*/;


public final native JsArrayString getFaceIndices()/*-{
return this.faceIndices;
}-*/;

public final native void setFaceIndices(JsArrayString faceIndices)/*-{
this.faceIndices = faceIndices;
}-*/;

public final native JsArray<DecalVertex> clipFace(JsArray<DecalVertex> inVertices,Vector3 plane)/*-{
return this.clipFace(inVertices,plane);
}-*/;

public final native void pushVertex(JsArray<DecalVertex> vertices,int id,Vector3 n)/*-{
this.pushVertex(vertices,id,n);
}-*/;

public final native void computeDecal()/*-{
this.computeDecal();
}-*/;


}
