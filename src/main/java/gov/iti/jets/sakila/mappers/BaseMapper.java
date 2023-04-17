package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.BaseDto;
import gov.iti.jets.sakila.persistence.entities.BaseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.Collection;

public interface BaseMapper<ENTITY extends BaseEntity, DTO extends BaseDto> {
    ENTITY toEntity(DTO dto);

    DTO toDto(ENTITY entity);
    Collection<DTO> collectionToDto(Collection<ENTITY> categories);
    Collection<ENTITY> collectionToEntity(Collection<DTO> categories);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ENTITY partialUpdate(DTO dto, @MappingTarget ENTITY entity);
}