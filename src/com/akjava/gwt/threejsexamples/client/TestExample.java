package com.akjava.gwt.threejsexamples.client;

import com.akjava.gwt.lib.client.LogUtils;
import com.google.gwt.user.client.ui.Label;

/*
 * just for test example
 */
public class TestExample extends AbstractExample{
private String name;

public TestExample(String name) {
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
