package com.blz.address_book_system.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.IAddressBook;

public class AddressBookImpl implements IAddressBook {
	private List<ContactDetails> contactList;
	private HashMap<String, List<ContactDetails>> contactListToMap = new HashMap<String, List<ContactDetails>>();
	private String addressBookName, firstName, lastName, address, city, state, email, zip, phone;
	ContactDetails contactDetails;
	static final Scanner SC = new Scanner(System.in);

	public void newDataEntry(String addressBookName, String firstName, String lastName, String address, String city,
			String state, String email, String zip, String phone) {
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName(addressBookName);
		contactDetails.setFirstName(firstName);
		contactDetails.setLastName(lastName);
		contactDetails.setAddress(address);
		contactDetails.setCity(city);
		contactDetails.setState(state);
		contactDetails.setEmail(email);
		contactDetails.setZip(zip);
		contactDetails.setPhone(phone);
		contactList = new ArrayList<ContactDetails>();
		contactList.add(contactDetails);
		contactListToMap.put(addressBookName, contactList);
		System.out.println("*** *** LIST OF DETAILS *** ***");
		System.out.println("HashMap\n" + contactListToMap);
	}

	public void exitDataEntry(String addressBookName, String firstName, String lastName, String address, String city,
			String state, String email, String zip, String phone) {
		contactDetails = new ContactDetails();
		contactDetails.setFirstName(firstName);
		contactDetails.setLastName(lastName);
		contactDetails.setAddress(address);
		contactDetails.setCity(city);
		contactDetails.setState(state);
		contactDetails.setEmail(email);
		contactDetails.setZip(zip);
		contactDetails.setPhone(phone);
		contactList = new ArrayList<ContactDetails>();
		contactList = contactListToMap.get(addressBookName);
		contactList.add(contactDetails);
		contactListToMap.put(addressBookName, contactList);
		System.out.println("*** *** LIST OF DETAILS *** ***");
		System.out.println("HashMap\n" + contactListToMap);
	}

	@Override
	public void addContact() {
		char option = 'n';
		System.out.println("You Want to Add in Existing Address Book (y/n)");
		option = SC.next().charAt(0);
		if (option == 'Y' || option == 'y') {
			if (contactListToMap.isEmpty()) {
				System.out.println("DIC is Empty");
			} else {

				System.out.println("List Address Book Name");
				System.out.println("Key Value");
				for (HashMap.Entry m : contactListToMap.entrySet()) {
					System.out.println(m.getKey());
				}
				System.out.println();
				System.out.println("Enter Address Book Name");
				addressBookName = SC.next();
				System.out.println("Enter First Name");
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
				System.out.println(contactListToMap.get(addressBookName));
				exitDataEntry(addressBookName, firstName, lastName, address, city, state, email, zip, phone);
			}
		} else {
			System.out.println("Enter Address Book Name");
			addressBookName=SC.next();
			System.out.println("Enter First Name");
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
			newDataEntry(addressBookName, firstName, lastName, address, city, state, email, zip, phone);
		}
	}

	@Override
	public void editContact() {
		System.out.println("List Address Book Name");
		System.out.println("Key Value");
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			System.out.println(m.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		addressBookName = SC.next();
		contactList = new ArrayList<ContactDetails>();
		contactList = contactListToMap.get(addressBookName);
		System.out.println(contactList);
		System.out.println("Enter the Username");
		String searchName = SC.next();
		int count = 0;
		for (ContactDetails user : contactList) {
			count++;
			if (user.getFirstName() != null && user.getFirstName().contains(searchName)) {
				count = count - 1;
				System.out.println(user.toString());
				System.out.println("Please Enter the Same Detail or Change It");
				System.out.println("First Name is '" + user.getFirstName() + "' Edit");
				firstName = SC.next();
				System.out.println("Second Name is '" + user.getLastName() + "' Edit");
				lastName = SC.next();
				System.out.println("Address is '" + user.getAddress() + "' Edit");
				address = SC.next();
				System.out.println("City Name is '" + user.getCity() + "' Edit");
				city = SC.next();
				System.out.println("State Name is '" + user.getState() + "' Edit");
				state = SC.next();
				System.out.println("Email is '" + user.getEmail() + "' Edit");
				email = SC.next();
				System.out.println("Zip Code is '" + user.getZip() + "' Edit");
				zip = SC.next();
				System.out.println("Phone Number is '" + user.getPhone() + "' Edit");
				phone = SC.next();
				contactDetails = new ContactDetails();
				contactDetails.setAddressBookName(addressBookName);
				contactDetails.setFirstName(firstName);
				contactDetails.setLastName(lastName);
				contactDetails.setAddress(address);
				contactDetails.setCity(city);
				contactDetails.setState(state);
				contactDetails.setEmail(email);
				contactDetails.setZip(zip);
				contactDetails.setPhone(phone);
				contactList.set(count, contactDetails);
				System.out.println("*** *** LIST OF DETAILS *** ***");
				contactListToMap.put(addressBookName, contactList);
				System.out.println("HashMap\n" + contactListToMap);
			}
		}
	}
	@Override
	public void deleteContact() {
		System.out.println("List Address Book Name");
		System.out.println("Key Value");
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			System.out.println(m.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		addressBookName = SC.next();
		contactList = new ArrayList<ContactDetails>();
		contactList = contactListToMap.get(addressBookName);
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
		contactListToMap.put(addressBookName, contactList);
		System.out.println("*** *** LIST OF DETAILS *** ***");
		System.out.println("HashMap\n" + contactListToMap);
	}
}
