package com.akjava.gwt.three.client.js.math;

import com.google.gwt.core.client.JavaScriptObject;
/**
 * @deprecated use Vector2
 * @author aki
 *
 */
public class UV extends JavaScriptObject{
protected UV(){}


public final native double getU()/*-{
return this.u;
}-*/;

public final native double getV()/*-{
return this.v;
}-*/;

}
