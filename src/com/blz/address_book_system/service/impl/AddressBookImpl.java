package com.blz.address_book_system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.IAddressBook;

public class AddressBookImpl implements IAddressBook{
	static String firstName,lastName,address,city,state,email,zip,phone;
	static public List<ContactDetails> contactList=new ArrayList<ContactDetails>();
	ContactDetails contactDetails;
	static final Scanner SC=new Scanner(System.in);
	@Override
	public void addContact() {
		// TODO Auto-generated method stub
//		System.out.println("Enter First Name");
//		firstName=SC.nextLine();
//		System.out.println("Enter Second Name");
//		lastName=SC.nextLine();
//		System.out.println("Enter Address");
//		address=SC.nextLine();
//		System.out.println("Enter City Name");
//		city=SC.nextLine();
//		System.out.println("Enter State Name");
//		state=SC.nextLine();
//		System.out.println("Enter Email");
//		email=SC.nextLine();
//		System.out.println("Enter Zip Code");
//		zip=SC.nextLine();
//		System.out.println("Enter Phone Number");
//		phone=SC.nextLine();
		firstName="Deepak";lastName="Yadav";address="Empress Thane";city="Thane";state="Maharashtra";
		email="ydeepak@gmail.com";zip = "400005";phone="9823563242";
		contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
//		System.out.println(contactDetails);
		contactList.add(contactDetails);

		firstName="Sarang";lastName="Potpite";address="Pune nagar";city="Pune";state="Maharashtra";
		email="sarang@gmail.com";zip = "564305";phone="9823326657";
		contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
//		System.out.println(contactDetails);
		contactList.add(contactDetails);
		
		firstName="Gaurav";lastName="Yadav";address="Empress Thane";city="Thane";state="Maharashtra";
		email="Gaurav@gmail.com";zip = "400005";phone="9823565436";
		contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
//		System.out.println(contactDetails);
		contactList.add(contactDetails);
		
		firstName="Ronak";lastName="Jain";address="Gokul Nagar";city="Thane";state="Maharashtra";
		email="Ronak@gmail.com";zip = "400005";phone="9825674567";
		contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
//		System.out.println(contactDetails);
		contactList.add(contactDetails);
		System.out.println("*** *** LIST OF DETAILS *** ***");
		for (int i = 0; i < contactList.size(); i++)
          System.out.println(contactList.get(i) + " ");
	}
	@Override
	public void editContact() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Username");
		String searchName=SC.nextLine();
		int count=0;
		for (ContactDetails user :contactList ) {
			count++;
			if(user.getFirstName()!=null && user.getFirstName().contains(searchName)) {
				//System.out.println(i.getFirstName() + " ");
				count=count-1;
				System.out.println(user.toString());
//				System.out.println(contactList.get(count));
				System.out.println("Please Enter the Same Detail or Change It");
				System.out.println("First Name is '"+user.getFirstName()+"' Edit");
				firstName=SC.nextLine();
				System.out.println("Second Name is '"+user.getLastName()+"' Edit");
				lastName=SC.nextLine();
				System.out.println("Address is '"+user.getAddress()+"' Edit");
				address=SC.nextLine();
				System.out.println("City Name is '"+user.getCity()+"' Edit");
				city=SC.nextLine();
				System.out.println("State Name is '"+user.getState()+"' Edit");
				state=SC.nextLine();
				System.out.println("Email is '"+user.getEmail()+"' Edit");
				email=SC.nextLine();
				System.out.println("Zip Code is '"+user.getZip()+"' Edit");
				zip=SC.nextLine();
				System.out.println("Phone Number is '"+user.getPhone()+"' Edit");
				phone=SC.nextLine();
				contactDetails=new ContactDetails(firstName, lastName, address, city, state, email, zip, phone);
//				System.out.println(contactDetails);
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
		// TODO Auto-generated method stub
		System.out.println("List Of Person Name");
		for (ContactDetails i :contactList ) {
	          System.out.println(i.getFirstName() + " ");
		}
		System.out.println();
		System.out.println("Enter the Username");
		String searchName=SC.nextLine();
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
