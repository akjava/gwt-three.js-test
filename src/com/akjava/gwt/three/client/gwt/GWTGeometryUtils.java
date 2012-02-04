package com.akjava.gwt.three.client.gwt;

import com.akjava.gwt.three.client.THREE;
import com.akjava.gwt.three.client.core.Geometry;
import com.akjava.gwt.three.client.core.MorphTarget;
import com.akjava.gwt.three.client.core.Vector3;
import com.akjava.gwt.three.client.core.Vertex;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader;
import com.akjava.gwt.three.client.extras.loaders.JSONLoader.LoadHandler;
import com.akjava.gwt.three.client.objects.Mesh;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONValue;

public class GWTGeometryUtils {

	private GWTGeometryUtils(){}
	
	
	/*
	 * from ,to used in vetex.clone by yourselef if it's necessaly
	 */
	public final static  Geometry createLineGeometry(Vector3 from,Vector3 to){
		Geometry lineG = THREE.Geometry();
		lineG.vertices().push(THREE.Vertex(from));
		lineG.vertices().push(THREE.Vertex(to));
		
		return lineG;
	}
	public final static  Mesh createLineMesh(Vector3 from,Vector3 to,int color){
		return THREE.Line(GWTGeometryUtils.createLineGeometry(from, to),
				THREE.LineBasicMaterial().color(color).build());
	}
	
	public final static  Mesh createLineMesh(Vector3 from,Vector3 to,int color,double lineWidth){
		return THREE.Line(GWTGeometryUtils.createLineGeometry(from, to),
				THREE.LineBasicMaterial().color(color).linewidth(lineWidth).build());
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
	
	
	public static final JSONObject loadJsonModel(String jsonText,LoadHandler handler){
		JSONLoader loader=THREE.JSONLoader();
		JSONValue lastJsonValue = JSONParser.parseLenient(jsonText);
		JSONObject object=lastJsonValue.isObject();
		if(object==null){
			return null;
		}
		
		loader.createModel(object.getJavaScriptObject(), handler, "");
		loader.onLoadComplete();
		return object;
	}
	
	
	
}
