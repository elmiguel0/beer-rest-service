package miguelo.io.beerrestservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import miguelo.io.beerrestservice.model.Customer;
import miguelo.io.beerrestservice.service.CustomerService;

@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomer(){
        log.debug("Get Customer List - in Controller");
        return customerService.customers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId){
        log.debug("Get Customer by Id - in Controller");
        return customerService.getCustomerById(customerId);
    }
}
