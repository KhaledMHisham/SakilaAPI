package gov.iti.jets.sakila.controllers.rest.staff;

import gov.iti.jets.sakila.dtos.staff.StaffDto;
import gov.iti.jets.sakila.services.StaffService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/staff")
public class StaffController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStaff(){
        return Response.ok()
                .entity(StaffService.INSTANCE.findAll())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{staffId}")
    public Response getStaffById(@PathParam("staffId") Short staffId){
        return Response.ok()
                .entity(StaffService.INSTANCE.findById(staffId))
                .build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddNewStaff(StaffDto staffDto){
        return Response.ok()
                .entity(StaffService.INSTANCE.insert(staffDto))
                .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{staffId}")
    public Response updateStaff(@PathParam("staffId") Short staffId, StaffDto staffDto){
        return Response.ok()
                .entity(StaffService.INSTANCE.update(staffId, staffDto))
                .build();
    }

    @DELETE
    @Produces
    @Path("{staffId}")
    public Response DeleteStaff(@PathParam("staffId") Short staffId){
        return Response.ok()
                .entity(StaffService.INSTANCE.deleteById(staffId))
                .build();
    }
}
