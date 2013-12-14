package com.akjava.gwt.three.client.js.extras.animation;

import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.animation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.core.client.JsArray;

public class AnimationHandler {







	public final native Animation get(String name)/*-{
	return $wnd.THREE.AnimationHandler.get(name);
	}-*/;

	
	public final native JsArray<AnimationHierarchyItem> parse(Object3D root)/*-{
	return $wnd.THREE.AnimationHandler.parse(root);
	}-*/;
	
	
	public static native final void update(double delta)/*-{
	return $wnd.THREE.AnimationHandler.update(delta);
	}-*/;
	
	public static native final void add(AnimationData data)/*-{
	return $wnd.THREE.AnimationHandler.add(data);
	}-*/;
	public static native final void removeFromUpdate(Animation data)/*-{
	return $wnd.THREE.AnimationHandler.removeFromUpdate(data);
	}-*/;
	public static native final void addToUpdate(Animation data)/*-{
	return $wnd.THREE.AnimationHandler.addToUpdate(data);
	}-*/;
}
