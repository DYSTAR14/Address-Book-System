package com.blz.address_book_system.dto;

public class ContactDetails {
	private final String firstName, lastName, address, city, state, email, zip, phone;

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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getEmail() {
		return email;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}
	@Override
	public String toString() {
		return "Address_Book [firstName=" + firstName + ", lastName=" + lastName + ",\n address=" + address + ", city="
				+ city + ", state=" + state + ",\n email=" + email + ", zip=" + zip + ", phone=" + phone + "]\n";
	}
}
