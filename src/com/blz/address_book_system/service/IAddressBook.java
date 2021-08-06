package com.blz.address_book_system.service;

import java.util.ArrayList;
import java.util.List;

import com.blz.address_book_system.dto.ContactDetails;

public interface IAddressBook {
	public void addContact();
	public void editContact(ContactDetails i,int count);
//	static public List<ContactDetails> contactList=new ArrayList<ContactDetails>();
//	public void deleteContact();
}
