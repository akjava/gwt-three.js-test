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
package com.akjava.gwt.three.client.js.renderers;

import com.akjava.gwt.three.client.js.extras.Shader;
import com.akjava.gwt.three.client.js.extras.Uniforms;
import com.google.gwt.core.client.JsArray;

/**
 * util classes
 * @author aki
 *
 */
public class WebGLShaders{
private WebGLShaders(){}
public static class ShaderChunk{
	private ShaderChunk(){}
	public final native String fog_pars_fragment()/*-{
	return THREE.ShaderChunk.fog_pars_fragment;
	}-*/;
	public final native String fog_fragment()/*-{
	return THREE.ShaderChunk.fog_fragment;
	}-*/;
	
	public final native String envmap_pars_fragment()/*-{
	return THREE.ShaderChunk.envmap_pars_fragment;
	}-*/;
	public final native String envmap_fragment()/*-{
	return THREE.ShaderChunk.envmap_fragment;
	}-*/;
	
	public final native String envmap_pars_vertex()/*-{
	return THREE.ShaderChunk.envmap_fragment;
	}-*/;
	
	public final native String worldpos_vertex()/*-{
	return THREE.ShaderChunk.envmap_fragment;
	}-*/;
	
	public final native String envmap_vertex()/*-{
	return THREE.ShaderChunk.envmap_vertex;
	}-*/;
	
	public final native String map_particle_pars_fragment()/*-{
	return THREE.ShaderChunk.map_particle_pars_fragment;
	}-*/;
	
	public final native String map_particle_fragment()/*-{
	return THREE.ShaderChunk.map_particle_pars_fragment;
	}-*/;
	
	public final native String map_pars_vertex()/*-{
	return THREE.ShaderChunk.map_pars_vertex;
	}-*/;
	
	public final native String map_pars_fragment()/*-{
	return THREE.ShaderChunk.map_pars_fragment;
	}-*/;
	
	public final native String map_vertex()/*-{
	return THREE.ShaderChunk.map_vertex;
	}-*/;
	
	public final native String map_fragment()/*-{
	return THREE.ShaderChunk.map_fragment;
	}-*/;
	
	public final native String lightmap_pars_fragment()/*-{
	return THREE.ShaderChunk.lightmap_pars_fragment;
	}-*/;
	
	public final native String lightmap_pars_vertex()/*-{
	return THREE.ShaderChunk.lightmap_pars_vertex;
	}-*/;
	
	public final native String lightmap_fragment()/*-{
	return THREE.ShaderChunk.lightmap_fragment;
	}-*/;
	
	public final native String lightmap_vertex()/*-{
	return THREE.ShaderChunk.lightmap_vertex;
	}-*/;
	
	public final native String bumpmap_pars_fragment()/*-{
	return THREE.ShaderChunk.bumpmap_pars_fragment;
	}-*/;
	
	public final native String specularmap_pars_fragment()/*-{
	return THREE.ShaderChunk.specularmap_pars_fragment;
	}-*/;
	
	public final native String lights_lambert_pars_vertex()/*-{
	return THREE.ShaderChunk.lights_lambert_pars_vertex;
	}-*/;
	
	public final native String specularmap_fragment()/*-{
	return THREE.ShaderChunk.specularmap_fragment;
	}-*/;
	
	public final native String lights_lambert_vertex()/*-{
	return THREE.ShaderChunk.lights_lambert_vertex;
	}-*/;
	
	public final native String lights_phong_pars_vertex()/*-{
	return THREE.ShaderChunk.lights_phong_pars_vertex;
	}-*/;
	
	public final native String lights_phong_vertex()/*-{
	return THREE.ShaderChunk.lights_phong_vertex;
	}-*/;
	
	public final native String lights_phong_pars_fragment()/*-{
	return THREE.ShaderChunk.lights_phong_pars_fragment;
	}-*/;
	
	public final native String lights_phong_fragment()/*-{
	return THREE.ShaderChunk.lights_phong_fragment;
	}-*/;
	
	public final native String color_pars_fragment()/*-{
	return THREE.ShaderChunk.color_pars_fragment;
	}-*/;
	
	public final native String color_fragment()/*-{
	return THREE.ShaderChunk.color_fragment;
	}-*/;
	
	public final native String color_pars_vertex()/*-{
	return THREE.ShaderChunk.color_pars_vertex;
	}-*/;
	
	public final native String color_vertex()/*-{
	return THREE.ShaderChunk.color_vertex;
	}-*/;
	
	public final native String skinning_pars_vertex()/*-{
	return THREE.ShaderChunk.skinning_pars_vertex;
	}-*/;
	
	public final native String skinbase_vertex()/*-{
	return THREE.ShaderChunk.skinbase_vertex;
	}-*/;
	
	public final native String skinning_vertex()/*-{
	return THREE.ShaderChunk.skinning_vertex;
	}-*/;
	
	public final native String morphtarget_pars_vertex()/*-{
	return THREE.ShaderChunk.morphtarget_pars_vertex;
	}-*/;
	
	public final native String morphtarget_vertex()/*-{
	return THREE.ShaderChunk.morphtarget_vertex;
	}-*/;
	
	public final native String default_vertex()/*-{
	return THREE.ShaderChunk.default_vertex;
	}-*/;
	
	public final native String morphnormal_vertex()/*-{
	return THREE.ShaderChunk.morphnormal_vertex;
	}-*/;
	
	public final native String skinnormal_vertex()/*-{
	return THREE.ShaderChunk.skinnormal_vertex;
	}-*/;
	
	public final native String defaultnormal_vertex()/*-{
	return THREE.ShaderChunk.defaultnormal_vertex;
	}-*/;
	
	public final native String shadowmap_pars_fragment()/*-{
	return THREE.ShaderChunk.shadowmap_pars_fragment;
	}-*/;
	
	public final native String shadowmap_fragment()/*-{
	return THREE.ShaderChunk.shadowmap_fragment;
	}-*/;
	
	public final native String shadowmap_pars_vertex()/*-{
	return THREE.ShaderChunk.shadowmap_pars_vertex;
	}-*/;
	
	public final native String shadowmap_vertex()/*-{
	return THREE.ShaderChunk.shadowmap_vertex;
	}-*/;
	
	public final native String alphatest_fragment()/*-{
	return THREE.ShaderChunk.alphatest_fragment;
	}-*/;
	
	public final native String linear_to_gamma_fragment()/*-{
	return THREE.ShaderChunk.linear_to_gamma_fragment;
	}-*/;
	
	public static class UniformsUtils{
		private UniformsUtils(){}
		public final native Uniforms merge(JsArray<Uniforms> uniformses)/*-{
		return THREE.UniformsUtils.merge(uniformses);
		}-*/;
		public final native Uniforms clone(Uniforms uniforms)/*-{
		return THREE.UniformsUtils.clone(uniforms);
		}-*/;
	}
	public static class UniformsLib{
private UniformsLib(){}
		public final native Uniforms common()/*-{
		return THREE.UniformsLib.common;
		}-*/;
		public final native Uniforms bump()/*-{
		return THREE.UniformsLib.bump;
		}-*/;
		public final native Uniforms normalmap()/*-{
		return THREE.UniformsLib.normalmap;
		}-*/;
		public final native Uniforms fog()/*-{
		return THREE.UniformsLib.fog;
		}-*/;
		public final native Uniforms lights()/*-{
		return THREE.UniformsLib.lights;
		}-*/;
		public final native Uniforms particle()/*-{
		return THREE.UniformsLib.particle;
		}-*/;
		public final native Uniforms shadowmap()/*-{
		return THREE.UniformsLib.common;
		}-*/;
	}
	
	public static class ShaderLib{
		private ShaderLib(){}
		public final native Shader basic()/*-{
		return THREE.ShaderLib.basic;
		}-*/;
		
		public final native Shader lambert()/*-{
		return THREE.ShaderLib.lambert;
		}-*/;
		
		public final native Shader phong()/*-{
		return THREE.ShaderLib.phong;
		}-*/;
		
		public final native Shader particle_basic()/*-{
		return THREE.ShaderLib.particle_basic;
		}-*/;
		
		
		
		public final native Shader dashed()/*-{
		return THREE.ShaderLib.dashed;
		}-*/;
		
		public final native Shader depth()/*-{
		return THREE.ShaderLib.depth;
		}-*/;
		
		public final native Shader normal()/*-{
		return THREE.ShaderLib.normal;
		}-*/;
		
		public final native Shader normalmap()/*-{
		return THREE.ShaderLib.normalmap;
		}-*/;
		
		public final native Shader cube()/*-{
		return THREE.ShaderLib.cube;
		}-*/;
		
		public final native Shader depthRGBA()/*-{
		return THREE.ShaderLib.depthRGBA;
		}-*/;
		
	}
}

}
