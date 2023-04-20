package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.customer.CustomerDto;
import gov.iti.jets.sakila.dtos.payment.PaymentDto;
import gov.iti.jets.sakila.dtos.rental.RentalDto;
import gov.iti.jets.sakila.mappers.CustomerMapper;
import gov.iti.jets.sakila.mappers.PaymentMapper;
import gov.iti.jets.sakila.mappers.RentalMapper;
import gov.iti.jets.sakila.persistence.entities.Customer;
import gov.iti.jets.sakila.persistence.repositories.CustomerRepository;

import java.util.Collection;

public class CustomerService extends BaseService<Customer, CustomerDto, Integer>{
    public static final CustomerService INSTANCE = new CustomerService();
    private CustomerRepository customerRepository = CustomerRepository.getInstance();
    private RentalMapper rentalMapper = RentalMapper.INSTANCE;
    private PaymentMapper paymentMapper = PaymentMapper.INSTANCE;
    private CustomerService() {
        super(CustomerRepository.getInstance(), CustomerMapper.INSTANCE, Customer.class);
    }
    public Collection<RentalDto> findAllRentalsByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(Customer.class, customerId);
        return rentalMapper.collectionToDto(customer.getRentals());
    }
    public Collection<PaymentDto> findAllPaymentsByCustomerId(Integer customerId) {
        Customer customer = customerRepository.findById(Customer.class, customerId);
        return paymentMapper.collectionToDto(customer.getPayments());
    }
}
