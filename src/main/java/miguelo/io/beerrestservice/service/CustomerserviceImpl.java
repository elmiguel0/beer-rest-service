package miguelo.io.beerrestservice.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import miguelo.io.beerrestservice.model.Customer;

@Slf4j
@Service
public class CustomerserviceImpl implements CustomerService {

    Map<UUID,Customer> customerList;

    public CustomerserviceImpl(){
        this.customerList = new HashMap<>();

        Customer customer1 = Customer.builder()
                    .id(UUID.randomUUID())
                    .customerName("Miguel Ramos")
                    .version("12.v")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

        Customer customer2 = Customer.builder()
                    .id(UUID.randomUUID())
                    .customerName("Arcelia Moreno")
                    .version("1.v")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();
                    
        Customer customer3 = Customer.builder()
                    .id(UUID.randomUUID())
                    .customerName("Juan Ramirez")
                    .version("0.v")
                    .createdDate(LocalDateTime.now())
                    .lastModifiedDate(LocalDateTime.now())
                    .build();

        customerList.put(customer1.getId(), customer1);
        customerList.put(customer2.getId(), customer2);
        customerList.put(customer3.getId(), customer3);

    }


    @Override
    public List<Customer> customers() {
        return new  ArrayList<>(customerList.values());
    }

    @Override
    public Customer getCustomerById(UUID customerId) {
        return customerList.get(customerId);
    }
    
}
