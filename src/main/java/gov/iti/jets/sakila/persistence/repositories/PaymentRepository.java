package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Payment;

public class PaymentRepository extends CrudRepository<Payment, Integer>{
    private static PaymentRepository paymentRepository = new PaymentRepository();
    private PaymentRepository(){}
    public static PaymentRepository getInstance(){
        return paymentRepository;
    }
}
