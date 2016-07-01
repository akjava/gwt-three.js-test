package com.akjava.gwt.three.client.java.ui.experiments;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import javax.annotation.Nullable;

import com.akjava.gwt.three.client.gwt.ui.LabeledInputRangeWidget2;
import com.akjava.gwt.three.client.js.THREE;
import com.akjava.gwt.three.client.js.math.Vector4;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Vector4Editor extends Composite implements Editor<Vector4>,ValueAwareEditor<Vector4>  , HasValueChangeHandlers<Vector4>, HasValue<Vector4>{
	private Vector4 resetValue;	
	
	private List<String> labels=Lists.newArrayList("X","Y","Z","W");
	private List<LabeledInputRangeWidget2> rangeList=Lists.newArrayList();
	public List<LabeledInputRangeWidget2> getRangeList() {
		return rangeList;
	}
	private List<RangeChangeButtons> buttonsList=Lists.newArrayList();
	private Vector4 value;

	private Button resetAllButton;

	public Button getResetAllButton() {
		return resetAllButton;
	}
	private Label nameLabel;
		
	private void updateResetLabel(){
		String label= "Reset "+Joiner.on("-").join(labels);
		resetAllButton.setText(label);
	}
	private void setLabel(int index,String label){
		labels.set(index, label);
		
		rangeList.get(index).getLabel().setText(label);
		
		updateResetLabel();
	}
	public void setLabelX(String label){
		setLabel(0,label);
	}
	public void setLabelY(String label){
		setLabel(1,label);
	}
	public void setLabelZ(String label){
		setLabel(2,label);
	}
	public void setLabelW(String label){
		setLabel(3,label);
	}
	
	

	/*
	 * not fire means not update value
	 */
	public void setX(double value,boolean fire){
		rangeList.get(0).setValue(value,fire);
	}
	public void setY(double value,boolean fire){
		rangeList.get(1).setValue(value,fire);
	}
	public void setZ(double value,boolean fire){
		rangeList.get(2).setValue(value,fire);
	}
	public void setW(double value,boolean fire){
		rangeList.get(3).setValue(value,fire);
	}
	
	public double getX(){
		return getValue().getX();
	}
	public double getY(){
		return getValue().getY();
	}
	public double getZ(){
		return getValue().getZ();
	}
	public double getW(){
		return getValue().getW();
	}
		public Vector4 getValue() {
			return value;
		}
		
		public Vector4Editor(String name,double min,double max,double step,double resetValue){
			this(name,THREE.Vector4().setScalar(min),
					THREE.Vector4().setScalar(max),
					THREE.Vector4().setScalar(step),
					THREE.Vector4().setScalar(resetValue)
					);
		}
		public Vector4Editor(String name,Vector4 min,Vector4 max,Vector4 step,Vector4 resetValue){
			checkNotNull(min,"Vector4Editor:min is null");
			checkNotNull(max,"Vector4Editor:max is null");
			checkNotNull(step,"Vector4Editor:step is null");
			checkNotNull(resetValue,"Vector4Editor:reset is null");
			this.resetValue=resetValue;
			VerticalPanel panel=new VerticalPanel();
			
			HorizontalPanel h1=new HorizontalPanel();
			panel.add(h1);
			h1.setSpacing(4);
			h1.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);
			nameLabel = new Label(name);
			nameLabel.setWidth("120px");
			h1.add(nameLabel);
			
			resetAllButton = new Button();
			resetAllButton.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					resetValue();
				}
			});
			h1.add(resetAllButton);
			updateResetLabel();
			
			for(int i=0;i<4;i++){
				LabeledInputRangeWidget2 range = new LabeledInputRangeWidget2(labels.get(i), min.gwtGet(i), max.gwtGet(i), step.gwtGet(i));
				panel.add(range);
				range.addtRangeListener(new ValueChangeHandler<Number>() {
					@Override
					public void onValueChange(ValueChangeEvent<Number> event) {
						flush();
					}
				});
				range.getLabel().setWidth("40px");
				range.getRange().setWidth("220px");
				rangeList.add(range);
				
				List<Double> buttonValues=Lists.newArrayList();
				double v=step.gwtGet(i);
				for(int j=0;j<3;j++){
					buttonValues.add(v);
					v*=10;
				}
				RangeChangeButtons buttons=new RangeChangeButtons(range,buttonValues,resetValue.gwtGet(i));
				panel.add(buttons);
				buttonsList.add(buttons);
			}
			initWidget(panel);
			setValue(resetValue.clone());
		}
		
		public void setEnabled(boolean enabled){
			for(RangeChangeButtons bt:buttonsList){
				bt.setEnabled(enabled);
			}
			for(LabeledInputRangeWidget2 range:rangeList){
				range.setEnabled(enabled);
			}
		}
		
		public static class RangeChangeButtons extends HorizontalPanel{
			
			private Button resetButton;
			private List<Button> buttons=Lists.newArrayList();
			public void setEnabled(boolean enabled){
				resetButton.setEnabled(enabled);
				for(Button bt:buttons){
					bt.setEnabled(enabled);
				}
			}
			public RangeChangeButtons(final LabeledInputRangeWidget2 range,List<Double> values,final double resetValue) {
				super();
				
				
				for(int i=values.size()-1;i>=0;i--){
					final Double v=values.get(i);
					Button bt=new Button("-"+String.valueOf(v),new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							double value=range.getValue();
							value-=v;
							if(value<range.getRange().getMin()){
								value=range.getRange().getMin();
							}
							range.setValue(value,true);
						}
					});
					this.add(bt);
					buttons.add(bt);
				}
				for(final Double v:values){
					Button bt=new Button(String.valueOf(v),new ClickHandler() {
						
						@Override
						public void onClick(ClickEvent event) {
							double value=range.getValue();
							value+=v;
							if(value>range.getRange().getMax()){
								value=range.getRange().getMax();
							}
							range.setValue(value,true);
						}
					});
					this.add(bt);
					buttons.add(bt);
				}
				
				resetButton = new Button("Reset",new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						range.setValue(resetValue,true);
					}
				});
				this.add(resetButton);
				
			}
			
		}
		
			public void resetValue() {
				 for(int i=0;i<4;i++){
					rangeList.get(i).setValue(resetValue.gwtGet(i));
				 }
			flush();
			}

			@Override
			public void setDelegate(EditorDelegate<Vector4> delegate) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void flush() {
				 for(int i=0;i<4;i++){
					 value.gwtSet(i, rangeList.get(i).getValue());
				 }
				  ValueChangeEvent.fire(this, getValue());
			}

			@Override
			public void onPropertyChange(String... paths) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setValue(@Nullable Vector4 value) {
				this.value=value;
				if(value==null){
					//set disable
					return;
				}else{
					//set enable
				}
				for(int i=0;i<4;i++){
					rangeList.get(i).setValue(value.gwtGet(i));
				}
			}
			@Override
			public void setValue(Vector4 value, boolean fireEvents) {
				setValue(value);
				 if (fireEvents) {
			            ValueChangeEvent.fire(this, getValue());
			        }
			}
			@Override
			public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Vector4> handler) {
				 return addHandler(handler, ValueChangeEvent.getType());
			}
	}