package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.MorphTarget;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vertex;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;

public class GWTGeometryUtils {

	private GWTGeometryUtils(){}
	
	
	public final static  Geometry createLine(Vector3 from,Vector3 to){
		Geometry lineG = THREE.Geometry();
		lineG.vertices().push(THREE.Vertex(from));
		lineG.vertices().push(THREE.Vertex(to));
		
		return lineG;
	}
	
	/**
	 * Warning center way is different of GeometryUtils.center()
	 * use center
	 * @param vertices
	 */
	public static final void centerOfVertices(JsArray<Vertex> vertices){
		Vector3 center=getCenter(vertices);
		for(int i=0;i<vertices.length();i++){
			vertices.get(i).getPosition().subSelf(center);
		}
	}
	
	//set center for animation
	public static final void centerOfMorphTargets(Geometry geometry){
		JsArray<MorphTarget> mofs=geometry.getMorphTargets();
		GWT.log("mofs:"+mofs.length());
		for(int i=0;i<mofs.length();i++){
			GWT.log("mofs:-docenter"+i);
			centerOfVertices(mofs.get(i).getVertices());
		}
	}
	
	
	public static final native Vector3 getCenter(JsArray<Vertex> vertices)/*-{
	var center = new $wnd.THREE.Vector3();

for ( var i = 0, l = vertices.length; i < l; i ++ ) {

    center.addSelf(vertices[ i ].position );

} 
	center.divideScalar( vertices.length );
	return center;
	}-*/;
	
	
	
}
