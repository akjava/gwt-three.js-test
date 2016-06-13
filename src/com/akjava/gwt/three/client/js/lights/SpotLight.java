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
package com.akjava.gwt.three.client.js.lights;

import com.akjava.gwt.three.client.js.cameras.PerspectiveCamera;
import com.akjava.gwt.three.client.js.core.Object3D;


public class SpotLight extends Light{
	protected SpotLight() {
	}

public final native Object3D getTarget()/*-{
return this.target;
}-*/;

public final native void setTarget(Object3D target)/*-{
this.target = target;
}-*/;





public final native double getDistance()/*-{
return this.distance;
}-*/;

public final native void setDistance(double distance)/*-{
this.distance = distance;
}-*/;


public final native double getAngle()/*-{
return this.angle;
}-*/;

public final native void setAngle(double angle)/*-{
this.angle = angle;
}-*/;


public final  native double getPenumbra()/*-{
return this.penumbra;
}-*/;

public final  native void setPenumbra(double  param)/*-{
this.penumbra=param;
}-*/;


public final native double getDecay()/*-{
return this.decay;
}-*/;

public final native void setDecay(double decay)/*-{
this.decay = decay;
}-*/;

public final native SpotLight copy(SpotLight source)/*-{
return this.copy(source);
}-*/;

public final native LightShadow getShadow()/*-{
return this.shadow;
}-*/;

public final native void setShadow(LightShadow shadow)/*-{
this.shadow = shadow;
}-*/;

public final native PerspectiveCamera gwtGetShadowCamera()/*-{
return this.shadow.camera;
}-*/;
}
