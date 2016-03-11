package com.akjava.gwt.three.client.examples.js;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

/*
 * for tween.js limited support for example
 */
public class TWEEN extends JavaScriptObject{
protected TWEEN(){}

public static final native void update()/*-{
return $wnd.TWEEN.update();
}-*/;

public static final native JsArray<TWEEN> getAll()/*-{
return $wnd.TWEEN.getAll();
}-*/;

public  final native TWEEN stop()/*-{
return this.stop();
}-*/;

public  final native TWEEN start()/*-{
return this.start();
}-*/;
public  final native TWEEN to(JavaScriptObject parameter,double duration)/*-{

return this.to(parameter,duration);
}-*/;
public  final native TWEEN to(String name,double value,double duration)/*-{
var hash={};
hash[name]=value;
return this.to(hash,duration);
}-*/;
public  final native TWEEN easing(JavaScriptObject functionObject)/*-{
return this.easing(functionObject);
}-*/;

//from
public static final native TWEEN Tween(JavaScriptObject parameters)/*-{
return new $wnd.TWEEN.Tween(parameters);
}-*/;
public static final native TWEEN Tween(String name,double value)/*-{
return new $wnd.TWEEN.Tween({name:value});
}-*/;

public static final native JavaScriptObject Easing_Linear_None()/*-{
return $wnd.TWEEN.Easing.Linear.None;
}-*/;

public static final native JavaScriptObject Easing_Quadratic_In()/*-{
return $wnd.TWEEN.Easing.Quadratic.In;
}-*/;
public static final native JavaScriptObject Easing_Quadratic_Out()/*-{
return $wnd.TWEEN.Easing.Quadratic.Out;
}-*/;
public static final native JavaScriptObject Easing_Quadratic_InOut()/*-{
return $wnd.TWEEN.Easing.Quadratic.InOut;
}-*/;

public static final native JavaScriptObject Easing_Cubic_In()/*-{
return $wnd.TWEEN.Easing.Cubic.In;
}-*/;
public static final native JavaScriptObject Easing_Cubic_Out()/*-{
return $wnd.TWEEN.Easing.Cubic.Out;
}-*/;
public static final native JavaScriptObject Easing_Cubic_InOut()/*-{
return $wnd.TWEEN.Easing.Cubic.InOut;
}-*/;

public static final native JavaScriptObject Easing_Quartic_In()/*-{
return $wnd.TWEEN.Easing.Quartic.In;
}-*/;
public static final native JavaScriptObject Easing_Quartic_Out()/*-{
return $wnd.TWEEN.Easing.Quartic.Out;
}-*/;
public static final native JavaScriptObject Easing_Quartic_InOut()/*-{
return $wnd.TWEEN.Easing.Quartic.InOut;
}-*/;

public static final native JavaScriptObject Easing_Quintic_In()/*-{
return $wnd.TWEEN.Easing.Quintic.In;
}-*/;
public static final native JavaScriptObject Easing_Quintic_Out()/*-{
return $wnd.TWEEN.Easing.Quintic.Out;
}-*/;
public static final native JavaScriptObject Easing_Quintic_InOut()/*-{
return $wnd.TWEEN.Easing.Quintic.InOut;
}-*/;public static final native JavaScriptObject Easing_Sinusoidal_In()/*-{
return $wnd.TWEEN.Easing.Sinusoidal.In;
}-*/;
public static final native JavaScriptObject Easing_Sinusoidal_Out()/*-{
return $wnd.TWEEN.Easing.Sinusoidal.Out;
}-*/;
public static final native JavaScriptObject Easing_Sinusoidal_InOut()/*-{
return $wnd.TWEEN.Easing.Sinusoidal.InOut;
}-*/;public static final native JavaScriptObject Easing_Exponential_In()/*-{
return $wnd.TWEEN.Easing.Exponential.In;
}-*/;
public static final native JavaScriptObject Easing_Exponential_Out()/*-{
return $wnd.TWEEN.Easing.Exponential.Out;
}-*/;
public static final native JavaScriptObject Easing_Exponential_InOut()/*-{
return $wnd.TWEEN.Easing.Exponential.InOut;
}-*/;public static final native JavaScriptObject Easing_Circular_In()/*-{
return $wnd.TWEEN.Easing.Circular.In;
}-*/;
public static final native JavaScriptObject Easing_Circular_Out()/*-{
return $wnd.TWEEN.Easing.Circular.Out;
}-*/;
public static final native JavaScriptObject Easing_Circular_InOut()/*-{
return $wnd.TWEEN.Easing.Circular.InOut;
}-*/;public static final native JavaScriptObject Easing_Elastic_In()/*-{
return $wnd.TWEEN.Easing.Elastic.In;
}-*/;
public static final native JavaScriptObject Easing_Elastic_Out()/*-{
return $wnd.TWEEN.Easing.Elastic.Out;
}-*/;
public static final native JavaScriptObject Easing_Elastic_InOut()/*-{
return $wnd.TWEEN.Easing.Elastic.InOut;
}-*/;public static final native JavaScriptObject Easing_Back_In()/*-{
return $wnd.TWEEN.Easing.Back.In;
}-*/;
public static final native JavaScriptObject Easing_Back_Out()/*-{
return $wnd.TWEEN.Easing.Back.Out;
}-*/;
public static final native JavaScriptObject Easing_Back_InOut()/*-{
return $wnd.TWEEN.Easing.Back.InOut;
}-*/;public static final native JavaScriptObject Easing_Bounce_In()/*-{
return $wnd.TWEEN.Easing.Bounce.In;
}-*/;
public static final native JavaScriptObject Easing_Bounce_Out()/*-{
return $wnd.TWEEN.Easing.Bounce.Out;
}-*/;
public static final native JavaScriptObject Easing_Bounce_InOut()/*-{
return $wnd.TWEEN.Easing.Bounce.InOut;
}-*/;
}
