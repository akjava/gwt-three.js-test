package com.akjava.gwt.three.client.java.utils;

import com.akjava.gwt.three.client.js.math.Color;
import com.google.gwt.core.client.JavaScriptObject;

public class JsColorUtils {

	public static native final void rgbToHsv(Color color,Hsv hsv)/*-{
	$wnd.THREE.ColorUtils.rgbToHsv( color, hsv );
	}-*/;
	
	public static native final Hsv createHsv()/*-{
	return $wnd.THREE.ColorUtils.__hsv;
	}-*/;
	
	public static Hsv rgbToHsv(Color color){
		Hsv hsv=createHsv();
		rgbToHsv(color,hsv);
		return hsv;
	}
	
	public static class Hsv extends JavaScriptObject{
		protected Hsv(){}
		
		public final native double getH()/*-{
		return this.h;
		}-*/;
		
		public final native double getS()/*-{
		return this.s;
		}-*/;
		
		public final native double getV()/*-{
		return this.v;
		}-*/;
	}
}
