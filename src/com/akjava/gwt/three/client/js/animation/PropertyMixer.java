package com.akjava.gwt.three.client.js.animation;

import com.google.gwt.core.client.JavaScriptObject;

public class PropertyMixer extends JavaScriptObject{
	protected PropertyMixer(){}
	


	public final  native PropertyBinding getBinding()/*-{
	return this.binding;
	}-*/;



	public final  native int getValueSize()/*-{
	return this.valueSize;
	}-*/;

	/**
	 * default Float64ArrayNative
	 * @return
	 */
	public final  native JavaScriptObject getBuffer()/*-{
	return this.buffer;
	}-*/;



	public final  native double getCumulativeWeight()/*-{
	return this.cumulativeWeight;
	}-*/;



	public final  native int getUseCount()/*-{
	return this.useCount;
	}-*/;



	public final  native int getReferenceCount()/*-{
	return this.referenceCount;
	}-*/;

	


	public final  native void accumulate(int accuIndex,double weight)/*-{
	this.accumulate(accuIndex, weight);
	}-*/;
	


	public final  native void apply(int accuIndex)/*-{
	this.apply(accuIndex);
	}-*/;
	


	public final  native void saveOriginalState()/*-{
	this.saveOriginalState();
	}-*/;
	


	public final  native void restoreOriginalState()/*-{
	this.restoreOriginalState();
	}-*/;
	


}
