package com.blz.address_book_system.service;

public interface IAddressBook {
	public void addContact();
	public void editContact();
	public void deleteContact();
	public void displayContact();
	public void displayContactCityStatePerson();
	public void displayPersonByCity();
	public void displayPersonByState();
	public void viewPersonByCity();
	public void viewPersonByState();
	public void viewPersonCountByCityState();
	public void sortByNameCityStateZip();
	public void writeToFile();
	public void readFromFile();
	
}
