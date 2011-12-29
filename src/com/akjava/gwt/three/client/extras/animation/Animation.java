package com.akjava.gwt.three.client.extras.animation;

import com.google.gwt.core.client.JavaScriptObject;

public class Animation extends JavaScriptObject{
protected Animation(){}

public native final void play()/*-{
this.play();
}-*/;

public native final void play(boolean loop,double startTime)/*-{
this.play(loop,startTime);
}-*/;


public native final double getCurrentTime()/*-{
return this.currentTime;
}-*/;

public native final void setCurrentTime(double currentTime)/*-{
return this.currentTime=currentTime;
}-*/;

}
