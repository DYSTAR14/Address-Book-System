package com.blz.address_book_system.dto;

public class ContactDetails {
	private final String firstName,lastName,address,city,state,email,zip,phone;
	public ContactDetails(String firstName, String lastName, String address, String city, String state, String email,
			String zip, String phone) {
				this.firstName = firstName;
				this.lastName = lastName;
				this.address = address;
				this.city = city;
				this.state = state;
				this.email = email;
				this.zip = zip;
				this.phone = phone;
	}
	@Override
	public String toString() {
		return "Address_Book [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", email=" + email + ", zip=" + zip + ", phone=" + phone + "]";
	}
}
