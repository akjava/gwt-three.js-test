package com.akjava.gwt.threetest.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Timer;

public abstract class AbstractDemo implements Demo{
	protected Timer timer;
	
	@Override
	public void stop() {
		timer.cancel();
	}
	@Override
	public void startTimer(){
		timer.scheduleRepeating(1000/60);
	}
	
	public final native void log(JavaScriptObject object)/*-{
	console.log(object);
	}-*/;

}
