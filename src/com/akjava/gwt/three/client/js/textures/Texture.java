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
package com.akjava.gwt.three.client.js.textures;

import com.akjava.gwt.three.client.js.core.EventDispatcher;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.ImageElement;

public class Texture extends EventDispatcher{
protected Texture(){}

/**
 * @deprecated
 * @return
 */
public final native int getGWTImageWidth()/*-{
return this.image.width;
}-*/;


public final native int getId()/*-{
return this.id;
}-*/;




public final native String getUuid()/*-{
return this.uuid;
}-*/;




public final native String getName()/*-{
return this.name;
}-*/;

public final native void setName(String name)/*-{
this.name = name;
}-*/;


public final native ImageElement getImage()/*-{
return this.image;
}-*/;

//get image as array,it's possible
public final native JsArray<ImageElement> getGwtImages()/*-{
return this.image;
}-*/;

public final native void setImage(ImageElement image)/*-{
this.image = image;
}-*/;




public final native JsArray<JavaScriptObject> getMipmaps()/*-{
return this.mipmaps;
}-*/;

public final native void setMipmaps(JsArray<JavaScriptObject> mipmaps)/*-{
this.mipmaps = mipmaps;
}-*/;


public final native JavaScriptObject getMapping()/*-{
return this.mapping;
}-*/;

public final native void setMapping(JavaScriptObject mapping)/*-{
this.mapping = mapping;
}-*/;


public final native int getWrapS()/*-{
return this.wrapS;
}-*/;

public final native void setWrapS(int wrapS)/*-{
this.wrapS = wrapS;
}-*/;


public final native int getWrapT()/*-{
return this.wrapT;
}-*/;

public final native void setWrapT(int wrapT)/*-{
this.wrapT = wrapT;
}-*/;


public final native int getMagFilter()/*-{
return this.magFilter;
}-*/;

public final native void setMagFilter(int magFilter)/*-{
this.magFilter = magFilter;
}-*/;


public final native int getMinFilter()/*-{
return this.minFilter;
}-*/;

public final native void setMinFilter(int minFilter)/*-{
this.minFilter = minFilter;
}-*/;

/**
 * i'm not sure
 * @return
 */
public final native int getAnisotropy()/*-{
return this.anisotropy;
}-*/;

public final native void setAnisotropy(int anisotropy)/*-{
this.anisotropy = anisotropy;
}-*/;


public final native int getFormat()/*-{
return this.format;
}-*/;

public final native void setFormat(int format)/*-{
this.format = format;
}-*/;


public final native int getType()/*-{
return this.type;
}-*/;

public final native void setType(int type)/*-{
this.type = type;
}-*/;


public final native Vector2 getOffset()/*-{
return this.offset;
}-*/;

public final native void setOffset(Vector2 offset)/*-{
this.offset = offset;
}-*/;


public final native Vector2 getRepeat()/*-{
return this.repeat;
}-*/;

public final native void setRepeat(Vector2 repeat)/*-{
this.repeat = repeat;
}-*/;


public final native boolean isGenerateMipmaps()/*-{
return this.generateMipmaps;
}-*/;

public final native void setGenerateMipmaps(boolean generateMipmaps)/*-{
this.generateMipmaps = generateMipmaps;
}-*/;


public final native boolean isPremultiplyAlpha()/*-{
return this.premultiplyAlpha;
}-*/;

public final native void setPremultiplyAlpha(boolean premultiplyAlpha)/*-{
this.premultiplyAlpha = premultiplyAlpha;
}-*/;


public final native boolean isFlipY()/*-{
return this.flipY;
}-*/;

public final native void setFlipY(boolean flipY)/*-{
this.flipY = flipY;
}-*/;


public final native int getUnpackAlignment()/*-{
return this.unpackAlignment;
}-*/;

public final native void setUnpackAlignment(int unpackAlignment)/*-{
this.unpackAlignment = unpackAlignment;
}-*/;


public final native boolean isNeedsUpdate()/*-{
return this.needsUpdate;
}-*/;

public final native void setNeedsUpdate(boolean needsUpdate)/*-{
this.needsUpdate = needsUpdate;
}-*/;


public final native JavaScriptObject getOnUpdate()/*-{
return this.onUpdate;
}-*/;

public final native void setOnUpdate(JavaScriptObject onUpdate)/*-{
this.onUpdate = onUpdate;
}-*/;

public final native Texture copy(Texture texture)/*-{
return this.clone(texture);
}-*/;

public final native void dispose()/*-{
this.dispose();
}-*/;

public static final native Texture getDefaultImage()/*-{
return $wnd.THREE.Texture.DEFAULT_IMAGE;
}-*/;

public static final native JavaScriptObject getDefaultMapping()/*-{
return $wnd.THREE.Texture.DEFAULT_MAPPING;
}-*/;

public final native String getSourceFile()/*-{
return this.sourceFile;
}-*/;

public final native void setSourceFile(String sourceFile)/*-{
this.sourceFile = sourceFile;
}-*/;
}
