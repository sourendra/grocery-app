package com.thavaredaily.data;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ItemsForCategoryResponse{

	@SerializedName("value")
	private List<ValueItem> value;

	@SerializedName("returnType")
	private String returnType;

	public void setValue(List<ValueItem> value){
		this.value = value;
	}

	public List<ValueItem> getValue(){
		return value;
	}

	public void setReturnType(String returnType){
		this.returnType = returnType;
	}

	public String getReturnType(){
		return returnType;
	}

	@Override
 	public String toString(){
		return 
			"ItemsForCategoryResponse{" + 
			"value = '" + value + '\'' + 
			",returnType = '" + returnType + '\'' + 
			"}";
		}
}