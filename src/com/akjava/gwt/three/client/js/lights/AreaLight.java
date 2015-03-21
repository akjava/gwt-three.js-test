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

import com.akjava.gwt.three.client.js.math.Vector3;


public class AreaLight extends Light{
	protected AreaLight() {
	}

public final native Vector3 getNormal()/*-{
return this.normal;
}-*/;

public final native void setNormal(Vector3 normal)/*-{
this.normal = normal;
}-*/;


public final native Vector3 getRight()/*-{
return this.right;
}-*/;

public final native void setRight(Vector3 right)/*-{
this.right = right;
}-*/;


public final native double getIntensity()/*-{
return this.intensity;
}-*/;

public final native void setIntensity(double intensity)/*-{
this.intensity = intensity;
}-*/;


public final native double getWidth()/*-{
return this.width;
}-*/;

public final native void setWidth(double width)/*-{
this.width = width;
}-*/;


public final native double getHeight()/*-{
return this.height;
}-*/;

public final native void setHeight(double height)/*-{
this.height = height;
}-*/;


public final native double getConstantAttenuation()/*-{
return this.constantAttenuation;
}-*/;

public final native void setConstantAttenuation(double constantAttenuation)/*-{
this.constantAttenuation = constantAttenuation;
}-*/;


public final native double getLinearAttenuation()/*-{
return this.linearAttenuation;
}-*/;

public final native void setLinearAttenuation(double linearAttenuation)/*-{
this.linearAttenuation = linearAttenuation;
}-*/;


public final native double getQuadraticAttenuation()/*-{
return this.quadraticAttenuation;
}-*/;

public final native void setQuadraticAttenuation(double quadraticAttenuation)/*-{
this.quadraticAttenuation = quadraticAttenuation;
}-*/;



}
