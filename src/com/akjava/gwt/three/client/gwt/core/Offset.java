package com.akjava.gwt.three.client.gwt.core;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * i'm not sure about offsets.
 * @author aki
 *
 */
public class Offset extends JavaScriptObject{
protected Offset(){}

public final native int getStart()/*-{
return this.start;
}-*/;

public final native int getCount()/*-{
return this.count;
}-*/;

public final native int getIndex()/*-{
return this.index;
}-*/;


public final native Offset start(int value)/*-{
this.start=value;
return this;
}-*/;

public final native Offset index(int value)/*-{
this.index=value;
return this;
}-*/;

public final native Offset count(int value)/*-{
this.count=value;
return this;
}-*/;

}
