package com.akjava.gwt.three.client.js.audio;

import com.google.gwt.core.client.JavaScriptObject;


	public class AudioBuffer extends JavaScriptObject{
		protected AudioBuffer(){}
		
		public final  native JavaScriptObject getContext()/*-{
		return this.context;
		}-*/;
		
		public final  native void load(String file)/*-{
		this.load(file);
		}-*/;

		public final  native void onReady(JavaScriptObject callbck)/*-{
		this.onReady(callback);
		}-*/;

	}
	


