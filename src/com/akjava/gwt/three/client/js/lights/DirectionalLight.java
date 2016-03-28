package com.akjava.gwt.three.client.js.lights;

import com.akjava.gwt.three.client.js.core.Object3D;

public class DirectionalLight extends Light{
	protected DirectionalLight(){}
	

public final native Object3D getTarget()/*-{
return this.target;
}-*/;

public final native void setTarget(Object3D target)/*-{
this.target = target;
}-*/;


public final native LightShadow getShadow()/*-{
return this.shadow;
}-*/;

public final native void setShadow(LightShadow shadow)/*-{
this.shadow = shadow;
}-*/;






public final native DirectionalLight copy(DirectionalLight source)/*-{
return this.copy(source);
}-*/;

}
