package gov.iti.jets.sakila.controllers.rest.store;

import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.persistence.entities.Staff;
import gov.iti.jets.sakila.services.StoreService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/stores/{storeId}/staff")
public class StaffController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStaffByStoreId(@PathParam("storeId") Short storeId){
        return Response.ok()
                .entity(StoreService.INSTANCE.findAllStaffByStoreId(storeId))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{staffId}")
    public Response addStaffToStore(@PathParam("storeId") Short storeId, @PathParam("staffId") Short staffId){
        return Response.ok()
                .entity(StoreService.INSTANCE.addStaffToStore(storeId, staffId))
                .build();
    }

}
