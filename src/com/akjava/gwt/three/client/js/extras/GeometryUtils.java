package com.akjava.gwt.three.client.js.extras;

import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.objects.Mesh;
import com.google.gwt.user.client.ui.CustomButton.Face;

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

	public static native final void merge(Geometry geo,Geometry geo2,int materialIndexOffset)/*-{
	return $wnd.THREE.GeometryUtils.merge(geo,geo2,materialIndexOffset);
	}-*/;
	
	public static native final void merge(Geometry geo,Geometry geo2)/*-{
	return $wnd.THREE.GeometryUtils.merge(geo,geo2);
	}-*/;
	
	public static native final void merge(Geometry geo,Mesh mesh,int materialIndexOffset)/*-{
	return $wnd.THREE.GeometryUtils.merge(geo,mesh,materialIndexOffset);
	}-*/;
	
	public static native final void merge(Geometry geo,Mesh mesh)/*-{
	return $wnd.THREE.GeometryUtils.merge(geo,mesh);
	}-*/;
	
	public static final native Vector3 randomPointInTriangle(Vector3 vectorA, Vector3 vectorB, Vector3 vectorC )/*-{
	return $wnd.THREE.GeometryUtils.randomPointInTriangle(vectorA, vectorB, vectorC );
	}-*/;
	
	public static final native Vector3 randomPointInFace(Face face,Geometry geometry,boolean useCachedAreas)/*-{
	return $wnd.THREE.GeometryUtils.randomPointInFace(face,geometry,useCachedAreas);
	}-*/;
	
	public static final native Vector3 randomPointsInGeometry(Geometry geometry,int n)/*-{
	return $wnd.THREE.GeometryUtils.randomPointsInGeometry(geometry,n);
	}-*/;
	
	public static final native double triangleArea(Vector3 vectorA, Vector3 vectorB, Vector3 vectorC )/*-{
	return $wnd.THREE.GeometryUtils.triangleArea(vectorA, vectorB, vectorC );
	}-*/;
	
	
	public static final native void triangulateQuads(Geometry geometry)/*-{
	$wnd.THREE.GeometryUtils.triangulateQuads(geometry);
	}-*/;
}
