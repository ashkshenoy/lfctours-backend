package com.okta.developer.lfcfanclub.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
	//List<Group> findAllByUserId(String id);
}