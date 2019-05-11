package com.cts.dinein.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dinein.model.Cart;
import com.cts.dinein.model.Item;
import com.cts.dinein.model.Ordered;
import com.cts.dinein.repository.CartRepository;
import com.cts.dinein.repository.ItemRepository;
import com.cts.dinein.repository.OrderedRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private OrderedRepository orderedRepository;
	
	@Transactional
	public List<Item> allItemList(){
		
		List<Item> itemList = new ArrayList<>();
		itemList = itemRepository.findAll();
		return itemList;	
	}
	
	public void addItemToCart(Integer itemId, Integer quantity){
		Item item = itemRepository.findByItemId(itemId);
		System.out.println(item);
		Cart cart = new Cart(itemId,item.getName(),item.getPrice(),quantity);
		item.setQuantity(item.getQuantity()-quantity);
		cartRepository.save(cart);
		itemRepository.save(item);
		cart = cartRepository.findByItemId(itemId);
		System.out.println(cart);
		
		
	}
	
	public List<Cart> fetchCartItem(){
		List<Cart> cartItem = new ArrayList<>();
		for(Cart cart : cartRepository.findAll()){
			cartItem.add(cart);
		}
		return cartItem;
	}
	
	public void saveItems(){

			itemRepository.save(new Item(1,"Chicken Butter Masala",20,180,"chicken butter masala.jpg"));
			itemRepository.save(new Item(2,"Momo",70,45,"momo.jpg"));
			itemRepository.save(new Item(3,"Burger",80,128,"Burger.jpg"));
			itemRepository.save(new Item(4,"Chicken Wings",120,340,"chickenwings.jpg"));
			itemRepository.save(new Item(5,"Pizza",230,299,"pizza.jpg"));
			itemRepository.save(new Item(6,"Ice Cream",420,85,"ice.jpg"));
			itemRepository.save(new Item(7,"Tandoori",140,180,"Tandoori.jpg"));
			
	}

	@Override
	public void removeCartItem(Integer cartId) {
		
		Cart cart = cartRepository.findByCartId(cartId);
		Integer itemId = cart.getItemId();
		Item item = itemRepository.findByItemId(itemId);
		item.setQuantity(item.getQuantity()+cart.getQuantity());
		cartRepository.delete(cart);
		itemRepository.save(item);
		
	}

	@Override
	public Integer costCalculation() {
		
		Integer totalCost = 0;
		List<Cart> cartList = new ArrayList<>();
		cartList = cartRepository.findAll();
		
		for(Cart cart:cartList){
			totalCost = totalCost + (cart.getPrice()*cart.getQuantity());
		}
		
		return totalCost;
	}

	@Override
	public void updateCartItem(Integer cartId, Integer cartQuantity) {
		
		Cart cart = cartRepository.findByCartId(cartId);
		cart.setQuantity(cartQuantity);
		cartRepository.save(cart);
	}

	@Override
	public void orderPlaced() {
		List<Cart> cartList = cartRepository.findAll();
		
		for(Cart cart:cartList){
			System.out.println(cart);
			Ordered ordered = new Ordered(cart.getItemId(),cart.getName(),cart.getPrice(),cart.getQuantity());
			System.out.println(ordered);
			orderedRepository.save(ordered);
			cartRepository.delete(cart);
		}
	}
	
}
