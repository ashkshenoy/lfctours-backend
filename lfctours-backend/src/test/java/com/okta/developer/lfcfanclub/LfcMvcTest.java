package com.okta.developer.lfcfanclub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LfcMvcTest {
	@Autowired
	  private MockMvc mockMvc;
	
	@Test
	  public void testEndpoint() throws Exception {
	    mockMvc.perform(MockMvcRequestBuilders.get("/api/groups"))
	       .andExpect(MockMvcResultMatchers.status().isOk());
	  }
}
