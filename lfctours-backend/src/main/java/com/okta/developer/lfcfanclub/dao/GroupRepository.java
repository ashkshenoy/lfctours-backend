package com.okta.developer.lfcfanclub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okta.developer.lfcfanclub.model.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
    List<Group> findAllByUserId(String id);
}