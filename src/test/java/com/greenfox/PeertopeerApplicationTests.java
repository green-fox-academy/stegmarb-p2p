package com.greenfox;

import com.greenfox.controller.MessageRestController;
import com.greenfox.model.Message;
import com.greenfox.repository.MessageRepository;
import com.greenfox.service.P2PService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.assertj.core.api.Assertions.*;


import java.nio.charset.Charset;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = MessageRestController.class)
@RestClientTest(MessageRestController.class)
@WebAppConfiguration
@EnableWebMvc
//@ContextConfiguration({ "classpath:/applicationContext.xml" })
public class PeertopeerApplicationTests {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	@Mock
	private P2PService p2PService;

	@InjectMocks
	MessageRestController restController;

	private MockMvc mockMvc;

	@Autowired
  private MockRestServiceServer server;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(restController).build();
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}


//	@Test
//  public void testMessage() throws Exception{
//	  this.entityManager.persist(new Message("stegmarb", "Hello World!"));
//	  Message message = this.messageRepo.findOne(0L);
//	  assertThat(message.getText().equals("Hello World!"));
//	  assertThat(message.getUsername().equals("stegmarb"));
//  }

	@Test
  public void testMessagePostController() throws Exception{
	  mockMvc.perform(post("/api/message/receive")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"message\": {\"id\": 7655482, \"username\": \"Stég\", \"text\": \"Tetves Mokito Teszt\", " +
            "\"timestamp\": 1322018752992}, \"client\": {\"id\": \"EggDice\"}}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status").value("ok"));
  }
}