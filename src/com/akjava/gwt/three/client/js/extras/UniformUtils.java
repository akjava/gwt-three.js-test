package com.akjava.gwt.three.client.js.extras;

import com.akjava.gwt.three.client.js.extras.ShaderUtils.Uniforms;
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
