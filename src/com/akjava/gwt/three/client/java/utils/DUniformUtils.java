package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.three.client.java.utils.DShaderUtils.DUniforms;
/**
 * @deprecated
 * @author aki
 *
 */
public class DUniformUtils {
	public static native final DUniforms clone(DUniforms uniform)/*-{
	return $wnd.THREE.UniformsUtils.clone(uniform);
	}-*/;
}
