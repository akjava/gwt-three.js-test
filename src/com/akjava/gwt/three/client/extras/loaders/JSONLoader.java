package com.akjava.gwt.three.client.extras.loaders;

import com.akjava.gwt.three.client.core.Geometry;
import com.google.gwt.core.client.JavaScriptObject;

public class JSONLoader extends JavaScriptObject{

	protected JSONLoader(){}
	
	//show status not support
	
	public final native void load(String path,LoadHandler handler)/*-{
	//r46 version
	//instance of Object make a crush
	this.load(path,function ( geometry ) {
		handler.@com.akjava.gwt.three.client.extras.loaders.JSONLoader$LoadHandler::loaded(Lcom/akjava/gwt/three/client/core/Geometry;)(geometry);
		});
			
	//this.load({model:path,callback:function ( geometry ) {
	//	handler.@com.akjava.gwt.three.client.extras.loaders.JSONLoader$LoadHandler::loaded(Lcom/akjava/gwt/three/client/core/Geometry;)(geometry);
	//	}
	//});
	
	}-*/;
	
	public static interface LoadHandler {
		public void loaded(Geometry geometry);
	}
}
