package com.pwc.addressbook.service;

import java.util.List;
import java.util.Optional;

import com.pwc.addressbook.model.AddressBookEntity;

public interface AddressBookService {
	
	public String addContact(AddressBookEntity addressBookEntity);
	
	public AddressBookEntity searchAddress(String lt);
	
	public void deleteContact(String name);
	
	public List<AddressBookEntity> getOtherUser(String string);
}
