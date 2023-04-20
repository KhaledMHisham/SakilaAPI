package gov.iti.jets.sakila.controllers.rest.actors;

import gov.iti.jets.sakila.services.ActorService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import gov.iti.jets.sakila.dtos.actor.ActorDto;
import jakarta.ws.rs.core.Response;

@Path("/actors")
public class ActorController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllActors(){
        return Response.ok(ActorService.INSTANCE.findAll()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addNewActor(ActorDto actorDto){
        return Response.ok().entity(ActorService.INSTANCE.insert(actorDto)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response getActorById(@PathParam("id") Integer id){
        return Response.ok().entity(ActorService.INSTANCE.findById(id)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response updateActor(@PathParam("id") Integer id, ActorDto actorDto){
        return Response.ok().entity(ActorService.INSTANCE.update(id, actorDto)).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Response deleteActorById(@PathParam("id") Integer id){
        return Response.ok().entity(ActorService.INSTANCE.deleteById(id)).build();
    }
}
