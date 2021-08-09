package com.blz.address_book_system.main;

import java.util.Scanner;

import com.blz.address_book_system.service.IAddressBook;
import com.blz.address_book_system.service.impl.AddressBookImpl;

public class AddressBookMain {
	static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IAddressBook addressBook = (IAddressBook) new AddressBookImpl();
		System.out.println("Hi This is Address Book Library");
		int exit = 1;
		while (exit != 0) {
			System.out.println("1.Add Contacts\n2.Edit Contact\n3.Delete Contact\n0.Exit\nSelect from Option");
			int op = sc.nextInt();
			switch (op) {
			case 0:
				exit = 0;
				System.out.println("Thank You For Participation");
				break;
			case 1:
				addressBook.addContact();
				break;
			case 2:
				addressBook.editContact();
				break;
			case 3:
				addressBook.deleteContact();
				break;
			default:
				System.out.println("Select from Option");
				break;
			}
		}
	}
}
