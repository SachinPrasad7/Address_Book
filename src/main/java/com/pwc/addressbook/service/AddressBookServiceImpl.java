package com.pwc.addressbook.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.addressbook.controller.AddressBookController;
import com.pwc.addressbook.exception.ContactAlreadyExistsException;
import com.pwc.addressbook.exception.NoSuchContactExistsException;
import com.pwc.addressbook.model.AddressBookEntity;
import com.pwc.addressbook.repository.AddressBookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {

	private static final Logger log = LoggerFactory.getLogger(AddressBookController.class);

	@Autowired
	AddressBookRepository addressBookRepository;

	public String addContact(AddressBookEntity addressBookEntity) {

		AddressBookEntity existingContact = addressBookRepository
				.findByNameAndUserName(addressBookEntity.getName(), addressBookEntity.getUserName()).orElse(null);
		
		if (existingContact == null) {
			addressBookRepository.save(addressBookEntity);
			log.info("Conatct Saved to DB!!");
			return "Contact added successfully";
		}

		// existingContact.getUserName().equalsIgnoreCase("Other Address Book")
		else
			throw new ContactAlreadyExistsException("Contact already exixts!!");
	}

	public AddressBookEntity searchAddress(String name) {

		return addressBookRepository.findByName(name)
				.orElseThrow(() -> new NoSuchContactExistsException("NO CONTACT PRESENT WITH ID = " + name));
	}

	public void deleteContact(String name) {
		if (name != null) {
			addressBookRepository.deleteByName(name);
			log.info("Conatct deleted from DB!!");
		}
		else throw new NoSuchContactExistsException("PLEASE ENTER VALID NAME = "+name);
	}

	public List<AddressBookEntity> getOtherUser(String name) {
		if (name != null) {
			return addressBookRepository.findByUserName(name);
		}
		else throw new NoSuchContactExistsException("PLEASE ENTER VALID NAME = "+name);
		
	}

}
