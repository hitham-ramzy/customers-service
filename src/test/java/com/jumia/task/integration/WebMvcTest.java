package com.jumia.task.integration;


import com.jumia.task.TaskApplication;
import com.jumia.task.entity.dto.CustomerResponseDTO;
import com.jumia.task.resource.CustomerResource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
public class WebMvcTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testStartup() {
        assertNotNull(mvc);
    }

    @Test
    public void testIndexRedirection() throws Exception {
        this.mvc.perform(get("/"))
                .andExpect(status().is3xxRedirection());

    }

    @Test
    public void testGetCustomers() throws Exception {
        this.mvc.perform(get("/api/customer"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllCustomers() throws Exception {
        this.mvc.perform(get("/api/customer/all"))
                .andExpect(status().isOk());
    }
}
