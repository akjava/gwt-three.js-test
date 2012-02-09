package com.akjava.gwt.three.client.core;

import com.google.gwt.core.client.JavaScriptObject;

public class UV extends JavaScriptObject{
protected UV(){}


public final native double getU()/*-{
return this.u;
}-*/;

public final native double getV()/*-{
return this.v;
}-*/;

}
