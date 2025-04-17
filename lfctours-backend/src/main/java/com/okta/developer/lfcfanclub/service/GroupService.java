package com.okta.developer.lfcfanclub.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.okta.developer.lfcfanclub.dao.GroupRepository;
import com.okta.developer.lfcfanclub.dao.UserRepository;
import com.okta.developer.lfcfanclub.model.Group;
import com.okta.developer.lfcfanclub.model.User;

import jakarta.validation.Valid;
@Service
public class GroupService {
	 @Autowired
	 private GroupRepository groupRepository;
	 @Autowired
	 private UserRepository userRepository;
	 public ResponseEntity<?> deleteUserById(Long id) {
		groupRepository.deleteById(id);
        return ResponseEntity.ok().build();
		
	}
	public ResponseEntity<Group> updateGroup(@Valid Group group) {
		// TODO Auto-generated method stub
		 Group result = groupRepository.save(group);
	     return ResponseEntity.ok().body(result);
		
	}
	public ResponseEntity<Group> createGroup(@Valid Group group, OAuth2User principal) throws URISyntaxException {
		 Map<String, Object> details = principal.getAttributes();
	        String userId = details.get("sub").toString();
	 
	        // check to see if user already exists
	        Optional<User> user = userRepository.findById(userId);
	        group.setUser(user.orElse(new User(userId,
	                        details.get("name").toString(), details.get("email").toString())));

	        Group result = groupRepository.save(group);
	        return ResponseEntity.created(new URI("/api/group/" + result.getId()))
	                .body(result);
		
	}
	public ResponseEntity<?> getGroup(Long id) {
		 Optional<Group> group = groupRepository.findById(id);
	        return group.map(response -> ResponseEntity.ok().body(response))
	                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	public Collection<Group> findAllByUserId(String name) {
		// TODO Auto-generated method stub
		return groupRepository.findAllByUserId(name);
	}
	 
}
