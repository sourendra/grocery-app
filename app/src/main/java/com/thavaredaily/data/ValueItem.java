package com.thavaredaily.data;

import com.google.gson.annotations.SerializedName;

public class ValueItem{

	@SerializedName("offer")
	private int offer;

	@SerializedName("imageLink")
	private String imageLink;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private int id;

	@SerializedName("categoryId")
	private int categoryId;

	public void setOffer(int offer){
		this.offer = offer;
	}

	public int getOffer(){
		return offer;
	}

	public void setImageLink(String imageLink){
		this.imageLink = imageLink;
	}

	public String getImageLink(){
		return imageLink;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public int getCategoryId(){
		return categoryId;
	}

	@Override
 	public String toString(){
		return 
			"ValueItem{" + 
			"offer = '" + offer + '\'' + 
			",imageLink = '" + imageLink + '\'' + 
			",name = '" + name + '\'' + 
			",description = '" + description + '\'' + 
			",id = '" + id + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			"}";
		}
}