package com.blz.address_book_system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.IAddressBook;

public class AddressBookImpl implements IAddressBook{
	static String firstName,lastName,address,city,state,email,zip,phone;
	static List<ContactDetails> contactList=new ArrayList<ContactDetails>();
	ContactDetails contactDetails;
	static final Scanner SC=new Scanner(System.in);
	@Override
	public void addContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter First Name");
		firstName=SC.nextLine();
		System.out.println("Enter Second Name");
		lastName=SC.nextLine();
		System.out.println("Enter Address");
		address=SC.nextLine();
		System.out.println("Enter City Name");
		city=SC.nextLine();
		System.out.println("Enter State Name");
		state=SC.nextLine();
		System.out.println("Enter Email");
		email=SC.nextLine();
		System.out.println("Enter Zip Code");
		zip=SC.nextLine();
		System.out.println("Enter Phone Number");
		phone=SC.nextLine();
		contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
		System.out.println(contactDetails);
		contactList.add(contactDetails);
		for (int i = 0; i < contactList.size(); i++)
          System.out.print(contactList.get(i) + " ");
	}
//	@Override
//	public void editContact() {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void deleteContact() {
//		// TODO Auto-generated method stub
//		
//	}
}
