package Interfaces;

import Entity.Customer;
import java.util.List;

public interface ICustomer {
    public Customer createCustomer(Customer o);
    public Customer getCustomer(Long id);
    public List<Customer> getAllCustomer();   
}
