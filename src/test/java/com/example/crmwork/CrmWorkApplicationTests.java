package com.example.crmwork;

import ch.qos.logback.core.net.server.Client;
import com.example.crmwork.controls.EPC_Control;
import com.example.crmwork.domain.Clients;
import com.example.crmwork.repos.ClientsRepos;
import com.example.crmwork.service.ClientsService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CrmWorkApplicationTests {

	@Autowired
	private EPC_Control controller;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ClientsService clientsService;

	@MockBean
	private ClientsRepos clientsRepos;

	@Test
	public void contextLoads(){
		assertThat(controller).isNotNull();
	}

	@Test
	public void greetingShouldReturnDefaultMessage(){
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/epc/",
				String.class)).contains("Hello, World");
		System.out.println(port);
	}

//	@Before
//	public void setUp() {
//		Clients clients = new Clients("Alex", "Fam", "Oth", 23, "male");
//
//		Mockito.when(clientsRepos.findByName(clients.getName()))
//				.thenReturn("Alex");
//	}
//
//	@Test
//	void createClient() {
////		Clients clients = new Clients("Alex", "Fam", "Oth", 23, "male");
////		clientsService.createClient(clients);
//
//		List<Clients> found = clientsService.findByName("Alex");
//
//
//		assertThat(found.getName())
//				.isEqualTo("Alex");
//	}



}
