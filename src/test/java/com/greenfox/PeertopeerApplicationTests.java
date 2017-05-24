package com.greenfox;


import com.greenfox.controller.MessageRestController;
import com.greenfox.service.P2PService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MessageRestController.class)
@WebAppConfiguration
@EnableWebMvc
public class PeertopeerApplicationTests {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
  private P2PService p2PService;

	@Before
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
  public void testMessagePostController() throws Exception{
	  mockMvc.perform(post("/api/message/received")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"message\": {\"id\": 7655482, \"username\": \"EggDice\", \"text\": \"How you doin'?\", " +
            "\"timestamp\": 1322018752992}, \"client\": \"id\": \"EggDice\"}}"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.status").value("ok"));
  }
}