/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2013-2015 akimisaki3@gmail.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r69
 https://github.com/mrdoob/three.js

The MIT License

Copyright &copy; 2010-2014 three.js authors

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

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.core.EventDispatcher;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;


public class OrbitControls extends EventDispatcher{
	protected OrbitControls() {
	}



	public final  native Object3D getObject()/*-{
	return this.object;
	}-*/;
	public final  native void setObject(Object3D  param)/*-{
	this.object=param;
	}-*/;

	public final  native Element getDomElement()/*-{
	return this.domElement;
	}-*/;
	public final  native void setDomElement(Element  param)/*-{
	this.domElement=param;
	}-*/;
	

	public final  native boolean isEnabled()/*-{
	return this.enabled;
	}-*/;
	public final  native void setEnabled(boolean  param)/*-{
	this.enabled=param;
	}-*/;


	public final  native Vector3 getTarget()/*-{
	return this.target;
	}-*/;
	public final  native void setTarget(Vector3  param)/*-{
	this.target=param;
	}-*/;
	
	
	public final  native Vector3 getCenter()/*-{
	return this.center;
	}-*/;
	public final  native void setCenter(Vector3  param)/*-{
	this.center=param;
	}-*/;
	
	


	public final  native boolean isNoZoom()/*-{
	return this.noZoom;
	}-*/;
	public final  native void setNoZoom(boolean  param)/*-{
	this.noZoom=param;
	}-*/;


	public final  native double getZoomSpeed()/*-{
	return this.zoomSpeed;
	}-*/;
	public final  native void setZoomSpeed(double  param)/*-{
	this.zoomSpeed=param;
	}-*/;


	public final  native double getMinDistance()/*-{
	return this.minDistance;
	}-*/;
	public final  native void setMinDistance(double  param)/*-{
	this.minDistance=param;
	}-*/;


	public final  native double getMaxDistance()/*-{
	return this.maxDistance;
	}-*/;
	public final  native void setMaxDistance(double  param)/*-{
	this.maxDistance=param;
	}-*/;

	public final  native void dispose()/*-{
	this.dispose();
	}-*/;
	
	public final  native boolean isNoRotate()/*-{
	return this.noRotate;
	}-*/;
	public final  native void setNoRotate(boolean  param)/*-{
	this.noRotate=param;
	}-*/;


	public final  native double getRotateSpeed()/*-{
	return this.rotateSpeed;
	}-*/;
	public final  native void setRotateSpeed(double  param)/*-{
	this.rotateSpeed=param;
	}-*/;


	public final  native boolean isNoPan()/*-{
	return this.noPan;
	}-*/;
	public final  native void setNoPan(boolean  param)/*-{
	this.noPan=param;
	}-*/;


	public final  native double getKeyPanSpeed()/*-{
	return this.keyPanSpeed;
	}-*/;
	public final  native void setKeyPanSpeed(double  param)/*-{
	this.keyPanSpeed=param;
	}-*/;


	public final  native boolean isAutoRotate()/*-{
	return this.autoRotate;
	}-*/;
	public final  native void setAutoRotate(boolean  param)/*-{
	this.autoRotate=param;
	}-*/;


	public final  native double getAutoRotateSpeed()/*-{
	return this.autoRotateSpeed;
	}-*/;
	public final  native void setAutoRotateSpeed(double  param)/*-{
	this.autoRotateSpeed=param;
	}-*/;


	public final  native double getMinPolarAngle()/*-{
	return this.minPolarAngle;
	}-*/;
	public final  native void setMinPolarAngle(double  param)/*-{
	this.minPolarAngle=param;
	}-*/;


	public final  native double getMaxPolarAngle()/*-{
	return this.maxPolarAngle;
	}-*/;
	public final  native void setMaxPolarAngle(double  param)/*-{
	this.maxPolarAngle=param;
	}-*/;


	public final  native double getMinAzimuthAngle()/*-{
	return this.minAzimuthAngle;
	}-*/;
	public final  native void setMinAzimuthAngle(double  param)/*-{
	this.minAzimuthAngle=param;
	}-*/;


	public final  native double getMaxAzimuthAngle()/*-{
	return this.maxAzimuthAngle;
	}-*/;
	public final  native void setMaxAzimuthAngle(double  param)/*-{
	this.maxAzimuthAngle=param;
	}-*/;


	public final  native boolean isNoKeys()/*-{
	return this.noKeys;
	}-*/;
	public final  native void setNoKeys(boolean  param)/*-{
	this.noKeys=param;
	}-*/;


	//TODO { LEFT: 37, UP: 38, RIGHT: 39, BOTTOM: 40 };
	public final  native JavaScriptObject getKeys()/*-{
	return this.keys;
	}-*/;
	
	public final  native void setKeys(JavaScriptObject  param)/*-{
	this.keys=param;
	}-*/;


	//TODO { ORBIT: THREE.MOUSE.LEFT, ZOOM: THREE.MOUSE.MIDDLE, PAN: THREE.MOUSE.RIGHT };
	public final  native JSParameter getMouseButtons()/*-{
	return this.mouseButtons;
	}-*/;
	public final  native void setMouseButtons(JavaScriptObject  param)/*-{
	this.mouseButtons=param;
	}-*/;

	
	

public  final native void update()/*-{
this.update();
}-*/;

public  final native void reset()/*-{
this.reset();
}-*/;

public  final native double getPolarAngle()/*-{
return this.getPolarAngle();
}-*/;

public  final native double getAzimuthalAngle()/*-{
return this.getAzimuthalAngle();
}-*/;


public  final native double getAutoRotationAngle()/*-{
return this.getAutoRotationAngle();
}-*/;

public  final native double getZoomScale()/*-{
return this.getZoomScale();
}-*/;




}
