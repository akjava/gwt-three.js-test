package com.akjava.gwt.three.client.extras.modifiers;

import com.akjava.gwt.three.client.js.core.Geometry;
import com.google.gwt.core.client.JavaScriptObject;

public class SubdivisionModifier extends JavaScriptObject{
protected SubdivisionModifier(){}

public  native final void modify(Geometry geo)/*-{
this.modify(geo);
}-*/;
}
