package com.akjava.gwt.three.client.gwt.ui;

import java.util.HashMap;
import java.util.Map;

import com.akjava.gwt.html5.client.input.Range;
import com.akjava.gwt.lib.client.LogUtils;
import com.akjava.gwt.lib.client.widget.EnterKeySupportTextBox;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class LabeledInputRangeWidget2 extends HorizontalPanel{
	
		private Range range;
		private TextBox textBox;
		public TextBox getTextBox() {
			return textBox;
		}
		private Map<ValueChangeHandler<Number>,HandlerRegistration> registMap=new HashMap<ValueChangeHandler<Number>, HandlerRegistration>();
		private Label label;
		public Label getLabel() {
			return label;
		}
		public LabeledInputRangeWidget2(String name,Number min,Number max,Number step){
			this.setVerticalAlignment(ALIGN_MIDDLE);
			label = new Label(name);
			label.setAutoHorizontalAlignment(ALIGN_CENTER);
			label.setWidth("120px");
			add(label);
			range = new Range(name,min,max,step);
			range.setWidth("140px");
			add(range);
			textBox = new EnterKeySupportTextBox() {
				@Override
				public void onEnterKeyDown() {
					
					double value=Double.valueOf(textBox.getValue());
					range.setValue(value,true);
					
				}
			};
			//textBox.setEnabled(true);
			textBox.setWidth("40px");
			add(textBox);
			textBox.setValue(String.valueOf(range.getValue()));
			range.addValueChangeHandler(new ValueChangeHandler<Number>() {

				@Override
				public void onValueChange(ValueChangeEvent<Number> event) {
					
					setTextBoxText(String.valueOf(event.getValue()));
				}
				
			});
			
			//textBox.setReadOnly(true);//not yet
		}
		public Range getRange() {
			return range;
		}
		public void setTextBoxText(String value){
		int min=5;
		if(value.startsWith("-")){
			min=6;
		}
		value=value.substring(0, Math.min(min, value.length()));//limit text
		textBox.setValue(value);
		}
		public void setValue(double value){
			setTextBoxText(String.valueOf(value));
			range.setValue(value);
		}
		public void setValue(double value,boolean fire){
			setTextBoxText(String.valueOf(value));
			range.setValue(value,fire);
		} 
		public double getValue(){
			return (Double) range.getValue();
		}
		
		public void addtRangeListener(ValueChangeHandler<Number> handler){
			HandlerRegistration regist=range.addValueChangeHandler(handler);
			registMap.put(handler,regist);
		}
		public void removeRangeListener(ValueChangeHandler<Number> handler){
			if(registMap.get(handler)!=null){
				registMap.get(handler).removeHandler();
			}
		}
		
		//TODO make style
		public void setEnabled(boolean enabled) {
			this.range.setEnabled(enabled);
			if(enabled){
				label.getElement().getStyle().setColor("#000");
			}else{
				label.getElement().getStyle().setColor("#888");
			}
		}
		
		/*now range set .point value.
		public int parseDivided(Number value){
			if(value instanceof Integer){
				return 1;
			}else{
				String v=String.valueOf(value);
				int s=v.indexOf(".");
				if(s==-1){
					return 1;
				}
				
				return (int)Math.pow(10, v.length()-s);
			}
		}*/
	}