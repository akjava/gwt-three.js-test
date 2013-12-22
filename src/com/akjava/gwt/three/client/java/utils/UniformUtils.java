package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.three.client.java.utils.ShaderUtils.Uniforms;
/**
 * @deprecated
 * @author aki
 *
 */
public class UniformUtils {
	public static native final Uniforms clone(Uniforms uniform)/*-{
	return $wnd.THREE.UniformsUtils.clone(uniform);
	}-*/;
}
