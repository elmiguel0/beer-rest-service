package miguelo.io.beerrestservice.service;

import java.util.List;
import java.util.UUID;

import miguelo.io.beerrestservice.model.Customer;

public interface CustomerService {
    List<Customer> customers();
    Customer getCustomerById(UUID customerId);
    Customer addCustomer(Customer customer);
    void updateById(UUID customerId, Customer customer);
    void deleteById(UUID customerId);
    void patchCustomerById(UUID customerId, Customer customer);
}
