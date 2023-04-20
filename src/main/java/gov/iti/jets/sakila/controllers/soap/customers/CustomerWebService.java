package gov.iti.jets.sakila.controllers.soap.customers;

import gov.iti.jets.sakila.dtos.customer.CustomerDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.CustomerService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class CustomerWebService {
    public Collection<CustomerDto> getAllCustomers(){
        return CustomerService.INSTANCE.findAll();
    }
    public CustomerDto addNewCustomer(CustomerDto customerDto){
        return CustomerService.INSTANCE.insert(customerDto);
    }
    public CustomerDto updateCustomer(Integer customerId, CustomerDto customerDto){
        return CustomerService.INSTANCE.update(customerId, customerDto);
    }
    public SuccessMessage deleteCustomer(Integer customerId){
        return CustomerService.INSTANCE.deleteById(customerId);
    }
}
