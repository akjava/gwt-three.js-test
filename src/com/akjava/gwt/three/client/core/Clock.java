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
package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;


public class Clock extends JavaScriptObject{
	protected Clock() {
	}

public final native Object getAutoStart()/*-{
return this.autoStart;
}-*/;

public final native void setAutoStart(Object autoStart)/*-{
this.autoStart = autoStart;
}-*/;


public final native double getStartTime()/*-{
return this.startTime;
}-*/;

public final native void setStartTime(double startTime)/*-{
this.startTime = startTime;
}-*/;


public final native double getOldTime()/*-{
return this.oldTime;
}-*/;

public final native void setOldTime(double oldTime)/*-{
this.oldTime = oldTime;
}-*/;


public final native double getElapsedTime()/*-{
return this.elapsedTime;
}-*/;

public final native void setElapsedTime(double elapsedTime)/*-{
this.elapsedTime = elapsedTime;
}-*/;


public final native boolean isRunning()/*-{
return this.running;
}-*/;

public final native void setRunning(boolean running)/*-{
this.running = running;
}-*/;

public final native void start()/*-{
this.start();
}-*/;

public final native void stop()/*-{
this.stop();
}-*/;



public final native Object getDelta()/*-{
return this.getDelta();
}-*/;










}
