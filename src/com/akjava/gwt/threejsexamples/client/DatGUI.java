package com.akjava.gwt.threejsexamples.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/*
 * trying emulate dat.gui ,under construction
 */
public class DatGUI {
public DatGUI gui;

DatGUIListener listener;
Map<String,Object> values=new HashMap<String, Object>();
public DatGUI(DatGUIListener listener){
	this.gui=this;//dummy
	this.listener=listener;
}

public void put(String key,boolean value){
	values.put(key, value);
}

public boolean getBoolean(String key){
	return (Boolean)values.get(key);
}

public static void test(){
	DatGUI controls=new DatGUI(null);//listener
	//initialize with xx
	DatFolder settings = controls.gui.addFolder( "Settings" );
	settings.add( controls, "Lock Camera" ).onChange("lockCameraChanged");
	settings.add( controls, "start" );
	settings.add( controls, "idle", 0, 1, 0.01).listen().onChange( "weight" );
	settings.open();
}

public DatFolder addFolder(String name){
	return new DatFolder(name);
}

public static class DatFolder implements DatWidget{
	private String name;
	private List<DatWidget> childrens=new ArrayList<DatGUI.DatWidget>();
	private boolean opend;
	public DatFolder(String name){
		this.name=name;
	}
	public DatButton add(DatGUI datgui,String name){
		return null;
	}
	public DatRange add(DatGUI datgui,String name,double min,double max,double step){
		return null;
	}
	
	public void open(){
		opend=true;
	}
	public void close(){
		opend=false;
	}
	@Override
	public Widget createWidget() {
		VerticalPanel panel=new VerticalPanel();
		Anchor anchor=new Anchor(name);
		panel.add(anchor);
		
		final VerticalPanel childPanel=new VerticalPanel();
		panel.add(childPanel);
		childPanel.setVisible(opend);
		
		//not recursive yet.
		for(DatWidget dat:childrens){
			panel.add(dat.createWidget());
		}
		anchor.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				childPanel.setVisible(!childPanel.isVisible());
			}
		});
		
		return panel;
	}
}

public static class DatRange implements DatWidget{
	private String name;
	private DatGUI dat;
	
	public DatRange(String name,DatGUI dat){
		this.name=name;
		this.dat=dat;
	}
	
	//TODO this is more complex
	public DatRange listen(){
		//TODO support get real time value
		return this;
	}
	
	public void onChange(String key){
		//TODO this is dummy
	}

	@Override
	public Widget createWidget() {
		// TODO dummy
		return new Label(name);
	}
}

public static class DatButton implements DatWidget{
	private String key;
	private String name;
	private boolean checkbox;
	private DatGUI dat;
	public DatButton(String name,DatGUI dat){
		this.name=name;
		this.dat=dat;
	}
	public void onChange(String key){
		//change as checkbox
		this.key=key;
		checkbox=true;
	}
	@Override
	public Widget createWidget() {
		if(checkbox){
			CheckBox check= new CheckBox(name);
			check.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
				@Override
				public void onValueChange(ValueChangeEvent<Boolean> event) {
					dat.put(name, event.getValue());
					dat.listener.onChange(key);
				}
			});
			return check;
		}else{
			return new Button(name,new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					dat.listener.onChange(name);
				}
			});
		}
	}
}

public VerticalPanel getPanel(){
	//do create widget here
	
	//regist listener here
	return null;
}
public static interface DatWidget{
	public Widget createWidget();
}
public static interface DatGUIListener{
	public void onChange(String key);
}

}

