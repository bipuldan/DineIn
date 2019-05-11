import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';  
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {RegistrationComponent} from './registration/registration.component';
import {LoginComponent} from './login/login.component';
import {AuthenticationRouterModule} from './authentication-router.module';
import {AuthenticationService} from './authentication.service';

@NgModule({
  imports: [
    HttpClientModule,
    AuthenticationRouterModule,
    FormsModule,
    CommonModule,
    BrowserModule
  ],
  declarations: [
    RegistrationComponent,
    LoginComponent
  ],
  providers: [AuthenticationService],
  exports: [
    AuthenticationRouterModule
  ]
})
export class AuthenticationModule { }
