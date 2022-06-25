package com.spring.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.mvc.model.UserDetails;

@Repository
public interface UserRepository extends CrudRepository<UserDetails, String> {

}
