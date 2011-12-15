package com.akjava.gwt.three.client.gwt;

public class Clock {
private long last=System.currentTimeMillis();

public long delta(){
	long c=System.currentTimeMillis();
	long delta= c-last;
	last=c;
	return delta;
}
public void update(){
	last=System.currentTimeMillis();
}

}
