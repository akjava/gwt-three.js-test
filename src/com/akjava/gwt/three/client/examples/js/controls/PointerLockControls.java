package com.akjava.gwt.three.client.examples.js.controls;

import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.core.client.JavaScriptObject;

public class PointerLockControls extends JavaScriptObject{
protected PointerLockControls(){}

public final  native Object3D getObject()/*-{
return this.getObject();
}-*/;

public final  native void setEnabled(boolean enabled)/*-{
return this.enabled=enabled;
}-*/;

//TODO more
}
