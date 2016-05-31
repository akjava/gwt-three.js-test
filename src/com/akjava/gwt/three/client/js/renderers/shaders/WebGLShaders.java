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
package com.akjava.gwt.three.client.js.renderers.shaders;

import com.akjava.gwt.three.client.gwt.extras.Shader;
import com.akjava.gwt.three.client.gwt.extras.Uniforms;
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
	public static final native String fog_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.fog_pars_fragment;
	}-*/;
	public static final native String fog_fragment()/*-{
	return $wnd.THREE.ShaderChunk.fog_fragment;
	}-*/;
	
	public static final native String envmap_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.envmap_pars_fragment;
	}-*/;
	public static final native String envmap_fragment()/*-{
	return $wnd.THREE.ShaderChunk.envmap_fragment;
	}-*/;
	
	public static final native String envmap_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.envmap_fragment;
	}-*/;
	
	public static final native String worldpos_vertex()/*-{
	return $wnd.THREE.ShaderChunk.envmap_fragment;
	}-*/;
	
	public static final native String envmap_vertex()/*-{
	return $wnd.THREE.ShaderChunk.envmap_vertex;
	}-*/;
	
	public static final native String map_particle_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.map_particle_pars_fragment;
	}-*/;
	
	public static final native String map_particle_fragment()/*-{
	return $wnd.THREE.ShaderChunk.map_particle_pars_fragment;
	}-*/;
	
	public static final native String map_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.map_pars_vertex;
	}-*/;
	
	public static final native String map_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.map_pars_fragment;
	}-*/;
	
	public static final native String map_vertex()/*-{
	return $wnd.THREE.ShaderChunk.map_vertex;
	}-*/;
	
	public static final native String map_fragment()/*-{
	return $wnd.THREE.ShaderChunk.map_fragment;
	}-*/;
	
	public static final native String lightmap_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.lightmap_pars_fragment;
	}-*/;
	
	public static final native String lightmap_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.lightmap_pars_vertex;
	}-*/;
	
	public static final native String lightmap_fragment()/*-{
	return $wnd.THREE.ShaderChunk.lightmap_fragment;
	}-*/;
	
	public static final native String lightmap_vertex()/*-{
	return $wnd.THREE.ShaderChunk.lightmap_vertex;
	}-*/;
	
	public static final native String bumpmap_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.bumpmap_pars_fragment;
	}-*/;
	
	public static final native String specularmap_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.specularmap_pars_fragment;
	}-*/;
	
	public static final native String lights_lambert_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.lights_lambert_pars_vertex;
	}-*/;
	
	public static final native String specularmap_fragment()/*-{
	return $wnd.THREE.ShaderChunk.specularmap_fragment;
	}-*/;
	
	public static final native String lights_lambert_vertex()/*-{
	return $wnd.THREE.ShaderChunk.lights_lambert_vertex;
	}-*/;
	
	public static final native String lights_phong_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.lights_phong_pars_vertex;
	}-*/;
	
	public static final native String lights_phong_vertex()/*-{
	return $wnd.THREE.ShaderChunk.lights_phong_vertex;
	}-*/;
	
	public static final native String lights_phong_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.lights_phong_pars_fragment;
	}-*/;
	
	public static final native String lights_phong_fragment()/*-{
	return $wnd.THREE.ShaderChunk.lights_phong_fragment;
	}-*/;
	
	public static final native String color_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.color_pars_fragment;
	}-*/;
	
	public static final native String color_fragment()/*-{
	return $wnd.THREE.ShaderChunk.color_fragment;
	}-*/;
	
	public static final native String color_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.color_pars_vertex;
	}-*/;
	
	public static final native String color_vertex()/*-{
	return $wnd.THREE.ShaderChunk.color_vertex;
	}-*/;
	
	public static final native String skinning_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.skinning_pars_vertex;
	}-*/;
	
	public static final native String skinbase_vertex()/*-{
	return $wnd.THREE.ShaderChunk.skinbase_vertex;
	}-*/;
	
	public static final native String skinning_vertex()/*-{
	return $wnd.THREE.ShaderChunk.skinning_vertex;
	}-*/;
	
	public static final native String morphtarget_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.morphtarget_pars_vertex;
	}-*/;
	
	public static final native String morphtarget_vertex()/*-{
	return $wnd.THREE.ShaderChunk.morphtarget_vertex;
	}-*/;
	
	public static final native String default_vertex()/*-{
	return $wnd.THREE.ShaderChunk.default_vertex;
	}-*/;
	
	public static final native String morphnormal_vertex()/*-{
	return $wnd.THREE.ShaderChunk.morphnormal_vertex;
	}-*/;
	
	public static final native String skinnormal_vertex()/*-{
	return $wnd.THREE.ShaderChunk.skinnormal_vertex;
	}-*/;
	
	public static final native String defaultnormal_vertex()/*-{
	return $wnd.THREE.ShaderChunk.defaultnormal_vertex;
	}-*/;
	
	public static final native String shadowmap_pars_fragment()/*-{
	return $wnd.THREE.ShaderChunk.shadowmap_pars_fragment;
	}-*/;
	
	public static final native String shadowmap_fragment()/*-{
	return $wnd.THREE.ShaderChunk.shadowmap_fragment;
	}-*/;
	
	public static final native String shadowmap_pars_vertex()/*-{
	return $wnd.THREE.ShaderChunk.shadowmap_pars_vertex;
	}-*/;
	
	public static final native String shadowmap_vertex()/*-{
	return $wnd.THREE.ShaderChunk.shadowmap_vertex;
	}-*/;
	
	public static final native String alphatest_fragment()/*-{
	return $wnd.THREE.ShaderChunk.alphatest_fragment;
	}-*/;
	
	public static final native String linear_to_gamma_fragment()/*-{
	return $wnd.THREE.ShaderChunk.linear_to_gamma_fragment;
	}-*/;
	
	public static class UniformsUtils{
		private UniformsUtils(){}
		public static final native Uniforms merge(JsArray<Uniforms> uniformses)/*-{
		return $wnd.THREE.UniformsUtils.merge(uniformses);
		}-*/;
		public static final native Uniforms clone(Uniforms uniforms)/*-{
		return $wnd.THREE.UniformsUtils.clone(uniforms);
		}-*/;
	}
	public static class UniformsLib{
private UniformsLib(){}
		public static final native Uniforms common()/*-{
		return $wnd.THREE.UniformsLib.common;
		}-*/;
		public static final native Uniforms bump()/*-{
		return $wnd.THREE.UniformsLib.bump;
		}-*/;
		public static final native Uniforms normalmap()/*-{
		return $wnd.THREE.UniformsLib.normalmap;
		}-*/;
		public static final native Uniforms fog()/*-{
		return $wnd.THREE.UniformsLib.fog;
		}-*/;
		public static final native Uniforms lights()/*-{
		return $wnd.THREE.UniformsLib.lights;
		}-*/;
		public static final native Uniforms particle()/*-{
		return $wnd.THREE.UniformsLib.particle;
		}-*/;
		public static final native Uniforms shadowmap()/*-{
		return $wnd.THREE.UniformsLib.common;
		}-*/;
	}
	
	public static class ShaderLib{
		private ShaderLib(){}
		public static final native Shader basic()/*-{
		return $wnd.THREE.ShaderLib.basic;
		}-*/;
		
		public static final native Shader lambert()/*-{
		return $wnd.THREE.ShaderLib.lambert;
		}-*/;
		
		public static final native Shader phong()/*-{
		return $wnd.THREE.ShaderLib.phong;
		}-*/;
		
		public static final native Shader particle_basic()/*-{
		return $wnd.THREE.ShaderLib.particle_basic;
		}-*/;
		
		
		
		public static final native Shader dashed()/*-{
		return $wnd.THREE.ShaderLib.dashed;
		}-*/;
		
		public static final native Shader depth()/*-{
		return $wnd.THREE.ShaderLib.depth;
		}-*/;
		
		public static final native Shader normal()/*-{
		return $wnd.THREE.ShaderLib.normal;
		}-*/;
		
		public static final native Shader normalmap()/*-{
		return $wnd.THREE.ShaderLib.normalmap;
		}-*/;
		
		public static final native Shader cube()/*-{
		return $wnd.THREE.ShaderLib.cube;
		}-*/;
		
		public static final native Shader depthRGBA()/*-{
		return $wnd.THREE.ShaderLib.depthRGBA;
		}-*/;
		
		public static final native Shader get(String name)/*-{
		return $wnd.THREE.ShaderLib[name];
		}-*/;
		
	}
}

}
