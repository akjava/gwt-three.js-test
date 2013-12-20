package com.akjava.gwt.three.client.java;

import java.io.IOException;

import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.ValueListBox;

public class MaterialTypeValueList extends ValueListBox<MaterialTypeValue> {

	public MaterialTypeValueList(){
		super(new BlendingRenderer());
		setValue(MaterialTypeValue.LAMBERT);
		//setAcceptableValues(BlendingValue.values);
	}

	public static class BlendingRenderer implements Renderer<MaterialTypeValue>{
	@Override
	public String render(MaterialTypeValue object) {
		return object.getLabel();
	}

	@Override
	public void render(MaterialTypeValue object, Appendable appendable)
			throws IOException {
	}
	
	}
	
}
