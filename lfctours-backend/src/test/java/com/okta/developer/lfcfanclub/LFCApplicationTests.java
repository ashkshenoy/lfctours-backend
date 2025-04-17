package com.okta.developer.lfcfanclub;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.*;

import com.okta.developer.lfcfanclub.LFCFanClubApplication;
import com.okta.developer.lfcfanclub.dao.GroupRepository;
import com.okta.developer.lfcfanclub.model.Event;
import com.okta.developer.lfcfanclub.model.Group;
import com.okta.developer.lfcfanclub.model.User;
import com.okta.developer.lfcfanclub.service.GroupService;


@SpringBootTest(classes = LFCFanClubApplication.class)
@ExtendWith(MockitoExtension.class)
class LFCApplicationTests {
	 @InjectMocks
	 private GroupService groupService;

	 @Mock
	 private GroupRepository groupRepository;
	 @Test
	 public void testGetGroupById() {
	  // Arrange
	  Long groupId = 1L;
	  User user = new User("1","Aashish","aashishkrd1@gmail.com");
	  User user1 = new User("2","Bhargav","bhargavmysore14@gmail.com");
	  User user2 = new User("3","Rajat","rajatpai12@gmail.com");
	  
	  Set<User> userSet = new HashSet<>();
	  userSet.add(user2);
	  userSet.add(user1);
	  userSet.add(user);
	  
	  
	  Event event1 = new Event(1L, "03-10-2025", "LFC v MUFC", "LFC Screening match 5",userSet);
	  Event event2 = new Event(2L, "10-10-2025", "LFC v MCFC", "LFC Screening match 6",userSet);
	  Set<Event> eventSet = new HashSet<>();
	  Group mockGroup = new Group(1L, "OLSC Bangalore","Indiranagar", "Bangalore","Karnataka", "India", "560074", user,eventSet);

	  // Mock the behavior of the repository to return the mock employee
	  Mockito.when(groupRepository.findById(groupId)).thenReturn(Optional.of(mockGroup));

	  // Act
	  ResponseEntity<?> result = groupService.getGroup(groupId);

	  // Assert
	  assertThat(result)
	  .isNotNull();
	
	
	 }
}


