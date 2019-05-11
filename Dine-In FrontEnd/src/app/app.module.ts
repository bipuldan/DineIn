import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes, Router } from '@angular/router';
import { AppComponent } from './app.component';
import {AuthenticationModule} from './module/authorization/authentication.module';
import {FoodDeliveryModule} from './module/food-delivery/food-delivery.module';
import { HttpClientModule } from '@angular/common/http';
import { AuthGuardService } from './auth.guard';

const appRoute: Routes =[
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AuthenticationModule,
    FoodDeliveryModule,
      HttpClientModule,
      RouterModule.forRoot(appRoute)
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule {}
