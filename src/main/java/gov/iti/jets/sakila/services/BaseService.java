package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.BaseDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.BaseMapper;
import gov.iti.jets.sakila.persistence.entities.BaseEntity;
import gov.iti.jets.sakila.persistence.repositories.CrudRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;
import java.util.Collection;
import java.util.List;

public abstract class BaseService<ENTITY extends BaseEntity, DTO extends BaseDto, ID> {
    private CrudRepository<ENTITY, ID> crudRepository;
    private BaseMapper<ENTITY, DTO> baseMapper;
    private Class<ENTITY> classObj;

    public BaseService(CrudRepository<ENTITY, ID> crudRepository,
                       BaseMapper<ENTITY, DTO> baseMapper,
                       Class<ENTITY> classObj) {
        this.crudRepository = crudRepository;
        this.baseMapper = baseMapper;
        this.classObj = classObj;
    }

    public Collection<DTO> findAll(){
        List<ENTITY> baseEntities = crudRepository.findAll(classObj);
        return baseMapper.collectionToDto(baseEntities);
    }

    public DTO insert(DTO baseDto){
        ENTITY baseEntity = baseMapper.toEntity(baseDto);
        baseEntity = crudRepository.insert(baseEntity);
        return baseMapper.toDto(baseEntity);
    }

    public DTO update(ID id, DTO baseDto){
        ENTITY entity = crudRepository.findById(classObj, id);
        baseMapper.partialUpdate(baseDto, entity);
        crudRepository.update(entity);
        return baseMapper.toDto(entity);
    }
    public DTO findById(ID id){
        ENTITY baseEntity = crudRepository.findById(classObj, id);
        return baseMapper.toDto(baseEntity);
    }
    public SuccessMessage deleteById(ID id){
        crudRepository.deleteById(classObj, id);
        return SuccessMessage.getInstance();
    }
}
