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
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;


public class MeshPhongMaterial extends Material{
	protected MeshPhongMaterial() {
	}

public final native Color getColor()/*-{
return this.color;
}-*/;

public final native void setColor(Color color)/*-{
this.color = color;
}-*/;

/**
 * @deprecated on r71
 * @return
 */
public final native Color getAmbient()/*-{
return this.ambient;
}-*/;

/**
 * @deprecated on r71
 * @return
 */
public final native void setAmbient(Color ambient)/*-{
this.ambient = ambient;
}-*/;


public final native Color getEmissive()/*-{
return this.emissive;
}-*/;

public final native void setEmissive(Color emissive)/*-{
this.emissive = emissive;
}-*/;


public final native Color getSpecular()/*-{
return this.specular;
}-*/;

public final native void setSpecular(Color specular)/*-{
this.specular = specular;
}-*/;


public final native double getShininess()/*-{
return this.shininess;
}-*/;

public final native void setShininess(double shininess)/*-{
this.shininess = shininess;
}-*/;


/**
 * @deprecated on r74
 * @return
 */
public final native boolean isMetal()/*-{
return this.metal;
}-*/;
/**
 * @deprecated on r74
 * @return
 */
public final native void setMetal(boolean metal)/*-{
this.metal = metal;
}-*/;




/**
 * @deprecated on r72
 * @param wrapAround
 */
public final native boolean isWrapAround()/*-{
return this.wrapAround;
}-*/;
/**
 * @deprecated on r72
 * @param wrapAround
 */
public final native void setWrapAround(boolean wrapAround)/*-{
this.wrapAround = wrapAround;
}-*/;

/**
 * @deprecated on r72
 * @param wrapAround
 */
public final native Vector3 getWrapRGB()/*-{
return this.wrapRGB;
}-*/;
/**
 * @deprecated on r72
 * @param wrapAround
 */
public final native void setWrapRGB(Vector3 wrapRGB)/*-{
this.wrapRGB = wrapRGB;
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


public final native Texture getBumpMap()/*-{
return this.bumpMap;
}-*/;

public final native void setBumpMap(Texture bumpMap)/*-{
this.bumpMap = bumpMap;
}-*/;


public final native double getBumpScale()/*-{
return this.bumpScale;
}-*/;

public final native void setBumpScale(double bumpScale)/*-{
this.bumpScale = bumpScale;
}-*/;


public final native Texture getNormalMap()/*-{
return this.normalMap;
}-*/;

public final native void setNormalMap(Texture normalMap)/*-{
this.normalMap = normalMap;
}-*/;


public final native Vector2 getNormalScale()/*-{
return this.normalScale;
}-*/;

public final native void setNormalScale(Vector2 normalScale)/*-{
this.normalScale = normalScale;
}-*/;


public final native Texture getSpecularMap()/*-{
return this.specularMap;
}-*/;

public final native void setSpecularMap(Texture specularMap)/*-{
this.specularMap = specularMap;
}-*/;

//TODO implement TextureCube
public final native JavaScriptObject getEnvMap()/*-{
return this.envMap;
}-*/;

public final native void setEnvMap(JavaScriptObject envMap)/*-{
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


public final native boolean isMorphNormals()/*-{
return this.morphNormals;
}-*/;

public final native void setMorphNormals(boolean morphNormals)/*-{
this.morphNormals = morphNormals;
}-*/;


public final native MeshPhongMaterial copy(MeshPhongMaterial source)/*-{
return this.copy(source);
}-*/;

public final native Texture getAoMap()/*-{
return this.aoMap;
}-*/;

public final native void setAoMap(Texture aoMap)/*-{
this.aoMap = aoMap;
}-*/;

public final native double getAoMapIntensity()/*-{
return this.aoMapIntensity;
}-*/;

public final native void setAoMapIntensity(double aoMapIntensity)/*-{
this.aoMapIntensity = aoMapIntensity;
}-*/;

public final native void setLightMapIntensity(double lightMapIntensity)/*-{
this.lightMapIntensity = lightMapIntensity;
}-*/;



public final  native Texture getDisplacementMap()/*-{
return this.displacementMap;
}-*/;
public final  native void setDisplacementMap(Texture  param)/*-{
this.displacementMap=param;
}-*/;


public final  native Texture getEmissiveMap()/*-{
return this.emissiveMap;
}-*/;
public final  native void setEmissiveMap(Texture  param)/*-{
this.emissiveMap=param;
}-*/;

public final  native double getEmissiveIntensity()/*-{
return this.emissiveIntensity;
}-*/;

public final  native void setEmissiveIntensity(double  param)/*-{
this.emissiveIntensity=param;
}-*/;
}
