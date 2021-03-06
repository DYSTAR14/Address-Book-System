package com.blz.address_book_system.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.Formatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.IAddressBook;

public class AddressBookImpl implements IAddressBook {
	public Set<ContactDetails> contactList;
	public static Map<String, Set<ContactDetails>> contactListToMap = new HashMap<String, Set<ContactDetails>>();
	ContactDetails contactDetails;
	static final Scanner SC = new Scanner(System.in);
	public static Map<String, Set<ContactDetails>> cityMap = new HashMap<String, Set<ContactDetails>>();
	public static Map<String, Set<ContactDetails>> stateMap = new HashMap<String, Set<ContactDetails>>();

	public ContactDetails userDataEntry(ContactDetails userContactDetails) {
		System.out.println("Enter Address Book Name ");
		userContactDetails.setAddressBookName(SC.next());
		System.out.println("Enter First Name");
		userContactDetails.setFirstName(SC.next());
		System.out.println("Enter Last Name");
		userContactDetails.setLastName(SC.next());
		System.out.println("Enter Address");
		userContactDetails.setAddress(SC.nextLine());
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
			contactList.add(userContactDetails);
		} else {
			contactList = contactListToMap.get(userContactDetails.getAddressBookName());
			System.out.println(
					"You are Adding Contact in Exiting Address Book : " + userContactDetails.getAddressBookName());
			contactList.add(userContactDetails);
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
		personByCity();
		personByState();
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
		System.out.println("List Of Person Name");
		contactList.stream().forEach(i -> System.out.println(i.getFirstName() + " "));
		System.out.println();
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
				contactDetails.setAddress(SC.nextLine());
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
		contactListToMap.entrySet()
		.stream().forEach(m -> {System.out.println(m.getKey() + " : " + m.getValue());System.out.println();});
		
	}

	@Override
	public void displayContactCityStatePerson() {
		Formatter fmt = new Formatter();  
		fmt.format("%15s %15s %15s\n", "City", "State", "Person");  
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			contactList = contactListToMap.get(m.getKey());
			for (ContactDetails contactDetails : contactList) {
				fmt.format("%15s %15s %15s\n", contactDetails.getCity(), contactDetails.getState(), contactDetails.getFirstName());  
			}
		}
		System.out.println(fmt);  
	}

	@Override
	public void displayPersonByState() {
		System.out.println("We Have list of State In DataBase");
		personByState();
		stateMap.forEach((k,v) -> System.out.println(k));
		System.out.println("\nEnter the state From List");
		String searchState = SC.next();
		if(stateMap.get(searchState)!=null) {
			contactList = stateMap.get(searchState);
			contactList.forEach(System.out::println);
		}
		else {
			System.out.println("Sorry This State not Valid");
		}
	}
	
	@Override
	public void displayPersonByCity() {
		System.out.println("We Have list of City In DataBase");   
		personByCity();
		cityMap.forEach((k,v) -> System.out.println(k));
		System.out.println("\nEnter the City From List");
		String searchCity = SC.next();
		if(cityMap.get(searchCity)!=null) {
			contactList = cityMap.get(searchCity);
			contactList.forEach(System.out::println);
		}
		else {
			System.out.println("Sorry This city not Valid");
		}
	}

	public Set<ContactDetails> storeInMap(String serchCityState, ContactDetails userContactDetails, Map<String, Set<ContactDetails>> Map) {
		contactList = new HashSet<ContactDetails>();
		if (Map.get(serchCityState) == null) {
			contactList.add(userContactDetails);
		} else {
			contactList = Map.get(serchCityState);
			contactList.add(userContactDetails);
		}
		return contactList;
	}
	
	public void personByCity() {
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			contactList = contactListToMap.get(m.getKey());
			for (ContactDetails contactDetails : contactList) {
				contactList = storeInMap(contactDetails.getCity(),contactDetails,cityMap);
				cityMap.put(contactDetails.getCity(), contactList);
			}
		}
	}

	public void personByState() {
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			contactList = contactListToMap.get(m.getKey());
			for (ContactDetails contactDetails : contactList) {
				contactList = storeInMap(contactDetails.getState(),contactDetails,stateMap);
				stateMap.put(contactDetails.getState(), contactList);
			}
		}
	}

	@Override
	public void viewPersonByCity() {
		personByCity();
		System.out.println("***** City By Person *****");
		cityMap.entrySet()
		.stream().forEach(m -> {
			System.out.print(m.getKey()+" : ");  
			m.getValue().forEach(System.out::println);
			System.out.println();});
	}
	
	@Override
	public void viewPersonByState() {
		personByState();
		System.out.println("***** State By Person *****");
		stateMap.entrySet()
		.stream().forEach(m -> {
			System.out.print(m.getKey()+" : ");  
			m.getValue().forEach(System.out::println);
			System.out.println();});	
	}
	
	@Override
	public void viewPersonCountByCityState() {
		personByCity();
		personByState();
		System.out.println("***** City By Person Count *****");
		for (HashMap.Entry m : cityMap.entrySet()) {
			contactList = cityMap.get(m.getKey());
			System.out.println(m.getKey() + " : " + contactList.size());
		}
		System.out.println("***** State By Person Count *****");
		for (HashMap.Entry m : stateMap.entrySet()) {
			contactList = stateMap.get(m.getKey());
			System.out.println(m.getKey() + " : " + contactList.size());
		}
	}

	@Override
	public void sortByNameCityStateZip() {
		System.out.println("Select From Option\n"
				+ "1.Sort By Name\n"
				+ "2.Sort By City\n"
				+ "3.Sort By State\n"
				+ "4.Sort BY Zip Code");
		int option = SC.nextInt();
		System.out.println("List of Address book Name");
		contactListToMap.forEach((k,v)-> System.out.println(k));
		System.out.println("Enter the Address book name");
		String addressBookName=SC.next();
		switch (option) {
		case 1:
			sortByName(addressBookName);	
			break;
		case 2:
			sortByCity(addressBookName);
			break;
		case 3:
			sortByState(addressBookName);
			break;
		case 4:
			sortByZip(addressBookName);
			break;

		default:
			break;
		}
		
	}

	public void sortByName(String addressBookName) {
		System.out.println("Address book Sort By Name");
		contactList = contactListToMap.get(addressBookName);
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getFirstName))
		.forEach(System.out::println);
	}
	
	public void sortByCity(String addressBookName) {
		System.out.println("Address book Sort By City");
		contactList = contactListToMap.get(addressBookName);
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getCity))
		.forEach(System.out::println);
	}
	
	public void sortByState(String addressBookName) {
		System.out.println("Address book Sort By State");
		contactList = contactListToMap.get(addressBookName);
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getState))
		.forEach(System.out::println);
	}
	
	public void sortByZip(String addressBookName) {
		System.out.println("Address book Sort By Zip Code");
		contactList = contactListToMap.get(addressBookName);
		contactList.stream().sorted(Comparator.comparing(ContactDetails::getZip))
		.forEach(System.out::println);
	}

	@Override
	public void writeToFile() {
		String PATH = "static/Test.txt";
		File file = new File(PATH);
		for (HashMap.Entry m : contactListToMap.entrySet()) {
			contactList = contactListToMap.get(m.getKey());
			for (ContactDetails contactDetails : contactList) {
				try {
					Files.write(Paths.get(PATH), (contactDetails.toString()+System.lineSeparator())
							.getBytes(StandardCharsets.UTF_8),
							StandardOpenOption.CREATE, StandardOpenOption.APPEND);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void readFromFile() {
		String PATH = "static/Test.txt";
		File file = new File(PATH);
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(PATH),StandardCharsets.UTF_8);
			lines.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
