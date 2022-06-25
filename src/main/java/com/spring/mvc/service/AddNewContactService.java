package com.spring.mvc.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.AddNewContact;
import com.spring.mvc.repository.AddNewContactRepository;

@Service
public class AddNewContactService {

	@Autowired
	AddNewContactRepository addNewContactRepository;

	public AddNewContact addContact(AddNewContact addNewContact) {
		// Random random = new Random();
		// long randomWithNextInt = random.nextInt();
		// addNewContact.setId(randomWithNextInt);
		return addNewContactRepository.save(addNewContact);
	}

	public AddNewContact searchAddress(String lt) {
		
		Optional<AddNewContact> at = addNewContactRepository.findByName(lt);

		return at.get();
	}

	public List<AddNewContact> getAll() {
		
		return addNewContactRepository.findAll();
	}

	public void deleteContact(String name) {

		addNewContactRepository.deleteByName(name);

	}

	public List<AddNewContact> getOtherUser(String string) {

		return addNewContactRepository.findByUserName(string);
	}

}
