package com.akjava.gwt.three.client.examples.js;

import com.akjava.gwt.three.client.examples.js.controls.MouseControls;
import com.akjava.gwt.three.client.examples.js.controls.OrbitControls;
import com.akjava.gwt.three.client.examples.js.controls.VRControls;
import com.akjava.gwt.three.client.examples.js.controls.VRControls.VRControlCallbackHandler;
import com.akjava.gwt.three.client.examples.js.effects.StereoEffect;
import com.akjava.gwt.three.client.examples.js.postprocessing.BloomPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.BokehPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.ClearMaskPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.DotScreenPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.EffectComposer;
import com.akjava.gwt.three.client.examples.js.postprocessing.FilmPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.GlitchPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.MaskPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.RenderPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.ShaderPass;
import com.akjava.gwt.three.client.examples.js.postprocessing.TexturePass;
import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.js.cameras.Camera;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.akjava.gwt.three.client.js.materials.Material;
import com.akjava.gwt.three.client.js.math.Color;
import com.akjava.gwt.three.client.js.math.Vector2;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderTarget;
import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.akjava.gwt.three.client.js.scenes.Scene;
import com.akjava.gwt.three.client.js.textures.Texture;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

/*
 * for examples package constructor
 */
public class THREEExp {
	public static final native OrbitControls OrbitControls(Object3D object,Element dom)/*-{
	return new $wnd.THREE.OrbitControls(object,dom);
	}-*/;
	
	public static final native MouseControls MouseControls(Object3D object)/*-{
	return new $wnd.THREE.MouseControls(object);
	}-*/;
	
	
	public static final native VRControls VRControls(Object3D object)/*-{
	return new $wnd.THREE.VRControls(object);
	}-*/;
	
	public static final native VRControls VRControls(Object3D object,VRControlCallbackHandler handler)/*-{
	return new $wnd.THREE.VRControls(object,function ( message ) {
		handler.@com.akjava.gwt.three.client.examples.js.controls.VRControls$VRControlCallbackHandler::callback(Ljava/lang/String;)(message);
		});
	}-*/;
	
	
/**
 * 
 * @param renderer only WebGLRenderer support on this lib
 * @return
 */
	public static final native StereoEffect StereoEffect(WebGLRenderer renderer)/*-{
	return new $wnd.THREE.StereoEffect(renderer);
	}-*/;
	
	//need Mirror.js
	public static final native Mirror Mirror(WebGLRenderer renderer,Camera camera,JavaScriptObject options)/*-{
	return new $wnd.THREE.Mirror(renderer,camera,options);
	}-*/;
	
	//need WaterShader.js
	public static final native Water Water(WebGLRenderer renderer,Camera camera,Scene scene,JavaScriptObject options)/*-{
	return new $wnd.THREE.Water(renderer,camera,scene,options);
	}-*/;

	//need Ocean.js
		public static final native Ocean Ocean(WebGLRenderer renderer,Camera camera,Scene scene,JavaScriptObject options)/*-{
		return new $wnd.THREE.Ocean(renderer,camera,scene,options);
		}-*/;
		
		public static final native ShaderPass ShaderPass(Shader shader)/*-{
		return new $wnd.THREE.ShaderPass(shader);
		}-*/;
		public static final native ShaderPass ShaderPass(Shader shader,String textureID)/*-{
		return new $wnd.THREE.ShaderPass(shader,textureID);
		}-*/;
		
		public static final native RenderPass RenderPass(Scene scene,Camera camera)/*-{
		return new $wnd.THREE.RenderPass(scene,camera);
		}-*/;
		
		public static final native RenderPass RenderPass(Scene scene,Camera camera,Material overrideMaterial,Color clearColor,double clearAlpha )/*-{
		return new $wnd.THREE.RenderPass(scene,camera,overrideMaterial, clearColor, clearAlpha );
		}-*/;
		
		public static final native EffectComposer EffectComposer(WebGLRenderer renderer)/*-{
		return new $wnd.THREE.EffectComposer(renderer);
		}-*/;
		
		public static final native EffectComposer EffectComposer(WebGLRenderer renderer, WebGLRenderTarget renderTarget)/*-{
		return new $wnd.THREE.EffectComposer(renderer,renderTarget);
		}-*/;
		
		public static final native GlitchPass GlitchPass(int dt_size)/*-{
		return new $wnd.THREE.GlitchPass(dt_size);
		}-*/;
		
		public static final native GlitchPass GlitchPass()/*-{
		return new $wnd.THREE.GlitchPass();
		}-*/;
		
		public static final native BokehPass BokehPass(Scene scene,Camera camera,JavaScriptObject param)/*-{
		return new $wnd.THREE.BokehPass(scene,camera,param);
		}-*/;
		
		public static final native BloomPass BloomPass(double strength)/*-{
		return new $wnd.THREE.BloomPass(strength);
		}-*/;
		public static final native BloomPass BloomPass(double strength,int kernelSize,double sigma,int resolution)/*-{
		return new $wnd.THREE.BloomPass(strength, kernelSize, sigma, resolution);
		}-*/;
		public static final native FilmPass FilmPass(double noiseIntensity, double scanlinesIntensity,int scanlinesCount,boolean  grayscale )/*-{
		return new $wnd.THREE.FilmPass(noiseIntensity, scanlinesIntensity, scanlinesCount, grayscale );
		}-*/;
		public static final native DotScreenPass DotScreenPass(Vector2 center,double angle,double scale)/*-{
		return new $wnd.THREE.DotScreenPass(center, angle, scale);
		}-*/;
		public static final native ClearMaskPass ClearMaskPass()/*-{
		return new $wnd.THREE.ClearMaskPass();
		}-*/;
		public static final native MaskPass MaskPass(Scene scene,Camera camera)/*-{
		return new $wnd.THREE.MaskPass( scene, camera);
		}-*/;
		
		public static final native TexturePass TexturePass(Texture texture, double opacity)/*-{
		return new $wnd.THREE.TexturePass(texture, opacity);
		}-*/;
		
		public static final native TexturePass TexturePass(Texture texture)/*-{
		return new $wnd.THREE.TexturePass(texture);
		}-*/;
		
		public static final native TexturePass TexturePass(WebGLRenderTarget texture, double opacity)/*-{
		return new $wnd.THREE.TexturePass(texture, opacity);
		}-*/;
		
		public static final native TexturePass TexturePass(WebGLRenderTarget texture)/*-{
		return new $wnd.THREE.TexturePass(texture);
		}-*/;
		
		
}
