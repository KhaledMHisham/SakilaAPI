package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.persistence.entities.Actor;
import gov.iti.jets.sakila.dtos.ActorDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ActorMapper {

    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    Actor toEntity(ActorDto actorDto);

    ActorDto toDto(Actor actor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Actor partialUpdate(ActorDto actorDto, @MappingTarget Actor actor);
}