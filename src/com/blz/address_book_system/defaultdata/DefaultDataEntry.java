package com.blz.address_book_system.defaultdata;

import java.util.HashSet;

import com.blz.address_book_system.dto.ContactDetails;
import com.blz.address_book_system.service.impl.AddressBookImpl;

public class DefaultDataEntry {
	
	ContactDetails contactDetails;
	public void defaultData() {
		AddressBookImpl ad = new AddressBookImpl();
		//DYSTAR
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("DYSTAR");
		contactDetails.setFirstName("Deepak");
		contactDetails.setLastName("Yadav");
		contactDetails.setAddress("Empress Thane");
		contactDetails.setCity("Patna");
		contactDetails.setState("Bihar");
		contactDetails.setEmail("ydeepak@gmail.com");
		contactDetails.setZip("401205");
		contactDetails.setPhone("9823563242");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("DYSTAR");
		contactDetails.setFirstName("Gaurav");
		contactDetails.setLastName("Yadav");
		contactDetails.setAddress("Empress Thane");
		contactDetails.setCity("Patna");
		contactDetails.setState("Bihar");
		contactDetails.setEmail("Gaurav@gmail.com");
		contactDetails.setZip("401305");
		contactDetails.setPhone("9823438723");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList = AddressBookImpl.contactListToMap.get(contactDetails.getAddressBookName());
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);
		
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("DYSTAR");
		contactDetails.setFirstName("Gauravji");
		contactDetails.setLastName("Samant");
		contactDetails.setAddress("Empress Thane");
		contactDetails.setCity("Gandhinagar");
		contactDetails.setState("Gujarat");
		contactDetails.setEmail("Gaurav@gmail.com");
		contactDetails.setZip("401505");
		contactDetails.setPhone("9823438723");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList = AddressBookImpl.contactListToMap.get(contactDetails.getAddressBookName());
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);

		//Jungle
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jungle");
		contactDetails.setFirstName("Sarang");
		contactDetails.setLastName("Potpite");
		contactDetails.setAddress("Pune nagar");
		contactDetails.setCity("Pune");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("ydeepak@gmail.com");
		contactDetails.setZip("564305");
		contactDetails.setPhone("9823326657");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);

		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jungle");
		contactDetails.setFirstName("Jash");
		contactDetails.setLastName("Vora");
		contactDetails.setAddress("Gokul Thane");
		contactDetails.setCity("Gandhinagar");
		contactDetails.setState("Gujarat");
		contactDetails.setEmail("jash@gmail.com");
		contactDetails.setZip("401705");
		contactDetails.setPhone("9823563452");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList = AddressBookImpl.contactListToMap.get(contactDetails.getAddressBookName());
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);
		
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jungle");
		contactDetails.setFirstName("Jash");
		contactDetails.setLastName("Vora");
		contactDetails.setAddress("Gokul Thane");
		contactDetails.setCity("Gandhinagar");
		contactDetails.setState("Gujarat");
		contactDetails.setEmail("jash@gmail.com");
		contactDetails.setZip("403405");
		contactDetails.setPhone("9823563452");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList = AddressBookImpl.contactListToMap.get(contactDetails.getAddressBookName());
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);
		
		//Jaijavan
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jaijavan");
		contactDetails.setFirstName("Rahul");
		contactDetails.setLastName("Sharma");
		contactDetails.setAddress("Shimla Thane");
		contactDetails.setCity("Lucknow");
		contactDetails.setState("UttarPradesh");
		contactDetails.setEmail("Rahul@gmail.com");
		contactDetails.setZip("406305");
		contactDetails.setPhone("9823563452");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);
		
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jaijavan");
		contactDetails.setFirstName("Ronak");
		contactDetails.setLastName("Jain");
		contactDetails.setAddress("Rajasthan Thane");
		contactDetails.setCity("Jaipur");
		contactDetails.setState("Rajasthan");
		contactDetails.setEmail("Ronak@gmail.com");
		contactDetails.setZip("408405");
		contactDetails.setPhone("9823563452");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList = AddressBookImpl.contactListToMap.get(contactDetails.getAddressBookName());
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);
		
		contactDetails = new ContactDetails();
		contactDetails.setAddressBookName("Jaijavan");
		contactDetails.setFirstName("Anooj");
		contactDetails.setLastName("Srivastav");
		contactDetails.setAddress("GB Thane");
		contactDetails.setCity("Thane");
		contactDetails.setState("Maharashtra");
		contactDetails.setEmail("Anooj@gmail.com");
		contactDetails.setZip("403405");
		contactDetails.setPhone("9823563452");
		ad.contactList = new HashSet<ContactDetails>();
		ad.contactList = AddressBookImpl.contactListToMap.get(contactDetails.getAddressBookName());
		ad.contactList.add(contactDetails);
		AddressBookImpl.contactListToMap.put(contactDetails.getAddressBookName(), ad.contactList);
	}
}
