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
package com.akjava.gwt.three.client.js.extras.cameras;

import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.cameras.OrthographicCamera;
import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;


public class CombinedCamera extends Camera{
	protected CombinedCamera() {
	}

public final native double getFov()/*-{
return this.fov;
}-*/;




public final native double getLeft()/*-{
return this.left;
}-*/;

public final native void setLeft(double left)/*-{
this.left = left;
}-*/;


public final native double getRight()/*-{
return this.right;
}-*/;

public final native void setRight(double right)/*-{
this.right = right;
}-*/;


public final native double getTop()/*-{
return this.top;
}-*/;

public final native void setTop(double top)/*-{
this.top = top;
}-*/;


public final native double getBottom()/*-{
return this.bottom;
}-*/;

public final native void setBottom(double bottom)/*-{
this.bottom = bottom;
}-*/;


public final native OrthographicCamera getCameraO()/*-{
return this.cameraO;
}-*/;




public final native PerspectiveCamera getCameraP()/*-{
return this.cameraP;
}-*/;




public final native double getZoom()/*-{
return this.zoom;
}-*/;



public final native void toPerspective()/*-{
this.toPerspective();
}-*/;

public final native void toOrthographic()/*-{
this.toOrthographic();
}-*/;

public final native void setSize(double width,double height)/*-{
this.setSize(width,height);
}-*/;

public final native void setFov(Object fov)/*-{
this.setFov(fov);
}-*/;

public final native void updateProjectionMatrix()/*-{
this.updateProjectionMatrix();
}-*/;

public final native double setLens(double focalLength,double frameHeight)/*-{
return this.setLens(focalLength,frameHeight);
}-*/;

public final native void setZoom(double zoom)/*-{
this.setZoom(zoom);
}-*/;

public final native void toFrontView()/*-{
this.toFrontView();
}-*/;

public final native void toBackView()/*-{
this.toBackView();
}-*/;

public final native void toLeftView()/*-{
this.toLeftView();
}-*/;

public final native void toRightView()/*-{
this.toRightView();
}-*/;

public final native void toTopView()/*-{
this.toTopView();
}-*/;

public final native void toBottomView()/*-{
this.toBottomView();
}-*/;


}
