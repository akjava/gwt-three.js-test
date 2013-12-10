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
package com.akjava.gwt.three.client.materials;

import com.akjava.gwt.three.client.math.Color;
import com.akjava.gwt.three.client.math.Vector2;
import com.akjava.gwt.three.client.textures.Texture;


public class SpriteMaterial extends Material{
	protected SpriteMaterial() {
	}

public final native Color getColor()/*-{
return this.color;
}-*/;

public final native void setColor(Color color)/*-{
this.color = color;
}-*/;


public final native Texture getMap()/*-{
return this.map;
}-*/;

public final native void setMap(Texture map)/*-{
this.map = map;
}-*/;


public final native double getRotation()/*-{
return this.rotation;
}-*/;

public final native void setRotation(double rotation)/*-{
this.rotation = rotation;
}-*/;


public final native boolean isFog()/*-{
return this.fog;
}-*/;

public final native void setFog(boolean fog)/*-{
this.fog = fog;
}-*/;


public final native Vector2 getUvOffset()/*-{
return this.uvOffset;
}-*/;

public final native void setUvOffset(Vector2 uvOffset)/*-{
this.uvOffset = uvOffset;
}-*/;


public final native Vector2 getUvScale()/*-{
return this.uvScale;
}-*/;

public final native void setUvScale(Vector2 uvScale)/*-{
this.uvScale = uvScale;
}-*/;

public final native SpriteMaterial clone()/*-{
return this.clone();
}-*/;


}
