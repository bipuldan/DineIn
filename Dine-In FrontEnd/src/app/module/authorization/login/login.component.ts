import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from '../user';
import { AuthenticationService } from '../authentication.service';
import { Router } from '@angular/router';


@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
	user = new User();

	constructor(private authService: AuthenticationService, private router: Router) { }

	ngOnInit() {
	}
	onFormSubmit(loginForm: NgForm) {
		this.user=loginForm.value;
		console.log("Login user", this.user);
		this.authService.loginUser(this.user).subscribe(data => {
			console.log("Login successful");
			if (data['token']) {
				this.authService.setToken(data['token']);
				this.router.navigate(['/welcome']);
			}

		});

	}
}
