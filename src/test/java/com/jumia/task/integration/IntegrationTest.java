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
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaskApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:/application-integrationtest.properties")
public class IntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private CustomerResource customerResource;

    @Test
    public void testStartup() {
        // test the orderService
        assertNotNull(customerResource);
        assertNotNull(mvc);
    }

    @Test
    public void test() {
        List<CustomerResponseDTO> customerResponseDTOList = customerResource.findAll();
        assertNotNull(customerResponseDTOList);
        assertEquals(41, customerResponseDTOList.size());
    }

}
