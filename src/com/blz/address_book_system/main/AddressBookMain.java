package com.blz.address_book_system.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.blz.address_book_system.dto.ContactDetails;

public class AddressBookMain {
	static final Scanner SC=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object> addressList=new ArrayList<Object>();
		String firstName="Deepak",lastName="Yadav",address="Empress Thane",city="Thane",state="Maharashtra",
				email="ydeepak@gmail.com",zip = "400005",phone="9823563242";
		ContactDetails addContact=new ContactDetails(firstName,lastName,address,city,state,email,zip,phone);
		addressList.add(addContact);
		for (int i = 0; i < addressList.size(); i++)
            System.out.print(addressList.get(i) + " ");
	}
}
