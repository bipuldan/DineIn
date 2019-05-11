import { Component, OnInit } from '@angular/core';
import { DeliveryService } from '../delivery.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItem : Array<any>;
  itemQuantity: Array<Number>;
  cartQuantity: number;
  cartId : number;
  cartCost : number;
  constructor(private deliveryService : DeliveryService , private router : Router) { this.itemQuantity = new Array<Number>(); }

  ngOnInit() {
    this.deliveryService.fetchcart().subscribe(data => {this.cartItem=data,
      console.log(data)}
      );

    this.deliveryService.cartCost().subscribe(data =>{this.cartCost = data});
  }

  remove(i){
    console.log(i);
    this.cartId = this.cartItem[i].cartId;
    this.cartItem.splice(i, 1);
    this.deliveryService.removeCartItem(this.cartId).subscribe
    (data =>{console.log(data), this.ngOnInit();});
  }

  increase(cartQuantity:number,cartId:number){
    if((cartQuantity+1)<=5){
      this.cartQuantity = cartQuantity+1;
    } 
    this.deliveryService.updateCartItem(cartId,this.cartQuantity).subscribe
    (data=>{console.log(data) ,this.ngOnInit();});
    console.log(this.cartQuantity,cartId);
  }

  decrease(cartQuantity:number,cartId:number){
    if((cartQuantity-1)>=0){
      this.cartQuantity = cartQuantity-1;
    }
    this.deliveryService.updateCartItem(cartId,this.cartQuantity).subscribe
    (data=>{console.log(data) ,this.ngOnInit();});
    console.log(this.cartQuantity,cartId);
  }

  proceed(){
    alert("your order is placed. Be with us :)");
    this.deliveryService.orderPlaced().subscribe();
    this.router.navigate(['/welcome']);
  }
}
