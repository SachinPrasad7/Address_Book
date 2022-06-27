package com.pwc.addressbook.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pwc.addressbook.model.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, String> {

}
