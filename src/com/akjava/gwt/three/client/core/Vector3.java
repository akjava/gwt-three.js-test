/*
 * gwt-wrap three.js
 * 
 * Copyright (c) 2011 aki@akjava.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 
 
 based Three.js r45
 https://github.com/mrdoob/three.js
 The MIT License

Copyright (c) 2010-2011 three.js Authors. All rights reserved.

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
package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public class Vector3 extends JavaScriptObject{
	protected Vector3(){};
public native final void set(double x,double y,double z)/*-{
this.set(x,y,z);
}-*/;

public native final void incrementX(double x)/*-{
this.x+=x;
}-*/;

public native final void incrementY(double y)/*-{
this.y+=y;
}-*/;

public native final void incrementZ(double z)/*-{
this.z+=z;
}-*/;


public native final double getX()/*-{
return this.x;
}-*/;
public native final double getY()/*-{
return this.y;
}-*/;
public native final double getZ()/*-{
return this.z;
}-*/;

public native final void setX(double x)/*-{
this.x=x;
}-*/;
public native final void setY(double y)/*-{
this.y=y;
}-*/;
public native final void setZ(double z)/*-{
this.z=z;
}-*/;




public native final Vector3 negate()/*-{
return this.negate();
}-*/;

public native final Vector3 addSelf(Vector3 vec3)/*-{
return this.addSelf(vec3);
}-*/;

public native final Vector3 subSelf(Vector3 vec3)/*-{
return this.subSelf(vec3);
}-*/;

public native final double dot(Vector3 vec3)/*-{
return this.dot(vec3);
}-*/;

public native final Vector3 clone()/*-{
return this.clone();
}-*/;



public native final Vector3 addScalar(double s)/*-{
return this.addScalar(s);
}-*/;
public native final Vector3 multiplyScalar(double s)/*-{
return this.multiplyScalar(s);
}-*/;


public native final Vector3 sub(Vector3 vec3,Vector3 vec3two)/*-{
return this.sub(vec3,vec3two);
}-*/;

public native final Vector3 cross(Vector3 vec3,Vector3 vec3two)/*-{
return this.cross(vec3,vec3two);
}-*/;

public native final Vector3 crossSelf(Vector3 vec3)/*-{
return this.crossSelf(vec3);
}-*/;

public native final Vector3 add(Vector3 vec3,Vector3 vec3two)/*-{
return this.add(vec3,vec3two);
}-*/;

public native final Vector3 normalize()/*-{
return this.normalize();
}-*/;

public native final void setRotationFromMatrix(Matrix4 matrix)/*-{
this.setRotationFromMatrix(matrix);
}-*/;
public native final void setPositionFromMatrix(Matrix4 matrix)/*-{
this.setPositionFromMatrix(matrix);
}-*/;

public native final double length()/*-{
return this.length();
}-*/;

public native final void divideSelf(Vector3 vec3)/*-{
this.divideSelf(vec3);
}-*/;

public native final void divideScalar(double scalar)/*-{
this.divideScalar(scalar);
}-*/;

}

