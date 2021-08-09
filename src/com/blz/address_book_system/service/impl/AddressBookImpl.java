package com.blz.address_book_system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.IAddressBook;

public class AddressBookImpl implements IAddressBook {
	static String firstName, lastName, address, city, state, email, zip, phone;
	static List<ContactDetails> contactList = new ArrayList<ContactDetails>();
	ContactDetails contactDetails;
	static final Scanner SC = new Scanner(System.in);

	@Override
	public void addContact() {
		System.out.println("Enter First Name");
		firstName = SC.next();
		System.out.println("Enter Second Name");
		lastName = SC.next();
		System.out.println("Enter Address");
		address = SC.next();
		System.out.println("Enter City Name");
		city = SC.next();
		System.out.println("Enter State Name");
		state = SC.next();
		System.out.println("Enter Email");
		email = SC.next();
		System.out.println("Enter Zip Code");
		zip = SC.next();
		System.out.println("Enter Phone Number");
		phone = SC.next();
		contactDetails = new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
		System.out.println(contactDetails);
		firstName=SC.next();
		System.out.println("Enter Second Name");
		lastName=SC.next();
		System.out.println("Enter Address");
		address=SC.next();
		System.out.println("Enter City Name");
		city=SC.next();
		System.out.println("Enter State Name");
		state=SC.next();
		System.out.println("Enter Email");
		email=SC.next();
		System.out.println("Enter Zip Code");
		zip=SC.next();
		System.out.println("Enter Phone Number");
		phone=SC.next();
		contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
		contactList.add(contactDetails);
		System.out.println("*** *** LIST OF DETAILS *** ***");
		for (int i = 0; i < contactList.size(); i++)
			System.out.println(contactList.get(i) + " ");
	}

	@Override
	public void editContact() {
		System.out.println("Enter the Username");
		String searchName=SC.next();
		int count=0;
		for (ContactDetails user :contactList ) {
			count++;
			if(user.getFirstName()!=null && user.getFirstName().contains(searchName)) {
				count=count-1;
				System.out.println(user.toString());
				System.out.println("Please Enter the Same Detail or Change It");
				System.out.println("First Name is '"+user.getFirstName()+"' Edit");
				firstName=SC.next();
				System.out.println("Second Name is '"+user.getLastName()+"' Edit");
				lastName=SC.next();
				System.out.println("Address is '"+user.getAddress()+"' Edit");
				address=SC.next();
				System.out.println("City Name is '"+user.getCity()+"' Edit");
				city=SC.next();
				System.out.println("State Name is '"+user.getState()+"' Edit");
				state=SC.next();
				System.out.println("Email is '"+user.getEmail()+"' Edit");
				email=SC.next();
				System.out.println("Zip Code is '"+user.getZip()+"' Edit");
				zip=SC.next();
				System.out.println("Phone Number is '"+user.getPhone()+"' Edit");
				phone=SC.next();
				contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
				contactList.set(count,contactDetails);
				System.out.println("*** *** LIST OF DETAILS *** ***");
				for (int j = 0; j < contactList.size(); j++) {
					System.out.println(contactList.get(j) + " ");
				}
				break;
			}
		}
	}
	@Override
	public void deleteContact() {
		System.out.println("List Of Person Name");
		for (ContactDetails i :contactList ) {
	          System.out.println(i.getFirstName() + " ");
		}
		System.out.println();
		System.out.println("Enter the Username");
		String searchName=SC.next();
		int count=0;
		for (ContactDetails user :contactList ) {
			count++;
			if(user.getFirstName()!=null && user.getFirstName().contains(searchName)) {
				count=count-1;
				contactList.remove(count);
				break;
			}
		}
		System.out.println("*** *** LIST OF DETAILS *** ***");
		for (int j = 0; j < contactList.size(); j++) {
			System.out.println(contactList.get(j) + " ");
		} 
	}
}
