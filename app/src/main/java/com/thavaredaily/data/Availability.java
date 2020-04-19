package com.thavaredaily.data;

import com.google.gson.annotations.SerializedName;

public class Availability{

	@SerializedName("unit")
	private String unit;

	@SerializedName("available")
	private String available;

	@SerializedName("value")
	private int value;

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setAvailable(String available){
		this.available = available;
	}

	public String getAvailable(){
		return available;
	}

	public void setValue(int value){
		this.value = value;
	}

	public int getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Availability{" + 
			"unit = '" + unit + '\'' + 
			",available = '" + available + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}