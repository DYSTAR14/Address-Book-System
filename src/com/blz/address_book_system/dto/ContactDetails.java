package com.blz.address_book_system.dto;

import java.util.Objects;


public class ContactDetails {
	private String addressBookName;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String email;
	private String zip;
	private String phone;

	
	@Override
	public int hashCode() {
		return Objects.hash(firstName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactDetails other = (ContactDetails) obj;
		return Objects.equals(firstName, other.firstName);
	}
	
	
	public void setAddressBookName(String addressBookName) {
		this.addressBookName=addressBookName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddressBookName() {
		return addressBookName;
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
		return "addressBookName=" + addressBookName + " : [firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", city=" + city + ", state=" + state + ", email=" + email
				+ ", zip=" + zip + ", phone=" + phone + "]";
	}
	
	public String personDetails() {
		return "FirstName=" + firstName + ", LastName="+lastName + ", Address=" + address + ", City=" 
				+ city + ", State=" + state + ", Email=" + email+ ", Zip=" + zip + ", Phone=" + phone;
	}
}
