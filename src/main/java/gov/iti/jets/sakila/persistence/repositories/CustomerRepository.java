package gov.iti.jets.sakila.persistence.repositories;

public class CustomerRepository {
    private static CustomerRepository customerRepository = new CustomerRepository();
    private CustomerRepository(){}
    public static CustomerRepository getInstance(){
        return customerRepository;
    }
}
