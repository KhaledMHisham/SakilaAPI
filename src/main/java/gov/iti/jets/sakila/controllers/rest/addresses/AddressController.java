package gov.iti.jets.sakila.controllers.rest.addresses;

import gov.iti.jets.sakila.dtos.location.AddressDto;
import gov.iti.jets.sakila.services.AddressService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/addresses")
public class AddressController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAddresses(){
        return Response.ok().entity(AddressService.INSTANCE.findAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddNewAddress(AddressDto addressDto){
        return Response.ok()
                .entity(AddressService.INSTANCE.insert(addressDto))
                .build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{addressId}")
    public Response UpdateAddress(@PathParam("addressId") Integer addressId, AddressDto addressDto){
        return Response.ok().entity(AddressService.INSTANCE.update(addressId, addressDto)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{addressId}")
    public Response DeleteAddress(@PathParam("addressId") Integer addressId){
        return Response.ok().entity(AddressService.INSTANCE.deleteById(addressId)).build();
    }
}
