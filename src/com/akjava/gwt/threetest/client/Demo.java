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

import com.akjava.gwt.three.client.js.renderers.WebGLRenderer;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.Widget;

public interface Demo {
	public void start(WebGLRenderer renderer,int width,int height,FocusPanel panel);
	public void stop();
	public void clearHandlerRegistration();
	public String getName();
	public void startTimer(Timer timer);
	public String getHowToHtml();
	public Widget getControler();
	public boolean isSupportCanvas();
	public boolean isSupportWebGL();
	public boolean isSupportCSS3D();
}
