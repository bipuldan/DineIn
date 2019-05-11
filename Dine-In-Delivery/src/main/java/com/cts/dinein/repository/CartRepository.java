package com.cts.dinein.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.dinein.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	public Cart findByItemId(Integer itemId);
	
	public Cart findByCartId(Integer cartId);

}
