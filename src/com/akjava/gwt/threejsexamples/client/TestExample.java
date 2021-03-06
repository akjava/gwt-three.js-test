package com.akjava.gwt.threejsexamples.client;

import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.three.client.java.ui.example.AbstractExample;
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
	
}

@Override
public String getName() {
	return name;
}

@Override
public void onWindowResize() {
	// TODO Auto-generated method stub
	
}


@Override
public String getTokenKey() {
	return "test";
}

}
