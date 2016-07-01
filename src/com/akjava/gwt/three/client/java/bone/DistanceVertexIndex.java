package com.akjava.gwt.three.client.java.bone;
import com.google.gwt.core.client.JavaScriptObject;
public class DistanceVertexIndex extends JavaScriptObject{
protected DistanceVertexIndex(){}

public static DistanceVertexIndex create(int index,double distance){
	DistanceVertexIndex object=JavaScriptObject.createObject().cast();
	object.setDistance(distance);
	object.setVertexIndex(index);
	return object;
}

public final  native double getDistance()/*-{
return this.distance;
}-*/;

public final  native void setDistance(double  param)/*-{
this.distance=param;
}-*/;
public final  native int getVertexIndex()/*-{
return this.vertexIndex;
}-*/;

public final  native void setVertexIndex(int  param)/*-{
this.vertexIndex=param;
}-*/;

}