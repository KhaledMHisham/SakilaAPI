package gov.iti.jets.sakila.controllers.rest.store;

import gov.iti.jets.sakila.dtos.store.StoreDto;
import gov.iti.jets.sakila.services.StoreService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/stores")
public class StoreController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllStores(){
        return Response.ok()
                .entity(StoreService.INSTANCE.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewStore(StoreDto storeDto){
        return Response.ok()
                .entity(StoreService.INSTANCE.insert(storeDto))
                .build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{storeId}")
    public Response updateStore(@PathParam("storeId") Short storeId, StoreDto storeDto){
        return Response.ok()
                .entity(StoreService.INSTANCE.update(storeId, storeDto))
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{storeId}")
    public Response deleteStore(@PathParam("storeId") Short storeId){
        return Response.ok()
                .entity(StoreService.INSTANCE.deleteById(storeId))
                .build();
    }
}
