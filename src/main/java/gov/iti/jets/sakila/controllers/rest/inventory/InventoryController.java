package gov.iti.jets.sakila.controllers.rest.inventory;

import gov.iti.jets.sakila.dtos.inventory.InventoryDto;
import gov.iti.jets.sakila.services.InventoryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/inventories")
public class InventoryController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllInventories(){
        return Response.ok()
                .entity(InventoryService.INSTANCE.findAll())
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewInventoryItem(InventoryDto inventoryDto){
        return Response.ok()
                .entity(InventoryService.INSTANCE.insert(inventoryDto))
                .build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{inventoryId}")
    public Response deleteInventoryItem(@PathParam("inventoryId") Integer inventoryId){
        return Response.ok()
                .entity(InventoryService.INSTANCE.deleteById(inventoryId))
                .build();
    }
}
