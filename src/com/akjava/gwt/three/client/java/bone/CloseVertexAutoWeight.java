package com.akjava.gwt.three.client.java.bone;

import com.akjava.gwt.lib.client.JavaScriptUtils;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.google.gwt.core.client.JsArray;

public class CloseVertexAutoWeight {
	//TODO averaging
	public WeightResult autoWeight(Geometry geometry,Geometry targetGeometry){
		JsArray<Vector4> bodyIndices=JavaScriptUtils.createJSArray();
		JsArray<Vector4> bodyWeight=JavaScriptUtils.createJSArray();
		for(int i=0;i<geometry.vertices().length();i++){
			JsArray<DistanceVertexIndex> array=JavaScriptUtils.createJSArray();
			
			Vector3 origin=geometry.vertices().get(i);
			for(int j=0;j<targetGeometry.vertices().length();j++){
				Vector3 target=targetGeometry.vertices().get(j);
				double distance=target.distanceTo(origin);
				array.push(DistanceVertexIndex.create(j,distance));
			}
			
			sort(array);
			int index=array.get(0).getVertexIndex();//closed,TODO
			//LogUtils.log("closed:"+index);
			bodyIndices.push(targetGeometry.getSkinIndices().get(index).clone());
			bodyWeight.push(targetGeometry.getSkinWeights().get(index).clone());
		}
		return new WeightResult(bodyIndices, bodyWeight);
	}
	
	
	
	public final  native void sort(JsArray<DistanceVertexIndex> distances)/*-{
		distances.sort(
		function(a,b){
    	if( a.distance < b.distance ) return -1;
        if( a.distance > b.distance ) return 1;
        	return 0;
		}
		);
		
	}-*/;

	
}
