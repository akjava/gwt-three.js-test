package com.akjava.gwt.three.client.extras.animation;

import com.akjava.gwt.three.client.gwt.animation.AnimationData;

public class AnimationHandler {

	
	public static native final void update(double delta)/*-{
	return $wnd.THREE.AnimationHandler.update(delta);
	}-*/;
	
	public static native final void add(AnimationData data)/*-{
	return $wnd.THREE.AnimationHandler.add(data);
	}-*/;
	
}
