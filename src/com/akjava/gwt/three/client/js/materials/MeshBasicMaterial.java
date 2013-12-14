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

import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.textures.Texture;


public class MeshBasicMaterial extends Material{
	protected MeshBasicMaterial() {
	}

	public final native void setColor(Color c)/*-{
	this.color=c;
	}-*/;

	public final native Color getColor()/*-{
	return this.color;
	}-*/;

public final native Texture getMap()/*-{
return this.map;
}-*/;

public final native void setMap(Texture map)/*-{
this.map = map;
}-*/;


public final native Texture getLightMap()/*-{
return this.lightMap;
}-*/;

public final native void setLightMap(Texture lightMap)/*-{
this.lightMap = lightMap;
}-*/;


public final native Texture getSpecularMap()/*-{
return this.specularMap;
}-*/;

public final native void setSpecularMap(Texture specularMap)/*-{
this.specularMap = specularMap;
}-*/;


public final native Texture getEnvMap()/*-{
return this.envMap;
}-*/;

public final native void setEnvMap(Texture envMap)/*-{
this.envMap = envMap;
}-*/;


public final native int getCombine()/*-{
return this.combine;
}-*/;

public final native void setCombine(int combine)/*-{
this.combine = combine;
}-*/;


public final native double getReflectivity()/*-{
return this.reflectivity;
}-*/;

public final native void setReflectivity(double reflectivity)/*-{
this.reflectivity = reflectivity;
}-*/;


public final native double getRefractionRatio()/*-{
return this.refractionRatio;
}-*/;

public final native void setRefractionRatio(double refractionRatio)/*-{
this.refractionRatio = refractionRatio;
}-*/;


public final native boolean isFog()/*-{
return this.fog;
}-*/;

public final native void setFog(boolean fog)/*-{
this.fog = fog;
}-*/;


public final native int getShading()/*-{
return this.shading;
}-*/;

public final native void setShading(int shading)/*-{
this.shading = shading;
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


public final native String getWireframeLinecap()/*-{
return this.wireframeLinecap;
}-*/;

public final native void setWireframeLinecap(String wireframeLinecap)/*-{
this.wireframeLinecap = wireframeLinecap;
}-*/;


public final native String getWireframeLinejoin()/*-{
return this.wireframeLinejoin;
}-*/;

public final native void setWireframeLinejoin(String wireframeLinejoin)/*-{
this.wireframeLinejoin = wireframeLinejoin;
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

public final native MeshBasicMaterial clone()/*-{
return this.clone();
}-*/;


}
