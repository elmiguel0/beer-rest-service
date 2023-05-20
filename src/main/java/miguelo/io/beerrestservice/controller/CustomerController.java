package miguelo.io.beerrestservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PatchMapping("{customerId}")
    public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId,
                                                @RequestBody Customer customer){
        customerService.patchCustomerById(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    @DeleteMapping("{customerId}")
    public ResponseEntity deleteById(@PathVariable("customerId") UUID customerId){
        customerService.deleteById(customerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{customer}")
    public ResponseEntity updateById(@PathVariable("customerId") UUID customerId, Customer customer){
        customerService.updateById(customerId,customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    //@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addCustomer(@RequestBody Customer customer){

        Customer saveCustomer = customerService.addCustomer(customer);

        HttpHeaders headers = new HttpHeaders();

        headers.add("Location",saveCustomer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

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
