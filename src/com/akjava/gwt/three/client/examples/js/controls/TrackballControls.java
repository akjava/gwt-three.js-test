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
package com.akjava.gwt.three.client.examples.js.controls;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.math.Quaternion;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;


public class TrackballControls extends JavaScriptObject{
	protected TrackballControls() {
	}

public final native Object3D getObject()/*-{
return this.object;
}-*/;

public final native void setObject(Object3D object)/*-{
this.object = object;
}-*/;


public final native Element getDomElement()/*-{
return this.domElement;
}-*/;

public final native void setDomElement(Element domElement)/*-{
this.domElement = domElement;
}-*/;


public final native boolean isEnabled()/*-{
return this.enabled;
}-*/;

public final native void setEnabled(boolean enabled)/*-{
this.enabled = enabled;
}-*/;


public final native JavaScriptObject getScreen()/*-{
return this.screen;
}-*/;

public final native void setScreen(JavaScriptObject screen)/*-{
this.screen = screen;
}-*/;


public final native double getRotateSpeed()/*-{
return this.rotateSpeed;
}-*/;

public final native void setRotateSpeed(double rotateSpeed)/*-{
this.rotateSpeed = rotateSpeed;
}-*/;


public final native double getZoomSpeed()/*-{
return this.zoomSpeed;
}-*/;

public final native void setZoomSpeed(double zoomSpeed)/*-{
this.zoomSpeed = zoomSpeed;
}-*/;


public final native double getPanSpeed()/*-{
return this.panSpeed;
}-*/;

public final native void setPanSpeed(double panSpeed)/*-{
this.panSpeed = panSpeed;
}-*/;


public final native boolean isNoRotate()/*-{
return this.noRotate;
}-*/;

public final native void setNoRotate(boolean noRotate)/*-{
this.noRotate = noRotate;
}-*/;


public final native boolean isNoZoom()/*-{
return this.noZoom;
}-*/;

public final native void setNoZoom(boolean noZoom)/*-{
this.noZoom = noZoom;
}-*/;


public final native boolean isNoPan()/*-{
return this.noPan;
}-*/;

public final native void setNoPan(boolean noPan)/*-{
this.noPan = noPan;
}-*/;


public final native boolean isStaticMoving()/*-{
return this.staticMoving;
}-*/;

public final native void setStaticMoving(boolean staticMoving)/*-{
this.staticMoving = staticMoving;
}-*/;


public final native double getDynamicDampingFactor()/*-{
return this.dynamicDampingFactor;
}-*/;

public final native void setDynamicDampingFactor(double dynamicDampingFactor)/*-{
this.dynamicDampingFactor = dynamicDampingFactor;
}-*/;


public final native double getMinDistance()/*-{
return this.minDistance;
}-*/;

public final native void setMinDistance(double minDistance)/*-{
this.minDistance = minDistance;
}-*/;


public final native double getMaxDistance()/*-{
return this.maxDistance;
}-*/;

public final native void setMaxDistance(double maxDistance)/*-{
this.maxDistance = maxDistance;
}-*/;


public final native JsArrayNumber getKeys()/*-{
return this.keys;
}-*/;

public final native void setKeys(JsArrayNumber keys)/*-{
this.keys = keys;
}-*/;


public final native Vector3 getTarget()/*-{
return this.target;
}-*/;

public final native void setTarget(Vector3 target)/*-{
this.target = target;
}-*/;



public final native void handleResize()/*-{
this.handleResize();
}-*/;

public final native void handleEvent(NativeEvent event)/*-{
this.handleEvent(event);
}-*/;

public final native void rotateCamera()/*-{
this.rotateCamera();
}-*/;

public final native void zoomCamera()/*-{
this.zoomCamera();
}-*/;

public final native void panCamera()/*-{
 this.panCamera();
}-*/;

public final native void checkDistances()/*-{
this.checkDistances();
}-*/;

public final native void update()/*-{
this.update();
}-*/;

public final native void reset()/*-{
 this.reset();
}-*/;

public final native void dispose()/*-{
this.dispose();
}-*/;


}
