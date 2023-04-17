package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Customer;

public class CustomerRepository extends CrudRepository<Customer, Integer> {
    private static CustomerRepository customerRepository = new CustomerRepository();
    private CustomerRepository(){}
    public static CustomerRepository getInstance(){
        return customerRepository;
    }
}
