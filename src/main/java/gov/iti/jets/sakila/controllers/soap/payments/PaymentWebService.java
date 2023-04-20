package gov.iti.jets.sakila.controllers.soap.payments;

import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.dtos.payment.PaymentDto;
import gov.iti.jets.sakila.services.PaymentService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.ws.rs.*;

import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class PaymentWebService {
    public Collection<PaymentDto> getAllPayments(){
        return PaymentService.getInstance().findAll();
    }
    public PaymentDto AddNewPayment(PaymentDto paymentDto){
        return PaymentService.getInstance().insert(paymentDto);
    }
    public SuccessMessage deletePayment(Integer paymentId){
        return PaymentService.getInstance().deleteById(paymentId);
    }

    public PaymentDto updatePayment(Integer paymentId, PaymentDto paymentDto){
        return PaymentService.getInstance().update(paymentId, paymentDto);
    }

}
