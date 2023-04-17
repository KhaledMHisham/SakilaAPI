package gov.iti.jets.sakila.controllers.rest.cities;


import gov.iti.jets.sakila.services.AddressService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/cities/{cityId}/addresses")
public class AddressController {
    @GET
    public Response getAllAddressesByCityId(@PathParam("cityId") Integer cityId){
        return Response.ok()
                .entity(AddressService.INSTANCE.findAllAddressesByCityId(cityId))
                .build();
    }


}
