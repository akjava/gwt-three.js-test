package com.akjava.gwt.three.client.gwt;

import java.util.Arrays;
import java.util.List;

public  class MaterialTypeValue{
	public static final MaterialTypeValue BASIC=new MaterialTypeValue(0,"Basic");
	public static final MaterialTypeValue LAMBERT=new MaterialTypeValue(1,"Lambert");
				public static final MaterialTypeValue PHONG=new MaterialTypeValue(2,"Phong");
						public static final MaterialTypeValue NORMAL_MAP=new MaterialTypeValue(3,"Normal-map");
								public static final MaterialTypeValue NORMAL_MAP_PLUS=new MaterialTypeValue(4,"Normal-map+D");

		private int value;
		private String label;
	
		public MaterialTypeValue(int value,String label){
			this.value=value;
			this.label=label;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof MaterialTypeValue){
				return ((MaterialTypeValue)obj).getValue()==getValue();
			}
			return super.equals(obj);
		}
		
	}