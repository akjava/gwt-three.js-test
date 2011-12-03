package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vertex;
import com.google.gwt.core.client.JsArray;

public class GWTGeometryUtils {


	/**
	 * @deprecated
	 * use center
	 * @param vertices
	 */
	public static final void centerOfVertices(JsArray<Vertex> vertices){
		Vector3 center=getCenter(vertices);
		for(int i=0;i<vertices.length();i++){
			vertices.get(i).getPosition().subSelf(center);
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
