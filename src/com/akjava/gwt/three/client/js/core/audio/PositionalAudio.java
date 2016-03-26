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
package com.akjava.gwt.three.client.js.core.audio;

import com.google.gwt.core.client.JavaScriptObject;


public class PositionalAudio extends Audio{
	protected PositionalAudio() {
	}

public final native JavaScriptObject getPanner()/*-{
return this.panner;
}-*/;





public final native void setRefDistance(double value)/*-{
this.setRefDistance(value);
}-*/;

public final native double getRefDistance()/*-{
return this.getRefDistance();
}-*/;

public final native void setRolloffFactor(double value)/*-{
this.setRolloffFactor(value);
}-*/;

public final native double getRolloffFactor()/*-{
return this.getRolloffFactor();
}-*/;

public final native void setDistanceModel(JavaScriptObject value)/*-{
this.setDistanceModel(value);
}-*/;

public final native JavaScriptObject getDistanceModel()/*-{
return this.getDistanceModel();
}-*/;

public final native void setMaxDistance(double value)/*-{
this.setMaxDistance(value);
}-*/;

public final native double getMaxDistance()/*-{
return this.getMaxDistance();
}-*/;




}
