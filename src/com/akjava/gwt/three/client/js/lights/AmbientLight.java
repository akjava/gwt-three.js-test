package com.akjava.gwt.three.client.js.lights;

public class AmbientLight extends Light{
protected AmbientLight(){}

public final native AmbientLight copy(AmbientLight source)/*-{
return this.copy(source);
}-*/;
}
