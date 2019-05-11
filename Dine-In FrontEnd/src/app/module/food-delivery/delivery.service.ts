import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

   deliveryServiceEndpoint:string = "http://localhost:8088";

    constructor(private http: HttpClient) { }

  fetchItem():Observable<any> {
    const url = `${this.deliveryServiceEndpoint}/fetchItem`;
    return this.http.get(url);
  }

  addItem(itemId,quantity): Observable<any>{
    const url = `${this.deliveryServiceEndpoint}/addItem/${itemId}/${quantity}`;
    return this.http.post(url, itemId, {responseType: 'text'});
  }

  fetchcart():Observable<any>{
    const url = `${this.deliveryServiceEndpoint}/cartItem`;
    return this.http.get(url);
  }

  removeCartItem(cartId):Observable<any>{
    const url = `${this.deliveryServiceEndpoint}/removeCartItem/${cartId}`;
    return this.http.post(url, cartId, {responseType: 'text'});
  }

  cartCost():Observable<any>{
    const url = `${this.deliveryServiceEndpoint}/cartCost`;
    return this.http.get(url);
  }

  updateCartItem(cartId,cartQuantity):Observable<any>{
    const url = `${this.deliveryServiceEndpoint}/updateCartItem/${cartId}/${cartQuantity}`;
    return this.http.post(url, cartId, {responseType: 'text'});
  }

  orderPlaced():Observable<any>{
    const url = `${this.deliveryServiceEndpoint}/orderPlaced`;
    return this.http.get(url);
  }
}
