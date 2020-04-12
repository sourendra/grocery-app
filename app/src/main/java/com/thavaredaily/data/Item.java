package com.thavaredaily.data;

public class Item {
    int id;
    String itemName;
    String itemSubName;
    String itemActualPrice;
    String itemCurrentPrice;
    String itemImagePath;
    int itemCount;

    public Item(int id, String itemName, String itemSubName, String itemActualPrice, String itemCurrentPrice, String itemImagePath, int itemCount) {
        this.id = id;
        this.itemName = itemName;
        this.itemSubName = itemSubName;
        this.itemActualPrice = itemActualPrice;
        this.itemCurrentPrice = itemCurrentPrice;
        this.itemImagePath = itemImagePath;
        this.itemCount = itemCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSubName() {
        return itemSubName;
    }

    public void setItemSubName(String itemSubName) {
        this.itemSubName = itemSubName;
    }

    public String getItemActualPrice() {
        return itemActualPrice;
    }

    public void setItemActualPrice(String itemActualPrice) {
        this.itemActualPrice = itemActualPrice;
    }

    public String getItemCurrentPrice() {
        return itemCurrentPrice;
    }

    public void setItemCurrentPrice(String itemCurrentPrice) {
        this.itemCurrentPrice = itemCurrentPrice;
    }

    public String getItemImagePath() {
        return itemImagePath;
    }

    public void setItemImagePath(String itemImagePath) {
        this.itemImagePath = itemImagePath;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
}
