package gov.iti.jets.sakila.mappers;

import gov.iti.jets.sakila.dtos.category.CategoryDto;
import gov.iti.jets.sakila.persistence.entities.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper extends BaseMapper<Category, CategoryDto> {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

}