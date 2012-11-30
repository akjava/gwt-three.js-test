package com.akjava.gwt.three.client.extras;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.Object3D;
import com.akjava.gwt.three.client.materials.Material;
import com.akjava.gwt.three.client.scenes.Scene;
import com.google.gwt.core.client.JsArray;

public class SceneUtils {
	public static native final Object3D createMultiMaterialObject(Geometry geometry, JsArray<Material> materials)/*-{
	return $wnd.THREE.SceneUtils.createMultiMaterialObject(geometry,materials);
	}-*/;
	public static final Object3D createMultiMaterialObject(Geometry geometry, Iterable<Material> materials){
		@SuppressWarnings("unchecked")
		JsArray<Material> jsmaterials=THREE.createJsArray();
		for(Material m:materials){
			jsmaterials.push(m);
		}
		return createMultiMaterialObject(geometry, jsmaterials);
	}
	
	public static native final void detach(Object3D child,Scene scene,Object3D parent)/*-{
	return $wnd.THREE.SceneUtils.detach(child,scene,parent);
	}-*/;
	public static native final void attach(Object3D child,Scene scene,Object3D parent)/*-{
	return $wnd.THREE.SceneUtils.attach(child,scene,parent);
	}-*/;
}
