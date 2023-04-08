package gov.iti.jets.sakila.persistence.repositories;

public class PaymentRepository {
    private static PaymentRepository paymentRepository = new PaymentRepository();
    private PaymentRepository(){}
    public static PaymentRepository getInstance(){
        return paymentRepository;
    }
}
