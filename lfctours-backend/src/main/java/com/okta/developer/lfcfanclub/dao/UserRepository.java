package com.okta.developer.lfcfanclub.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okta.developer.lfcfanclub.model.Group;
import com.okta.developer.lfcfanclub.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	List<Group> findAllById(String id);
}