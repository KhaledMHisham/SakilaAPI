package gov.iti.jets.sakila.controllers.soap.actors;
import gov.iti.jets.sakila.dtos.actor.ActorDto;
import gov.iti.jets.sakila.dtos.actor.FilmDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.services.ActorService;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

import java.util.Collection;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class ActorWebService {
    public Collection<ActorDto> getAllActors(){
        return ActorService.INSTANCE.findAll();
    }

    public ActorDto addNewActor(ActorDto actorDto){
        return ActorService.INSTANCE.insert(actorDto);
    }

    public ActorDto getActorById(Integer id){
        return ActorService.INSTANCE.findById(id);
    }

    public ActorDto updateActor(Integer id, ActorDto actorDto){
        return ActorService.INSTANCE.update(id, actorDto);
    }

    public SuccessMessage deleteActorById(Integer id){
        return ActorService.INSTANCE.deleteById(id);
    }

    public Collection<FilmDto> getAllFilmsByActorId(Integer actorId){
        return ActorService.INSTANCE.getAllFilmsByActorId(actorId);
    }
}
