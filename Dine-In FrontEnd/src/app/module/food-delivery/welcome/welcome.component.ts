import { Component, OnInit } from '@angular/core';
import { DeliveryService } from '../delivery.service';
import { Item } from '../Item';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  itemQuantity: Array<Number>;
  foodList: Array<any>;
  quantity: any;
  constructor(private deliveryService: DeliveryService) { this.itemQuantity = new Array<Number>(); }
  
  ngOnInit() {
    this.deliveryService.fetchItem().subscribe(data =>{this.foodList = data});
  }

  onOrderClick(itemId: number, itemQuantityAvailable:number){
    console.log(itemId);
    this.quantity = this.itemQuantity[itemId];
    console.log(this.quantity);
    if((itemQuantityAvailable-this.quantity)>=0){
    this.deliveryService.addItem(itemId, this.quantity).subscribe(data =>{
      alert(data)
    , this.ngOnInit();});
    }
    else{
      alert("Your ordered quantity is more than availabality");
    }
  }
}
