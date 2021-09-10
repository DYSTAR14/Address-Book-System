package com.blz.address_book_system.main;

import java.util.Scanner;

import com.blz.address_book_system.defaultdata.DefaultDataEntry;
import com.blz.address_book_system.service.IAddressBook;
import com.blz.address_book_system.service.impl.AddressBookImpl;

public class AddressBookMain {
	static final Scanner SC = new Scanner(System.in);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DefaultDataEntry defaultDataEntry = new DefaultDataEntry();
		IAddressBook addressBook = (IAddressBook) new AddressBookImpl();
		System.out.println("Hi This is Address Book Library");
		int exit=1;
		while(exit!=0) {
			System.out.println("1.Add Contacts\n2.Edit Contact\n3.Delete Contact\n"
					+ "4.Display Contact\n5.Display City State Person\n"
					+ "6.Display person by City\n7.Display Person by State\n"
					+ "8.View Person By Citys\n9.View Person By States\n"
					+ "0.Exit\nSelect from Option");
			int op=sc.nextInt();
			switch(op) {
			case 0:
				exit = 0;
				System.out.println("Thank You For Participation");
				break;
			case 1:
//				addressBook.addContact();
				defaultDataEntry.defaultData();// Default Data Entry
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.deleteContact();
				break;
			case 4:
				addressBook.displayContact();
				break;
			case 5:
				addressBook.displayContactCityStatePerson();
				break;
			case 6:
				addressBook.displayPersonByCity();
				break;
			case 7:
				addressBook.displayPersonByState();
				break;
			case 8:
				addressBook.viewPersonByCity();
				break;
			case 9:
				addressBook.viewPersonByState();
				break;
			default:
				System.out.println("Select from Option");
				break;
			}
		}
	}
}
