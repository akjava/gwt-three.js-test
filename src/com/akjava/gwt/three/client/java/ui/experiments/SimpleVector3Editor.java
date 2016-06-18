package com.akjava.gwt.three.client.java.ui.experiments;

import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Vector3;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class SimpleVector3Editor extends HorizontalPanel {
	private Vector3 value;
	private DoubleBox xEditor;
	private DoubleBox yEditor;
	private DoubleBox zEditor;
	public Vector3 getValue() {
		return value;
	}
	public void copyWithToDegree(Vector3 newData,boolean fireListener){
		if(value==null){
			return;
		}
		xEditor.setValue(Math.toDegrees(newData.getX()));
		yEditor.setValue(Math.toDegrees(newData.getY()));
		zEditor.setValue(Math.toDegrees(newData.getZ()));
		
		value.setX(xEditor.getValue());
		value.setY(yEditor.getValue());
		value.setZ(zEditor.getValue());
		
		if(fireListener){//fire or not
			flush();
		}
	}
	public void copy(Vector3 newData,boolean fireListener){
		if(value==null){
			return;
		}
		xEditor.setValue(newData.getX());
		yEditor.setValue(newData.getY());
		zEditor.setValue(newData.getZ());
		
		value.setX(xEditor.getValue());
		value.setY(yEditor.getValue());
		value.setZ(zEditor.getValue());
		
		if(fireListener){//fire or not
			flush();
		}
	}
	public void setValue(Vector3 value) {
		this.value = value;
		if(value==null){
			xEditor.setEnabled(false);
			yEditor.setEnabled(false);
			zEditor.setEnabled(false);
			return;
		}else{
			xEditor.setEnabled(true);
			yEditor.setEnabled(true);
			zEditor.setEnabled(true);
		}
		xEditor.setValue(value.getX());
		yEditor.setValue(value.getY());
		zEditor.setValue(value.getZ());

	}
	
	private SimpleVector3EditorListener listener;
	
	public void setListener(SimpleVector3EditorListener listener) {
		this.listener = listener;
	}
	
	/*
	 * even if make true Editor-framework,need listenre if you'd like to dynamic change instead of Update button's update
	 */
	public SimpleVector3Editor(SimpleVector3EditorListener listener){
		this.listener=listener;
		this.value=THREE.Vector3();
		this.add(new Label("X:"));
		xEditor = new DoubleBox();
		xEditor.setWidth("80px");
		xEditor.addValueChangeHandler(new ValueChangeHandler<Double>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Double> event) {
				flush();
			}
		});
		this.add(xEditor);
		
		this.add(new Label("Y:"));
		yEditor = new DoubleBox();
		yEditor.addValueChangeHandler(new ValueChangeHandler<Double>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Double> event) {
				flush();
			}
		});
		yEditor.setWidth("80px");
		this.add(yEditor);
		
		
		this.add(new Label("Z:"));
		zEditor = new DoubleBox();
		zEditor.addValueChangeHandler(new ValueChangeHandler<Double>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<Double> event) {
				flush();
			}
		});
		zEditor.setWidth("80px");
		this.add(zEditor);
	}
	protected void flush() {
		if(value==null){
			return;
		}
		
		value.setX(xEditor.getValue());
		value.setY(yEditor.getValue());
		value.setZ(zEditor.getValue());

		if(listener!=null){
			listener.onValueChanged(value);
		}
	}
	

	public static interface SimpleVector3EditorListener{
		public void onValueChanged(Vector3 value);
	}
	
}
