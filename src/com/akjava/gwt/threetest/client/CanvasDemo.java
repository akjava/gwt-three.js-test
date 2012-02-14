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

import com.akjava.gwt.lib.client.ExportUtils;
import com.akjava.gwt.three.client.renderers.WebGLRenderer;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.FocusPanel;

public class CanvasDemo extends AbstractDemo{
private Timer timer;
	@Override
	public void start(final WebGLRenderer renderer,final int width,final int height,FocusPanel panel) {
		Canvas canvas=Canvas.createIfSupported();
		canvas.getContext2d().strokeText("hello", 50, 50);
		String url=canvas.toDataUrl();
		ExportUtils.openTabAbsoluteURLImage(url, "test");
	}


	@Override
	public String getName() {
		return "Sphere";
	}

}
