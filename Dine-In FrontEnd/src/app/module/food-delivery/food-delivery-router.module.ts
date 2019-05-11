import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import {WelcomeComponent} from './welcome/welcome.component';
import {CartComponent} from './cart/cart.component';
import { AuthGuardService } from '../../auth.guard';


const foodeliveryrouter: Routes = [
 {path:'welcome', component: WelcomeComponent, canActivate:[AuthGuardService]},
 {path:'cart', component: CartComponent, canActivate:[AuthGuardService]}
];


@NgModule({
  imports: [
    RouterModule.forChild(foodeliveryrouter)
  ],
  exports: [
    RouterModule
  ]

})
export class FoodDeliveryRouterModule { }