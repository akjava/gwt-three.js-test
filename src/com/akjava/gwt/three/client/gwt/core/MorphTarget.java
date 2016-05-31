package com.akjava.gwt.three.client.gwt.core;

import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONString;

/**
 * i'm not sure,what is it.
 * @author aki
 *
 */
public class MorphTarget extends JavaScriptObject{
protected MorphTarget(){}

public final native JsArray<Vector3> getVertices()/*-{
return this.vertices;
}-*/;

public final native String getName()/*-{
return this.name;
}-*/;

public final native MorphTarget setName(String name)/*-{
this.name=name;
return this;
}-*/;

public final native MorphTarget setVertices(JsArray<Vector3> vertices)/*-{
this.vertices=vertices;
return this;
}-*/;


public final native MorphTarget name(String name)/*-{
this.name=name;
return this;
}-*/;

public final native MorphTarget vertices(JsArray<Vector3> vertices)/*-{
this.vertices=vertices;
return this;
}-*/;

public static native final MorphTarget create()/*-{
return {name:"",vertices:[]};
}-*/;

public final JavaScriptObject toJSON(){
	JSONObject object=new JSONObject();
	object.put("name", new JSONString(getName()));
	JsArrayNumber number=JsArrayNumber.createArray(getVertices().length()*3).cast();
	for(int i=0;i<getVertices().length();i++){
		int index=i*3;
		number.set(index, getVertices().get(i).getX());
		number.set(index+1, getVertices().get(i).getY());
		number.set(index+2, getVertices().get(i).getZ());
	}
	object.put("vertices", new JSONArray(number));
	return object.getJavaScriptObject();
}

}
