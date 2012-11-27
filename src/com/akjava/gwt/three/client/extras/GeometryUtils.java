package com.akjava.gwt.three.client.extras;

import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.objects.Mesh;

public class GeometryUtils {

	public static native final void center(Geometry geo)/*-{
	return $wnd.THREE.GeometryUtils.center(geo);
	}-*/;
	
	/**
	 * @deprecated use Geometry.clone();
	 * @param geo
	 * @return
	 */
	public static native final Geometry clone(Geometry geo)/*-{
	return geo.clone();
	}-*/;

	public static native final void merge(Geometry geo,Geometry geo2)/*-{
	return $wnd.THREE.GeometryUtils.merge(geo,geo2);
	}-*/;
	
	public static native final void merge(Geometry geo,Mesh mesh)/*-{
	return $wnd.THREE.GeometryUtils.merge(geo,mesh);
	}-*/;
}
