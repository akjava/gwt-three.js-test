/*
 * Copyright (C) 2011 aki@akjava.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.akjava.gwt.threetest.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;


public class ThreeTest implements EntryPoint {
	

	private MainWidget main;

	/**
	 * This is the entry point method.
	 */
public void onModuleLoad() {
	History.addValueChangeHandler(new ValueChangeHandler<String>() {
		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			//maybe renderer changed
			createMain();
		}
	});
	createMain();
	}
private void createMain(){
	if(main!=null){
		main.stop();
		RootPanel.get("MAIN").remove(main);
	}
	main = new MainWidget();
	RootPanel.get("MAIN").add(main);
}

}
