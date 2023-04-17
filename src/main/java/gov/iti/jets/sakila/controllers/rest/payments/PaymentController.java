package gov.iti.jets.sakila.controllers.rest.payments;

import gov.iti.jets.sakila.dtos.payment.PaymentDto;
import gov.iti.jets.sakila.services.PaymentService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/payments")
public class PaymentController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPayments(){
        return Response.ok()
                .entity(PaymentService.getInstance().findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddNewPayment(PaymentDto paymentDto){
        return Response.ok()
                .entity(PaymentService.getInstance().insert(paymentDto))
                .build();
    }
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{paymentId}")
    public Response deletePayment(@PathParam("paymentId") Integer paymentId){
        return Response.ok()
                .entity(PaymentService.getInstance().deleteById(paymentId))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{paymentId}")
    public Response updatePayment(@PathParam("paymentId") Integer paymentId, PaymentDto paymentDto){
        return Response.ok()
                .entity(PaymentService.getInstance().update(paymentId, paymentDto))
                .build();
    }
}
