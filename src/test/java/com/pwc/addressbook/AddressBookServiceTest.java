package com.pwc.addressbook;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.pwc.addressbook.exception.NoSuchContactExistsException;
import com.pwc.addressbook.model.AddressBookEntity;
import com.pwc.addressbook.repository.AddressBookRepository;
import com.pwc.addressbook.service.AddressBookServiceImpl;

@SpringBootTest
public class AddressBookServiceTest {

	/**
	 * Autowire in the service we want to test
	 */
	@Autowired
	private AddressBookServiceImpl service;

	/**
	 * Create a mock implementation of the WidgetRepository
	 */
	@MockBean
	private AddressBookRepository repository;

	@Test
	@DisplayName("Test findByName Success")
	void testFindByName() {
		// Setup our mock repository
		AddressBookEntity addressBookEntity = new AddressBookEntity(1, "userName", "name", "phone");
		doReturn(Optional.of(addressBookEntity)).when(repository).findByName("name");
		// Execute the service call
		Optional<AddressBookEntity> returnedAddress = Optional.ofNullable(service.searchAddress("name"));
		// Assert the response
		Assertions.assertTrue(returnedAddress.isPresent(), "Address was not found");
		Assertions.assertSame(returnedAddress.get(), addressBookEntity,
				"The Address returned was not the same as the mock");
	}

	@Test
	@DisplayName("Test findByName Not Found")
	void testFindByNameNotFound() {
		try {
			// Setup our mock repository
			doReturn(Optional.empty()).when(repository).findByName("name");
			// Execute the service call
			Optional<AddressBookEntity> returnedAddress = Optional.ofNullable(service.searchAddress("name"));
			// Assert the response
			Assertions.assertFalse(returnedAddress.isPresent(), "Address should not be found");
		} catch (NoSuchContactExistsException e) {
			assertThat(e.getMessage().equals("PLEASE ENTER VALID NAME = name"));
		}
	}

	@Test
	@DisplayName("Test findAll")
	void testFindAll() {
		// Setup our mock repository
		AddressBookEntity addressBookEntity1 = new AddressBookEntity(1, "userName1", "name1", "phone1");
		AddressBookEntity addressBookEntity2 = new AddressBookEntity(2, "userName2", "name2", "phone2");
		doReturn(Arrays.asList(addressBookEntity1, addressBookEntity2)).when(repository).findAll();
		// Execute the service call
		List<AddressBookEntity> widgets = service.findAll();
		// Assert the response
		Assertions.assertEquals(2, widgets.size(), "findAll should return 2 Address");
	}

	@Test
	@DisplayName("Test save AddressBookEntity")
	void testSave() {
		// Setup our mock repository
		AddressBookEntity addressBookEntity = new AddressBookEntity(1, "userName", "name", "phone");
		doReturn(addressBookEntity).when(repository).save(any());
		// Execute the service call
		String returnedAddress = service.addContact(addressBookEntity);
		// Assert the response
		Assertions.assertNotNull(returnedAddress, "The saved Address should not be null");
	}
}
