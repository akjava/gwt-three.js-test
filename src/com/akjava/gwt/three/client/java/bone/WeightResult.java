package com.akjava.gwt.three.client.java.bone;

import java.util.List;

import com.akjava.gwt.three.client.java.ThreeLog;
import com.akjava.gwt.three.client.js.core.Geometry;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.JsArray;

public   class WeightResult{
	JsArray<Vector4> bodyIndices;
	private int influence;
	public int getInfluence() {
		return influence;
	}
	public WeightResult setInfluence(int influence) {
		this.influence = influence;
		return this;
	}
	public WeightResult(JsArray<Vector4> bodyIndices, JsArray<Vector4> bodyWeight) {
		super();
		this.bodyIndices = bodyIndices;
		this.bodyWeight = bodyWeight;
	}
	public JsArray<Vector4> getBodyIndices() {
		return bodyIndices;
	}
	public void setBodyIndices(JsArray<Vector4> bodyIndices) {
		this.bodyIndices = bodyIndices;
	}
	
	JsArray<Vector4> bodyWeight;
	public JsArray<Vector4> getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(JsArray<Vector4> bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public void insertToGeometry(Geometry geometry){
		geometry.setSkinIndices(this.getBodyIndices());
		geometry.setSkinWeights(this.getBodyWeight());
		if(influence!=0){
			geometry.gwtSetInfluencesPerVertex(influence);
		}
	}
	
	@Override
	public String toString(){
		List<String> lines=Lists.newArrayList();
		for(int i=0;i<getBodyIndices().length();i++){
			String indices=ThreeLog.get(getBodyIndices().get(i));
			String weights=ThreeLog.get(getBodyWeight().get(i));
			lines.add(indices+"="+weights);
		}
		return "WeightResult:{\n"+Joiner.on("\n").join(lines)+"\n}";
	}
}