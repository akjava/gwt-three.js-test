package com.akjava.gwt.three.client.objects;


public class MorphAnimMesh extends Mesh{
	protected MorphAnimMesh(){}
	
	public final native void updateAnimation(double delta)/*-{	
	this.updateAnimation(delta);
	}-*/;

	public final native void setDuration(int time)/*-{
	this.duration=time;
	}-*/;
	
	public final native void setTime(int time)/*-{
	this.time=time;
	}-*/;
	public final native void setMirrordLoop(boolean mirroredLoop)/*-{
	this.mirroredLoop=mirroredLoop;
	}-*/;
}
