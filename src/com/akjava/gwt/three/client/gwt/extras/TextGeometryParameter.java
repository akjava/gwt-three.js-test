package com.akjava.gwt.three.client.gwt.extras;

import com.akjava.gwt.three.client.gwt.JSParameter;

public class TextGeometryParameter extends JSParameter{
		protected TextGeometryParameter(){}
		public final static TextGeometryParameter create(){
			return (TextGeometryParameter) TextGeometryParameter.createObject();
		}
		
		public final native TextGeometryParameter size(double size)/*-{
		this.size=size;
		return this;
		}-*/;

	public final native TextGeometryParameter height(double height)/*-{
		this.height=height;
		return this;
		}-*/;

	public final native TextGeometryParameter curveSegments(double curveSegments)/*-{
		this.curveSegments=curveSegments;
		return this;
		}-*/;

	public final native TextGeometryParameter font(String font)/*-{
		this.font=font;
		return this;
		}-*/;

	public final native TextGeometryParameter weight(String weight)/*-{
		this.weight=weight;
		return this;
		}-*/;

	public final native TextGeometryParameter style(String style)/*-{
		this.style=style;
		return this;
		}-*/;

	public final native TextGeometryParameter bevelThickness(double bevelThickness)/*-{
		this.bevelThickness=bevelThickness;
		return this;
		}-*/;

	public final native TextGeometryParameter bevelSize(double bevelSize)/*-{
		this.bevelSize=bevelSize;
		return this;
		}-*/;

	public final native TextGeometryParameter bevelEnabled(boolean bevelEnabled)/*-{
		this.bevelEnabled=bevelEnabled;
		return this;
		}-*/;


		
}
