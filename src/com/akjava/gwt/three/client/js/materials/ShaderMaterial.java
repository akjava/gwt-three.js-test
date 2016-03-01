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
package com.akjava.gwt.three.client.js.materials;

import com.akjava.gwt.three.client.gwt.extras.Defines;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
import com.google.gwt.core.client.JavaScriptObject;


public class ShaderMaterial extends Material{
	protected ShaderMaterial() {
	}

public final native String getFragmentShader()/*-{
return this.fragmentShader;
}-*/;

public final native void setFragmentShader(String fragmentShader)/*-{
this.fragmentShader = fragmentShader;
}-*/;


public final native String getVertexShader()/*-{
return this.vertexShader;
}-*/;

public final native void setVertexShader(String vertexShader)/*-{
this.vertexShader = vertexShader;
}-*/;


public final native Uniforms getUniforms()/*-{
return this.uniforms;
}-*/;

public final native void setUniforms(Uniforms uniforms)/*-{
this.uniforms = uniforms;
}-*/;


public final native Defines getDefines()/*-{
return this.defines;
}-*/;

public final native void setDefines(Defines defines)/*-{
this.defines = defines;
}-*/;

/**
 * i have no idea what is this.
 * @return
 */
public final native JavaScriptObject getAttributes()/*-{
return this.attributes;
}-*/;

public final native void setAttributes(JavaScriptObject attributes)/*-{
this.attributes = attributes;
}-*/;


public final native int getShading()/*-{
return this.shading;
}-*/;

public final native void setShading(int shading)/*-{
this.shading = shading;
}-*/;


public final native double getLinewidth()/*-{
return this.linewidth;
}-*/;

public final native void setLinewidth(double linewidth)/*-{
this.linewidth = linewidth;
}-*/;


public final native boolean isWireframe()/*-{
return this.wireframe;
}-*/;

public final native void setWireframe(boolean wireframe)/*-{
this.wireframe = wireframe;
}-*/;


public final native double getWireframeLinewidth()/*-{
return this.wireframeLinewidth;
}-*/;

public final native void setWireframeLinewidth(double wireframeLinewidth)/*-{
this.wireframeLinewidth = wireframeLinewidth;
}-*/;


public final native boolean isFog()/*-{
return this.fog;
}-*/;

public final native void setFog(boolean fog)/*-{
this.fog = fog;
}-*/;


public final native boolean isLights()/*-{
return this.lights;
}-*/;

public final native void setLights(boolean lights)/*-{
this.lights = lights;
}-*/;


public final native int getVertexColors()/*-{
return this.vertexColors;
}-*/;

public final native void setVertexColors(int vertexColors)/*-{
this.vertexColors = vertexColors;
}-*/;


public final native boolean isSkinning()/*-{
return this.skinning;
}-*/;

public final native void setSkinning(boolean skinning)/*-{
this.skinning = skinning;
}-*/;


public final native boolean isMorphTargets()/*-{
return this.morphTargets;
}-*/;

public final native void setMorphTargets(boolean morphTargets)/*-{
this.morphTargets = morphTargets;
}-*/;


public final native boolean isMorphNormals()/*-{
return this.morphNormals;
}-*/;

public final native void setMorphNormals(boolean morphNormals)/*-{
this.morphNormals = morphNormals;
}-*/;

/**
 * i don't know when it's used
 * @return
 */
public final native JavaScriptObject getDefaultAttributeValues()/*-{
return this.defaultAttributeValues;
}-*/;

public final native void setDefaultAttributeValues(JavaScriptObject defaultAttributeValues)/*-{
this.defaultAttributeValues = defaultAttributeValues;
}-*/;


public final native String getIndex0AttributeName()/*-{
return this.index0AttributeName;
}-*/;

public final native void setIndex0AttributeName(String index0AttributeName)/*-{
this.index0AttributeName = index0AttributeName;
}-*/;


public final native ShaderMaterial copy(ShaderMaterial source)/*-{
return this.copy(source);
}-*/;
}
