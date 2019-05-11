package com.dinein.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String firstname;
	private String lastname;
	private String dob;
	private String city;
	private String phone;
	private String zipcode;
	private String email;
	private String password;
	
	public User(){}
	

	public User(String firstname, String lastname, String dob, String city, String phone, String zipcode, String email,
			String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.city = city;
		this.phone = phone;
		this.zipcode = zipcode;
		this.email = email;
		this.password = password;
	}
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob + ", city=" + city
				+ ", phone=" + phone + ", zipcode=" + zipcode + ", email=" + email + ", password=" + password + "]";
	}
	
}
