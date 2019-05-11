package com.cts.dinein.services;

import java.util.List;

import com.cts.dinein.model.Cart;
import com.cts.dinein.model.Item;

public interface DeliveryService {
	
	public void saveItems();
	
	public List<Item> allItemList();
	
	public void addItemToCart(Integer itemId, Integer quantity);
	
	public List<Cart> fetchCartItem();
	
	public void removeCartItem(Integer cartId);
	
	public void updateCartItem(Integer cartId, Integer cartQuantity);
	
	public Integer costCalculation();
	
	public void orderPlaced();
}
