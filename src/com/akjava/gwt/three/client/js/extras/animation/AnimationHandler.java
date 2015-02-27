package com.akjava.gwt.three.client.js.extras.animation;

import com.akjava.gwt.three.client.gwt.animation.AnimationData;
import com.akjava.gwt.three.client.gwt.animation.AnimationHierarchyItem;
import com.akjava.gwt.three.client.js.core.Object3D;
import com.google.gwt.core.client.JsArray;

public class AnimationHandler {




	/**
	 * @deprecated
	 * on r68 dropped
	 */
	public final native Animation remove(String name)/*-{
	return $wnd.THREE.AnimationHandler.remove(name);
	}-*/;

	/**
	 * @deprecated
	 * on r68 changed
	 */
	public final native Animation get(String name)/*-{
	return $wnd.THREE.AnimationHandler.init(name);
	}-*/;
	
	public final native Animation init(String name)/*-{
	return $wnd.THREE.AnimationHandler.init(name);
	}-*/;

	
	public final native JsArray<AnimationHierarchyItem> parse(Object3D root)/*-{
	return $wnd.THREE.AnimationHandler.parse(root);
	}-*/;
	
	
	public static native final void update(double delta)/*-{
	return $wnd.THREE.AnimationHandler.update(delta);
	}-*/;
	
	/**
	 * @deprecated
	 * on r68 dropped
	 */
	public static native final void add(AnimationData data)/*-{
	return $wnd.THREE.AnimationHandler.add(data);
	}-*/;
	/**
	 * @deprecated
	 * on r68 renamed
	 */
	public static native final void removeFromUpdate(Animation data)/*-{
	return $wnd.THREE.AnimationHandler.stop(data);
	}-*/;
	/**
	 * @deprecated
	 * on r68 renamed
	 */
	public static native final void addToUpdate(Animation data)/*-{
	return $wnd.THREE.AnimationHandler.play(data);
	}-*/;
	
	public static native final void stop(Animation data)/*-{
	return $wnd.THREE.AnimationHandler.stop(data);
	}-*/;
	
	public static native final void play(Animation data)/*-{
	return $wnd.THREE.AnimationHandler.play(data);
	}-*/;
	
	
	
	
}
