package com.blz.address_book_system.service.impl;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.IAddressBook;

public class AddressBookImpl implements IAddressBook {
	private Set<ContactDetails> contactList;
	private Map<String, Set<ContactDetails>> contactListToMap = new HashMap<String, Set<ContactDetails>>();
	ContactDetails contactDetails;
	static final Scanner SC = new Scanner(System.in);

	public ContactDetails userDataEntry(ContactDetails userContactDetails) {

		System.out.println("Enter Address Book Name ");
		userContactDetails.setAddressBookName(SC.next());
		System.out.println("Enter First Name");
		userContactDetails.setFirstName(SC.next());
		System.out.println("Enter Last Name");
		userContactDetails.setLastName(SC.next());
		System.out.println("Enter Address");
		userContactDetails.setAddress(SC.next());
		System.out.println("Enter City Name");
		userContactDetails.setCity(SC.next());
		System.out.println("Enter State Name");
		userContactDetails.setState(SC.next());
		System.out.println("Enter Email");
		userContactDetails.setEmail(SC.next());
		System.out.println("Enter Zip Code");
		userContactDetails.setZip(SC.next());
		System.out.println("Enter Phone Number");
		userContactDetails.setPhone(SC.next());
		return userContactDetails;
	}

	public void DataEntry(ContactDetails userContactDetails) {
		contactList = new HashSet<ContactDetails>();
		if (contactListToMap.get(userContactDetails.getAddressBookName()) == null) {
			System.out.println("This is New Address Book : " + userContactDetails.getAddressBookName());
			contactList.add(contactDetails);
		} else {
			contactList = contactListToMap.get(userContactDetails.getAddressBookName());
			System.out.println(
					"You are Adding Contact in Exiting Address Book : " + userContactDetails.getAddressBookName());
			contactList.add(contactDetails);
		}
		contactListToMap.put(userContactDetails.getAddressBookName(), contactList);
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
				contactDetails = new ContactDetails();
				contactDetails = userDataEntry(contactDetails);
				DataEntry(contactDetails);
			}
		} else {
			contactDetails = new ContactDetails();
			contactDetails = userDataEntry(contactDetails);
			DataEntry(contactDetails);
		}
	}
	
	public String printAddressBookName() {
		System.out.println("List Address Book Name");
		System.out.println("Key Value");
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			System.out.println(m.getKey());
		}
		System.out.println();
		System.out.println("Enter Address Book Name");
		String addressBookName = SC.next();
		return addressBookName;
	}

	@Override
	public void editContact() {
		
		String addressBookName = printAddressBookName();
		contactList = contactListToMap.get(addressBookName);
		System.out.println(contactList);
		System.out.println("Enter the Username");
		String searchName = SC.next();
		int count = 0;
		for (ContactDetails contactDetails : contactList) {
			count++;
			if (contactDetails.getFirstName() != null && contactDetails.getFirstName().contains(searchName)) {
				count = count - 1;
				System.out.println(contactDetails.toString());
				contactDetails.setAddressBookName(addressBookName);
				System.out.println("Please Enter the Same Detail or Change It");
				System.out.println("First Name is '" + contactDetails.getFirstName() + "' Edit");
				contactDetails.setFirstName(SC.next());
				System.out.println("Last Name is '" + contactDetails.getLastName() + "' Edit");
				contactDetails.setLastName(SC.next());
				System.out.println("Address is '" + contactDetails.getAddress() + "' Edit");
				contactDetails.setAddress(SC.next());
				System.out.println("City Name is '" + contactDetails.getCity() + "' Edit");
				contactDetails.setCity(SC.next());
				System.out.println("State Name is '" + contactDetails.getState() + "' Edit");
				contactDetails.setState(SC.next());
				System.out.println("Email is '" + contactDetails.getEmail() + "' Edit");
				contactDetails.setEmail(SC.next());
				System.out.println("Zip Code is '" + contactDetails.getZip() + "' Edit");
				contactDetails.setZip(SC.next());
				System.out.println("Phone Number is '" + contactDetails.getPhone() + "' Edit");
				contactDetails.setPhone(SC.next());
			}
		}
	}

	@Override
	public void deleteContact() {
		String addressBookName = printAddressBookName();
		contactList = contactListToMap.get(addressBookName);
		System.out.println("List Of Person Name");
		contactList.stream().forEach(i -> System.out.println(i.getFirstName() + " "));
		System.out.println();
		System.out.println("Enter the Username");
		String searchName = SC.next();
		for (ContactDetails contactDetails : contactList) {
			if (contactDetails.getFirstName() != null && contactDetails.getFirstName().contains(searchName)) {
				contactList.remove(contactDetails);
				break;
			}
		}
	}

	@Override
	public void displayContact() {
		System.out.println("*** *** LIST OF DETAILS *** ***");
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			System.out.println(m.getKey() + " : " + m.getValue());
		}
	}

	@Override
	public void defaultData() {
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("DYSTAR");
		contactDetails.setFirstName("Deepak");
		contactDetails.setLastName("Yadav");
		contactDetails.setAddress("EmpressThane");
		contactDetails.setCity("Thane");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("ydeepak@gmail.com");
		contactDetails.setZip("400005");
		contactDetails.setPhone("9823563242");
		contactList = new HashSet<ContactDetails>();
		contactList.add(contactDetails);
		contactListToMap.put(contactDetails.getAddressBookName(), contactList);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("DYSTAR");
		contactDetails.setFirstName("Gaurav");
		contactDetails.setLastName("Yadav");
		contactDetails.setAddress("EmpressThane");
		contactDetails.setCity("Thane");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("Gaurav@gmail.com");
		contactDetails.setZip("400005");
		contactDetails.setPhone("9823438723");
		contactList = new HashSet<ContactDetails>();
		contactList = contactListToMap.get(contactDetails.getAddressBookName());
		contactList.add(contactDetails);
		contactListToMap.put(contactDetails.getAddressBookName(), contactList);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jungle");
		contactDetails.setFirstName("Sarang");
		contactDetails.setLastName("Potpite");
		contactDetails.setAddress("Punenagar");
		contactDetails.setCity("Pune");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("ydeepak@gmail.com");
		contactDetails.setZip("564305");
		contactDetails.setPhone("9823326657");
		contactList = new HashSet<ContactDetails>();
		contactList.add(contactDetails);
		contactListToMap.put(contactDetails.getAddressBookName(), contactList);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jungle");
		contactDetails.setFirstName("Jash");
		contactDetails.setLastName("Vora");
		contactDetails.setAddress("GokulThane");
		contactDetails.setCity("Thane");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("jash@gmail.com");
		contactDetails.setZip("400105");
		contactDetails.setPhone("9823563452");
		contactList = new HashSet<ContactDetails>();
		contactList = contactListToMap.get(contactDetails.getAddressBookName());
		contactList.add(contactDetails);
		contactListToMap.put(contactDetails.getAddressBookName(), contactList);
		
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jungle");
		contactDetails.setFirstName("Jash");
		contactDetails.setLastName("Vora");
		contactDetails.setAddress("GokulThane");
		contactDetails.setCity("Thane");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("jash@gmail.com");
		contactDetails.setZip("400105");
		contactDetails.setPhone("9823563452");
		contactList = new HashSet<ContactDetails>();
		contactList = contactListToMap.get(contactDetails.getAddressBookName());
		contactList.add(contactDetails);
		contactListToMap.put(contactDetails.getAddressBookName(), contactList);
	}
}
