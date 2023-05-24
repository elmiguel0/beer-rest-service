package miguelo.io.beerrestservice.customerControllerTesrt;

import static org.mockito.ArgumentMatchers.any;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import miguelo.io.beerrestservice.controller.CustomerController;
import miguelo.io.beerrestservice.model.Customer;
import miguelo.io.beerrestservice.service.CustomerService;
import miguelo.io.beerrestservice.service.CustomerserviceImpl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    CustomerserviceImpl customerserviceImpl = new CustomerserviceImpl();

    @Test
    void getCustomerById() throws Exception{

        Customer testCustomer = customerserviceImpl.customers().get(0);

        given(customerService.getCustomerById(any(UUID.class))).willReturn(testCustomer);

        mockMvc.perform(get("/api/v1/customer/" + UUID.randomUUID())
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
    }

    
}
