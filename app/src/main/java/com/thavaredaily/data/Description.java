package com.thavaredaily.data;

import com.google.gson.annotations.SerializedName;

public class Description{

	@SerializedName("sellerName")
	private String sellerName;

	@SerializedName("itemProperties")
	private String itemProperties;

	@SerializedName("disclaimer")
	private String disclaimer;

	public void setSellerName(String sellerName){
		this.sellerName = sellerName;
	}

	public String getSellerName(){
		return sellerName;
	}

	public void setItemProperties(String itemProperties){
		this.itemProperties = itemProperties;
	}

	public String getItemProperties(){
		return itemProperties;
	}

	public void setDisclaimer(String disclaimer){
		this.disclaimer = disclaimer;
	}

	public String getDisclaimer(){
		return disclaimer;
	}

	@Override
 	public String toString(){
		return 
			"Description{" + 
			"sellerName = '" + sellerName + '\'' + 
			",itemProperties = '" + itemProperties + '\'' + 
			",disclaimer = '" + disclaimer + '\'' + 
			"}";
		}
}