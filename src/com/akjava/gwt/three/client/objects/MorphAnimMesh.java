package com.akjava.gwt.three.client.objects;


public class MorphAnimMesh extends Mesh{
	protected MorphAnimMesh(){}
	

public final native double getDuration()/*-{
return this.duration;
}-*/;

public final native void setDuration(double duration)/*-{
this.duration = duration;
}-*/;


public final native boolean isMirroredLoop()/*-{
return this.mirroredLoop;
}-*/;




public final native double getTime()/*-{
return this.time;
}-*/;

public final native void setTime(double time)/*-{
this.time = time;
}-*/;

//internal value
public final native double getLastKeyframe()/*-{
return this.lastKeyframe;
}-*/;
//internal value
public final native void setLastKeyframe(double lastKeyframe)/*-{
this.lastKeyframe = lastKeyframe;
}-*/;

//internal value
public final native double getCurrentKeyframe()/*-{
return this.currentKeyframe;
}-*/;
//internal value
public final native void setCurrentKeyframe(double currentKeyframe)/*-{
this.currentKeyframe = currentKeyframe;
}-*/;

//internal value
public final native double getDirection()/*-{
return this.direction;
}-*/;
//internal value
public final native void setDirection(double direction)/*-{
this.direction = direction;
}-*/;

//internal value
public final native boolean isDirectionBackwards()/*-{
return this.directionBackwards;
}-*/;
//internal value
public final native void setDirectionBackwards(boolean directionBackwards)/*-{
this.directionBackwards = directionBackwards;
}-*/;

public final native void setFrameRange(int start,int end)/*-{
this.setFrameRange(start,end);
}-*/;

public final native void setDirectionForward()/*-{
this.setDirectionForward();
}-*/;

public final native void setDirectionBackward()/*-{
this.setDirectionBackward();
}-*/;

public final native void parseAnimations()/*-{
this.parseAnimations();
}-*/;

public final native void setAnimationLabel(String label,int start,int end)/*-{
this.setAnimationLabel(label,start,end);
}-*/;

public final native void playAnimation(String label,double fps)/*-{
this.playAnimation(label,fps);
}-*/;

public final native void updateAnimation(double delta)/*-{
this.updateAnimation(delta);
}-*/;

public final native MorphAnimMesh clone(MorphAnimMesh object)/*-{
return this.clone(object);
}-*/;

	
	
	


	public final native void setMirroredLoop(boolean mirroredLoop)/*-{
	this.mirroredLoop=mirroredLoop;
	}-*/;
	
	
	

}
