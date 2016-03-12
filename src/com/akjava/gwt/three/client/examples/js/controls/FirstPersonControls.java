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
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class FirstPersonControls extends JavaScriptObject{
	protected FirstPersonControls() {
	}

public final native Object3D getObject()/*-{
return this.object;
}-*/;

public final native void setObject(Object3D object)/*-{
this.object = object;
}-*/;


public final native Vector3 getTarget()/*-{
return this.target;
}-*/;

public final native void setTarget(Vector3 target)/*-{
this.target = target;
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


public final native double getMovementSpeed()/*-{
return this.movementSpeed;
}-*/;

public final native void setMovementSpeed(double movementSpeed)/*-{
this.movementSpeed = movementSpeed;
}-*/;


public final native double getLookSpeed()/*-{
return this.lookSpeed;
}-*/;

public final native void setLookSpeed(double lookSpeed)/*-{
this.lookSpeed = lookSpeed;
}-*/;


public final native boolean isLookVertical()/*-{
return this.lookVertical;
}-*/;

public final native void setLookVertical(boolean lookVertical)/*-{
this.lookVertical = lookVertical;
}-*/;


public final native boolean isAutoForward()/*-{
return this.autoForward;
}-*/;

public final native void setAutoForward(boolean autoForward)/*-{
this.autoForward = autoForward;
}-*/;


public final native boolean isActiveLook()/*-{
return this.activeLook;
}-*/;

public final native void setActiveLook(boolean activeLook)/*-{
this.activeLook = activeLook;
}-*/;


public final native boolean isHeightSpeed()/*-{
return this.heightSpeed;
}-*/;

public final native void setHeightSpeed(boolean heightSpeed)/*-{
this.heightSpeed = heightSpeed;
}-*/;


public final native double getHeightCoef()/*-{
return this.heightCoef;
}-*/;

public final native void setHeightCoef(double heightCoef)/*-{
this.heightCoef = heightCoef;
}-*/;


public final native Object getHeightMin()/*-{
return this.heightMin;
}-*/;

public final native void setHeightMin(Object heightMin)/*-{
this.heightMin = heightMin;
}-*/;


public final native double getHeightMax()/*-{
return this.heightMax;
}-*/;

public final native void setHeightMax(double heightMax)/*-{
this.heightMax = heightMax;
}-*/;


public final native boolean isConstrainVertical()/*-{
return this.constrainVertical;
}-*/;

public final native void setConstrainVertical(boolean constrainVertical)/*-{
this.constrainVertical = constrainVertical;
}-*/;


public final native double getVerticalMin()/*-{
return this.verticalMin;
}-*/;

public final native void setVerticalMin(double verticalMin)/*-{
this.verticalMin = verticalMin;
}-*/;


public final native Object getVerticalMax()/*-{
return this.verticalMax;
}-*/;

public final native void setVerticalMax(Object verticalMax)/*-{
this.verticalMax = verticalMax;
}-*/;


public final native Object getAutoSpeedFactor()/*-{
return this.autoSpeedFactor;
}-*/;

public final native void setAutoSpeedFactor(Object autoSpeedFactor)/*-{
this.autoSpeedFactor = autoSpeedFactor;
}-*/;


public final native double getMouseX()/*-{
return this.mouseX;
}-*/;

public final native void setMouseX(double mouseX)/*-{
this.mouseX = mouseX;
}-*/;


public final native double getMouseY()/*-{
return this.mouseY;
}-*/;

public final native void setMouseY(double mouseY)/*-{
this.mouseY = mouseY;
}-*/;


public final native double getLat()/*-{
return this.lat;
}-*/;

public final native void setLat(double lat)/*-{
this.lat = lat;
}-*/;


public final native double getLon()/*-{
return this.lon;
}-*/;

public final native void setLon(double lon)/*-{
this.lon = lon;
}-*/;


public final native double getPhi()/*-{
return this.phi;
}-*/;

public final native void setPhi(double phi)/*-{
this.phi = phi;
}-*/;


public final native double getTheta()/*-{
return this.theta;
}-*/;

public final native void setTheta(double theta)/*-{
this.theta = theta;
}-*/;


public final native boolean isMoveForward()/*-{
return this.moveForward;
}-*/;

public final native void setMoveForward(boolean moveForward)/*-{
this.moveForward = moveForward;
}-*/;


public final native boolean isMoveBackward()/*-{
return this.moveBackward;
}-*/;

public final native void setMoveBackward(boolean moveBackward)/*-{
this.moveBackward = moveBackward;
}-*/;


public final native boolean isMoveLeft()/*-{
return this.moveLeft;
}-*/;

public final native void setMoveLeft(boolean moveLeft)/*-{
this.moveLeft = moveLeft;
}-*/;


public final native boolean isMoveRight()/*-{
return this.moveRight;
}-*/;

public final native void setMoveRight(boolean moveRight)/*-{
this.moveRight = moveRight;
}-*/;


public final native boolean isMouseDragOn()/*-{
return this.mouseDragOn;
}-*/;

public final native void setMouseDragOn(boolean mouseDragOn)/*-{
this.mouseDragOn = mouseDragOn;
}-*/;


public final native double getViewHalfX()/*-{
return this.viewHalfX;
}-*/;

public final native void setViewHalfX(double viewHalfX)/*-{
this.viewHalfX = viewHalfX;
}-*/;


public final native double getViewHalfY()/*-{
return this.viewHalfY;
}-*/;

public final native void setViewHalfY(double viewHalfY)/*-{
this.viewHalfY = viewHalfY;
}-*/;

public final native void handleResize()/*-{
this.handleResize();
}-*/;

public final native void update(double delta)/*-{
this.update(delta);
}-*/;

public final native void dispose()/*-{
this.dispose();
}-*/;


}
