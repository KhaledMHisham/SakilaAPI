package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.payment.PaymentDto;
import gov.iti.jets.sakila.mappers.PaymentMapper;
import gov.iti.jets.sakila.persistence.entities.Payment;
import gov.iti.jets.sakila.persistence.repositories.PaymentRepository;

public class PaymentService extends BaseService<Payment, PaymentDto, Integer>{
    private static final PaymentService instance = new PaymentService();
    public PaymentService() {
        super(PaymentRepository.getInstance(), PaymentMapper.INSTANCE, Payment.class);
    }
    public static PaymentService getInstance(){
        return instance;
    }
}
