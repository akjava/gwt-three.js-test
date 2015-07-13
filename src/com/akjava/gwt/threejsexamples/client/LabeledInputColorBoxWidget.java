package com.akjava.gwt.threejsexamples.client;

import java.util.HashMap;
import java.util.Map;

import com.akjava.gwt.html5.client.input.ColorBox;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;

public class LabeledInputColorBoxWidget extends HorizontalPanel{
	
		private ColorBox colorBox;
		private TextBox textBox;
		private Map<ValueChangeHandler<String>,HandlerRegistration> registMap=new HashMap<ValueChangeHandler<String>, HandlerRegistration>();
		public LabeledInputColorBoxWidget(String name){
			this.setVerticalAlignment(ALIGN_MIDDLE);
			Label label=new Label(name);
			label.setAutoHorizontalAlignment(ALIGN_CENTER);
			label.setWidth("120px");
			add(label);
			colorBox = new ColorBox(name);
			colorBox.setWidth("80px");
			add(colorBox);
			textBox = new TextBox();
			textBox.setEnabled(true);
			textBox.setWidth("100px");
			add(textBox);
			textBox.setValue(String.valueOf(colorBox.getValue()));
			colorBox.addValueChangeHandler(new ValueChangeHandler<String>() {

				@Override
				public void onValueChange(ValueChangeEvent<String> event) {
					
					setTextBoxText(String.valueOf(event.getValue()));
				}
				
			});
			
			textBox.setReadOnly(true);//not yet
		}
		public void setTextBoxText(String value){
		
		textBox.setValue(value);
		}
		public void setValue(String value){
			setTextBoxText(String.valueOf(value));
			colorBox.setValue(value);
		} 
		public String getValue(){
			return  colorBox.getValue();
		}
		
		public void addListener(ValueChangeHandler<String> handler){
			HandlerRegistration regist=colorBox.addValueChangeHandler(handler);
			registMap.put(handler,regist);
		}
		public void removeListener(ValueChangeHandler<String> handler){
			if(registMap.get(handler)!=null){
				registMap.get(handler).removeHandler();
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