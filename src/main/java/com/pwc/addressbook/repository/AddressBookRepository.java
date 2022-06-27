package com.pwc.addressbook.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pwc.addressbook.model.AddressBookEntity;
import com.pwc.addressbook.model.UserDetails;
import com.pwc.addressbook.service.AddressBookServiceImpl;

@Transactional
public interface AddressBookRepository extends JpaRepository<AddressBookEntity, Integer> {
	
	@Query("SELECT t FROM AddressBookEntity t WHERE t.name = ?1 and t.userName = ?2")
	Optional<AddressBookEntity> findByNameAndUserName(String name, String userName);
	
	void deleteByName(String name);

	List<AddressBookEntity> findByUserName(String string);

	Optional<AddressBookEntity> findByName(String name);

}
