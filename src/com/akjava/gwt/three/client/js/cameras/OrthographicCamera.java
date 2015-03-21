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
package com.akjava.gwt.three.client.js.cameras;



public class OrthographicCamera extends Camera{
	protected OrthographicCamera() {
	}

public final native Number getLeft()/*-{
return this.left;
}-*/;

public final native void setLeft(Number left)/*-{
this.left = left;
}-*/;


public final native Number getRight()/*-{
return this.right;
}-*/;

public final native void setRight(Number right)/*-{
this.right = right;
}-*/;


public final native Number getTop()/*-{
return this.top;
}-*/;

public final native void setTop(Number top)/*-{
this.top = top;
}-*/;


public final native Number getBottom()/*-{
return this.bottom;
}-*/;

public final native void setBottom(Number bottom)/*-{
this.bottom = bottom;
}-*/;


public final native Number getNear()/*-{
return this.near;
}-*/;

public final native void setNear(Number near)/*-{
this.near = near;
}-*/;


public final native Number getFar()/*-{
return this.far;
}-*/;

public final native void setFar(Object far)/*-{
this.far = far;
}-*/;

public final native void updateProjectionMatrix()/*-{
this.updateProjectionMatrix();
}-*/;

public final native OrthographicCamera clone()/*-{
return this.clone();
}-*/;

public final native double getZoom()/*-{
return this.zoom;
}-*/;

}
