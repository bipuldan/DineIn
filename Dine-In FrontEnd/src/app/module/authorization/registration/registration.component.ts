import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  newUser= new User();
  message:string;
  alert:boolean=true;
  constructor(private authService: AuthenticationService,
              private router: Router) {}

  ngOnInit() {
  }

  submitRegisterationForm(registerationForm: NgForm){
    this.newUser=registerationForm.value;
    console.log("Register User data:", this.newUser);
    this.authService.registerUser(this.newUser).subscribe(data => {
      console.log("User registered", data);
      this.router.navigate(['/login']);
    },
    error => {
        if(error="User with email already exists"){
          this.message="User is already registered";
            setTimeout(function(){
        this.alert=false;
      }.bind(this),3000);
        }
        console.log(this.message);
      });

    

  }

}
