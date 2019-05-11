package com.cts.dinein.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	private Integer itemId;
	
	private String name;
	private Integer quantity;
	private Integer price;
	private String imageUrl;
	
	public Item(){};
	
	public Item(Integer itemId, String name, Integer quantity, Integer price, String imageUrl) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", imageUrl=" + imageUrl + "]";
	}
	
}
