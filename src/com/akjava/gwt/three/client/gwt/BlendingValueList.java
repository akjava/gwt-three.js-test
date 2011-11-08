package com.akjava.gwt.three.client.gwt;

import java.io.IOException;

import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.ValueListBox;

public class BlendingValueList extends ValueListBox<BlendingValue> {

	public BlendingValueList(){
		super(new BlendingRenderer());
		setValue(BlendingValue.values.get(0));
		setAcceptableValues(BlendingValue.values);
	}

	public static class BlendingRenderer implements Renderer<BlendingValue>{
	@Override
	public String render(BlendingValue object) {
		return object.getLabel();
	}

	@Override
	public void render(BlendingValue object, Appendable appendable)
			throws IOException {
	}
	
	}
	
}
