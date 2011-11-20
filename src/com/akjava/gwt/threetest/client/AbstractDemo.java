package com.akjava.gwt.threetest.client;

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

}
