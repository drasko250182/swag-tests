package com.tudor.swag.tests.utils;

import java.util.List;

public class Column {
	
	public enum Name {
	    CURRENT_VALUE("Current Value");
		
		private String uiName;
		 
		Name(String uiName) {
	        this.uiName = uiName;
	    }
	 
	    public String getuiName() {
	        return uiName;
	    }
	}

	private String name;
	private List<Cell> values;
	private List<String> stringValues;
	private Name by;
	
	public Column (String name, List<Cell> values) {
		this.setName(name);
		this.setValues(values);
	}
	
//	public Column (By by, List<Cell> values) {
//		this.setBy(by);
//		this.setValues(values);
//	}
	
	public Column (Name by, List<String> stringValues) {
		this.setBy(by);
		this.setStringValues(stringValues);
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Cell> getValues() {
		return values;
	}
	
	public void setValues(List<Cell> values) {
		this.values = values;
	}

	public Name getBy() {
		return by;
	}

	public void setBy(Name by) {
		this.by = by;
	}

	public List<String> getStringValues() {
		return stringValues;
	}

	public void setStringValues(List<String> stringValues) {
		this.stringValues = stringValues;
	}
	
	
}
