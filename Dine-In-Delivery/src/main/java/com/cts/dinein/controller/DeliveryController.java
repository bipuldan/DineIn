package com.cts.dinein.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dinein.model.Cart;
import com.cts.dinein.model.Item;
import com.cts.dinein.services.DeliveryServiceImpl;

@RestController
@CrossOrigin
public class DeliveryController {

	@Autowired
	private DeliveryServiceImpl deliveryServiceImpl;
	
	/*@RequestMapping("/")
	private String fill(){
		deliveryServiceImpl.saveItems();
		return "success";
	}*/
		
	@GetMapping("/fetchItem")
	public ResponseEntity<?> getMyItems(final HttpServletRequest request, final HttpServletResponse response) {
		
		/*final String authHeader = request.getHeader("authorization");
		final String token = authHeader.substring(7);
		String email = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().getSubject();*/
		
		List<Item> itemList = deliveryServiceImpl.allItemList();
		ResponseEntity<?> responseEntity = new ResponseEntity<List<Item>>(itemList, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("addItem/{itemId}/{quantity}")
	public ResponseEntity<?> addItemToCart(@PathVariable("itemId") Integer itemId, @PathVariable("quantity") Integer quantity){
		ResponseEntity<?> responseEntity;
		System.out.println(itemId + " " + quantity);
		try {
			deliveryServiceImpl.addItemToCart(itemId,quantity);
			responseEntity = new ResponseEntity<String>("Successfully Added", HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;

	}
	
	@GetMapping("/cartItem")
	public ResponseEntity<?> fetchCartItem(){
		ResponseEntity<?> responseEntity;
		try {
			List<Cart> cartItem = deliveryServiceImpl.fetchCartItem();
			for(Cart cart:cartItem)
				System.out.println(cart);
			responseEntity = new ResponseEntity<List<Cart>>( cartItem, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@PostMapping("removeCartItem/{cartId}")
	public ResponseEntity<?> removeCartItem(@PathVariable("cartId") Integer cartId){
		ResponseEntity<?> responseEntity;
		try {
			System.out.println(cartId);
			deliveryServiceImpl.removeCartItem(cartId);
			responseEntity = new ResponseEntity<String>( "Successfully removed", HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@GetMapping("cartCost")
	public ResponseEntity<?> cartCost(){
		ResponseEntity<?> responseEntity;
		try{
			Integer totalCost = deliveryServiceImpl.costCalculation();
			responseEntity = new ResponseEntity<Integer>(totalCost, HttpStatus.OK);
		}
		catch(Exception e){
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@PostMapping("updateCartItem/{cartId}/{cartQuantity}")
	public ResponseEntity<?> updateCartItem(@PathVariable("cartId") Integer cartId, @PathVariable("cartQuantity")Integer cartQuantity){
		ResponseEntity<?> responseEntity;
		try {
			System.out.println(cartId);
			deliveryServiceImpl.updateCartItem(cartId, cartQuantity);
			responseEntity = new ResponseEntity<String>( "Successfully removed", HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@GetMapping("orderPlaced")
	public ResponseEntity<?> orderPlaced(){
		ResponseEntity<?> responseEntity;
		try{
			deliveryServiceImpl.orderPlaced();
			System.out.println("Order Placed");
			responseEntity = new ResponseEntity<String>("Order Placed", HttpStatus.OK);
		}
		catch(Exception e){
			System.out.println("Order not Placed");
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
