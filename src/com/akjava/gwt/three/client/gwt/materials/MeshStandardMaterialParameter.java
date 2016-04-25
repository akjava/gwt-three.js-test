package com.akjava.gwt.three.client.gwt.materials;

import com.akjava.gwt.three.client.gwt.JSParameter;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.textures.CubeTexture;
import com.akjava.gwt.three.client.js.textures.Texture;

public class MeshStandardMaterialParameter  extends JSParameter {
	protected MeshStandardMaterialParameter(){}
	public final static MeshStandardMaterialParameter create(){
		return (MeshStandardMaterialParameter) MeshStandardMaterialParameter.createObject();
	}
	
	public final native MeshStandardMaterialParameter color(Color color)/*-{
	this.color=color;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter roughness(double roughness)/*-{
	this.roughness=roughness;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter metalness(double metalness)/*-{
	this.metalness=metalness;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter map(Texture map)/*-{
	this.map=map;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter lightMap(Texture lightMap)/*-{
	this.lightMap=lightMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter lightMapIntensity(double lightMapIntensity)/*-{
	this.lightMapIntensity=lightMapIntensity;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter emissive(Color emissive)/*-{
	this.emissive=emissive;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter emissiveIntensity(double emissiveIntensity)/*-{
	this.emissiveIntensity=emissiveIntensity;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter emissiveMap(Texture emissiveMap)/*-{
	this.emissiveMap=emissiveMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter bumpMap(double bumpMap)/*-{
	this.bumpMap=bumpMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter bumpScale(double bumpScale)/*-{
	this.bumpScale=bumpScale;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter normalMap(Texture normalMap)/*-{
	this.normalMap=normalMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter normalScale(Vector2 normalScale)/*-{
	this.normalScale=normalScale;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter displacementMap(Texture displacementMap)/*-{
	this.displacementMap=displacementMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter displacementScale(double displacementScale)/*-{
	this.displacementScale=displacementScale;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter displacementBias(double displacementBias)/*-{
	this.displacementBias=displacementBias;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter roughnessMap(double roughnessMap)/*-{
	this.roughnessMap=roughnessMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter metalnessMap(double metalnessMap)/*-{
	this.metalnessMap=metalnessMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter alphaMap(double alphaMap)/*-{
	this.alphaMap=alphaMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter envMap(CubeTexture envMap)/*-{
	this.envMap=envMap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter envMapIntensity(double envMapIntensity)/*-{
	this.envMapIntensity=envMapIntensity;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter refractionRatio(double refractionRatio)/*-{
	this.refractionRatio=refractionRatio;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter fog(boolean fog)/*-{
	this.fog=fog;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter shading(int shading)/*-{
	this.shading=shading;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter wireframe(boolean wireframe)/*-{
	this.wireframe=wireframe;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter wireframeLinewidth(double wireframeLinewidth)/*-{
	this.wireframeLinewidth=wireframeLinewidth;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter wireframeLinecap(String wireframeLinecap)/*-{
	this.wireframeLinecap=wireframeLinecap;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter wireframeLinejoin(String wireframeLinejoin)/*-{
	this.wireframeLinejoin=wireframeLinejoin;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter vertexColors(int vertexColors)/*-{
	this.vertexColors=vertexColors;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter skinning(boolean skinning)/*-{
	this.skinning=skinning;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter morphTargets(boolean morphTargets)/*-{
	this.morphTargets=morphTargets;
	return this;
	}-*/;

	public final native MeshStandardMaterialParameter morphNormals(boolean morphNormals)/*-{
	this.morphNormals=morphNormals;
	return this;
	}-*/;


	public final native MeshBasicMaterialParameter visible(boolean visible)/*-{
	this.visible=visible;
	return this;
	}-*/;
}