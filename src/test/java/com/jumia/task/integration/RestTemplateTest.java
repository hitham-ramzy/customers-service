package com.jumia.task.integration;


import com.jumia.task.TaskApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
public class RestTemplateTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetAllCustomersByWebTestClient() {
        HttpEntity<List> entity = new HttpEntity<>(null, new HttpHeaders());
        ResponseEntity<List> response = restTemplate.exchange("http://localhost:" + port + "/api/customer/all", HttpMethod.GET, entity, List.class);
        assertNotNull(response.getBody());
        assertEquals(41, response.getBody().size());

    }
}
