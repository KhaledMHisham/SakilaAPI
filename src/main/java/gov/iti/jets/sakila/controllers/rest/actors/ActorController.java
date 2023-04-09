package gov.iti.jets.sakila.controllers.rest.actors;

import gov.iti.jets.sakila.controllers.rest.exceptions.ResourceNotFoundException;
import gov.iti.jets.sakila.services.ActorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import gov.iti.jets.sakila.dtos.ActorDto;
import jakarta.ws.rs.core.Response;
import java.util.NoSuchElementException;

@Path("/actors")
public class ActorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActors(){
        return Response.ok(ActorService.INSTANCE.getAllActors()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertActor(ActorDto actorDto){
        return Response.ok().entity(ActorService.INSTANCE.insertActor(actorDto)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getActorById(@PathParam("id") Integer id){
        try {
            return Response.ok().entity(ActorService.INSTANCE.getActorById(id)).build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateActorById(@PathParam("id") Integer id, ActorDto actorDto){
        try {
            return Response.ok().entity(ActorService.INSTANCE.updateActor(id, actorDto)).build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteActorById(@PathParam("id") Integer id){
        try {
            return Response.ok().entity(ActorService.INSTANCE.deleteActorById(id)).build();
        }
        catch (NoSuchElementException exception){
            throw new ResourceNotFoundException(exception.getMessage());
        }
    }
}
