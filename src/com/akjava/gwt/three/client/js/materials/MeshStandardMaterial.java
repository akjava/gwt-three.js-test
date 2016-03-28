package com.akjava.gwt.three.client.js.materials;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.textures.CubeTexture;
import com.akjava.gwt.three.client.js.textures.Texture;
public class MeshStandardMaterial extends Material{
protected MeshStandardMaterial(){}



public final native Color getColor()/*-{
return this.color;
}-*/;

public final native void setColor(Color color)/*-{
this.color = color;
}-*/;


public final native double getRoughness()/*-{
return this.roughness;
}-*/;

public final native void setRoughness(double roughness)/*-{
this.roughness = roughness;
}-*/;


public final native double getMetalness()/*-{
return this.metalness;
}-*/;

public final native void setMetalness(double metalness)/*-{
this.metalness = metalness;
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


public final native double getLightMapIntensity()/*-{
return this.lightMapIntensity;
}-*/;

public final native void setLightMapIntensity(double lightMapIntensity)/*-{
this.lightMapIntensity = lightMapIntensity;
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


public final native Color getEmissive()/*-{
return this.emissive;
}-*/;

public final native void setEmissive(Color emissive)/*-{
this.emissive = emissive;
}-*/;


public final native double getEmissiveIntensity()/*-{
return this.emissiveIntensity;
}-*/;

public final native void setEmissiveIntensity(double emissiveIntensity)/*-{
this.emissiveIntensity = emissiveIntensity;
}-*/;


public final native Texture getEmissiveMap()/*-{
return this.emissiveMap;
}-*/;

public final native void setEmissiveMap(Texture emissiveMap)/*-{
this.emissiveMap = emissiveMap;
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


public final native Texture getDisplacementMap()/*-{
return this.displacementMap;
}-*/;

public final native void setDisplacementMap(Texture displacementMap)/*-{
this.displacementMap = displacementMap;
}-*/;


public final native double getDisplacementScale()/*-{
return this.displacementScale;
}-*/;

public final native void setDisplacementScale(double displacementScale)/*-{
this.displacementScale = displacementScale;
}-*/;


public final native double getDisplacementBias()/*-{
return this.displacementBias;
}-*/;

public final native void setDisplacementBias(double displacementBias)/*-{
this.displacementBias = displacementBias;
}-*/;


public final native Texture getRoughnessMap()/*-{
return this.roughnessMap;
}-*/;

public final native void setRoughnessMap(Texture roughnessMap)/*-{
this.roughnessMap = roughnessMap;
}-*/;


public final native Texture getMetalnessMap()/*-{
return this.metalnessMap;
}-*/;

public final native void setMetalnessMap(Texture metalnessMap)/*-{
this.metalnessMap = metalnessMap;
}-*/;


public final native Texture getAlphaMap()/*-{
return this.alphaMap;
}-*/;

public final native void setAlphaMap(Texture alphaMap)/*-{
this.alphaMap = alphaMap;
}-*/;


public final native CubeTexture getEnvMap()/*-{
return this.envMap;
}-*/;

public final native void setEnvMap(CubeTexture envMap)/*-{
this.envMap = envMap;
}-*/;


public final native double getEnvMapIntensity()/*-{
return this.envMapIntensity;
}-*/;

public final native void setEnvMapIntensity(double envMapIntensity)/*-{
this.envMapIntensity = envMapIntensity;
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
}