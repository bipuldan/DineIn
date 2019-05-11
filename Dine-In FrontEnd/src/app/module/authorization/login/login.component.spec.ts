import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import {AuthenticationService} from '../authentication.service';
import { Router } from '@angular/router';

import { Location } from '@angular/common';
import { of } from 'rxjs';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';


const testConfig = {
  userData: {
     firstname: 'testFirstname',
     lastname: 'testLastname',
     dob: 'testDob',
     city: 'testCity',
     phone: 'testPhone',
     zipcode: 'testZipcode',
     email: 'testEmail',
     password: 'testPassword'
  }
}


fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authservice:AuthenticationService;
  let spyUser:any;
  let routes:Router;
  let location:Location;

  class AuthServiceStub{
    currentUser:any;

    constructor(){

    }
    login(credentials) {
      if(credentials.email==testConfig.userData.email)
      {
        console.log(this.currentUser);
        return of(credentials.email)
      }
      else{
        return of(false);
      }
    }
  }
  class dummy {

  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports:[FormsModule,HttpClientModule,RouterTestingModule.withRoutes([{path: '', component: dummy}])],
      providers:[{provide:AuthenticationService,useClass:AuthServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    routes = TestBed.get(Router);
    location = TestBed.get(Location);
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    fixture.debugElement.injector.get(AuthenticationService);
  });

  it('should create app component',async( () => {
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

  it('should contain two input box for userName and password', () => {
    let userName=fixture.debugElement.query(By.css('#email'));
    let password = fixture.debugElement.query(By.css('#password'));
    let userButton = fixture.debugElement.query(By.css('#loginButton'));
    let userNameInput=userName.nativeElement;
    let passwordInput = password.nativeElement;
    let userButtonInput = userButton.nativeElement;
    expect(userNameInput).toBeTruthy();
    expect(passwordInput).toBeTruthy();
    expect(userButtonInput).toBeTruthy();
  });

  it('should redirect to login if registered successfully', async(() => {
    let userName=fixture.debugElement.query(By.css('#email'));
    let password = fixture.debugElement.query(By.css('#password'));
    let userButton = fixture.debugElement.query(By.css('#loginButton'));
    let userNameInput = userName.nativeElement;
    let passwordInput = password.nativeElement;
    let userButtonInput = userButton.nativeElement;
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      userNameInput.value = 'testuser';
      passwordInput.value = 'testpass';
      userNameInput.dispatchEvent(new Event('inptut'));
      passwordInput.dispatchEvent(new Event('inptut'));
      userButtonInput.click();
    }).then(() => {
      expect(location.path()).toBe('');
    });
  }));



  })
