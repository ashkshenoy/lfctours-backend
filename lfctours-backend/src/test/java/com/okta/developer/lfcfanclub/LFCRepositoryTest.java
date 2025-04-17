package com.okta.developer.lfcfanclub;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.okta.developer.lfcfanclub.dao.GroupRepository;
import com.okta.developer.lfcfanclub.model.Group;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class LFCRepositoryTest {
	@Autowired
	private GroupRepository groupRepository;
	
	 @Test
	  public void testGetAllGroups() {
		 List<Group> groups = groupRepository.findAll();
		 assertThat(groups)
		  .isNotNull();
	  }
	 @Test
	  public void testGetGroupById() {
		 Long id = 1L;
		 Optional<Group> group = groupRepository.findById(id);
		 assertThat(group)
		  .isNotNull();
	  }

}
