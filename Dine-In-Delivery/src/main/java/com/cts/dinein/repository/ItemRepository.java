package com.cts.dinein.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.dinein.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	public Item findByItemId(Integer itemId);
}
