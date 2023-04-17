package gov.iti.jets.sakila.mappers.actor;

import gov.iti.jets.sakila.dtos.actor.ActorDto;
import gov.iti.jets.sakila.mappers.BaseMapper;
import gov.iti.jets.sakila.persistence.entities.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ActorMapper extends BaseMapper<Actor, ActorDto> {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

}