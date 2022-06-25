package com.spring.mvc.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.mvc.model.AddNewContact;
import com.spring.mvc.model.UserDetails;
import com.spring.mvc.service.AddNewContactService;

@Transactional
public interface AddNewContactRepository extends JpaRepository<AddNewContact, Integer> {

	Optional<AddNewContact> findByName(String lt);

	void deleteByName(String name);

	List<AddNewContact> findByUserName(String string);

}
