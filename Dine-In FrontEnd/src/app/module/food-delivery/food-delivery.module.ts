import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';  
import { WelcomeComponent } from './welcome/welcome.component';
import { CartComponent } from './cart/cart.component';
import { FoodDeliveryRouterModule } from './food-delivery-router.module';

@NgModule({
  declarations: [
    WelcomeComponent,
    CartComponent],

  imports: [
    HttpClientModule,
    CommonModule,
    FormsModule,
    CommonModule,
    BrowserModule,
    FoodDeliveryRouterModule
  ],
  providers: [],
  exports: [FoodDeliveryRouterModule]
})
export class FoodDeliveryModule { }
