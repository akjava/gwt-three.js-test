package com.akjava.gwt.threedemos.client;

import com.akjava.gwt.lib.client.LogUtils;
import com.google.gwt.user.client.ui.Label;

public class TestDemo extends AbstractDemo{
private String name;

public TestDemo(String name) {
	super();
	this.name = name;
}

@Override
public void animate(double timestamp) {
	LogUtils.log("animate:"+name+","+timestamp);
}

@Override
public void init() {
	parent.add(new Label(name));
	LogUtils.log("init:"+name);
}

@Override
public String getName() {
	return name;
}

@Override
public void onWindowResize() {
	// TODO Auto-generated method stub
	
}



}
