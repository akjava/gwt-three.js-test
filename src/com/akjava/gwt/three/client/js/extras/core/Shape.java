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
package com.akjava.gwt.three.client.js.extras.core;

import com.akjava.gwt.three.client.gwt.math.XYZObject;
import com.akjava.gwt.three.client.js.extras.geometries.ExtrudeGeometry;
import com.akjava.gwt.three.client.js.extras.geometries.ShapeGeometry;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/*
 * has hole
 */
public class Shape extends Path{
	protected Shape() {
	}

public final native JsArray<Path> getHoles()/*-{
return this.holes;
}-*/;

public final native void setHoles(JsArray<Path> holes)/*-{
this.holes = holes;
}-*/;

public final native ExtrudeGeometry extrude(JavaScriptObject options)/*-{
return this.extrude(options);
}-*/;
public final native ShapeGeometry makeGeometry(JavaScriptObject options)/*-{
return this.makeGeometry(options);
}-*/;

/**
 * each hole's points.
 * @param divisions
 * @return
 */

public final native JsArray<JsArray<Vector2>> getPointsHoles(int divisions)/*-{
return this.getPointsHoles(divisions);
}-*/;
/**
 * @deprecated seems gone
 * @param divisions
 * @return
 */
public final native JsArray<JsArray<XYZObject>> getSpacedPointsHoles(int divisions)/*-{
return this.getSpacedPointsHoles(divisions);
}-*/;

/**
 * 

 * 
 * @param divisions
 * @return
{
shape: this.getPoints( divisions ),
holes: this.getPointsHoles( divisions )
 }
 */
public final native JavaScriptObject extractAllPoints(int divisions)/*-{
return this.extractAllPoints(divisions);
}-*/;

/**
 * 

 * 
 * @param divisions
 * @return
{
shape: this.getPoints( divisions ),
holes: this.getPointsHoles( divisions )
 }
 */
public final native JavaScriptObject extractPoints(int divisions)/*-{
return this.extractPoints(divisions);
}-*/;


/**
 * @deprecated seems gone
 * @param divisions
 * @return
 */
public final native JavaScriptObject extractAllSpacedPoints(int divisions)/*-{
return this.extractAllSpacedPoints(divisions);
}-*/;



}
