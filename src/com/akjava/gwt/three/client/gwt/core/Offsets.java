package com.akjava.gwt.three.client.gwt.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * i'm not sure about offsets.
 * @author aki
 *
 */
public class Offsets extends JavaScriptObject{
protected Offsets(){}

public final native int getStart()/*-{
return this.start;
}-*/;

public final native int getCount()/*-{
return this.count;
}-*/;

public final native int getIndex()/*-{
return this.index;
}-*/;

}
