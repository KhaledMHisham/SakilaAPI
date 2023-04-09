package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.CategoryDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.CategoryMapper;
import gov.iti.jets.sakila.persistence.entities.Category;
import gov.iti.jets.sakila.persistence.repositories.CategoryRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;

import java.util.List;

public enum CategoryService {

    INSTANCE;
    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();
    public List<CategoryDto> getAllCategories() {
        List<Category> categories =
                DatabaseExecutor.execute( em ->
                    categoryRepository.findAll(em)
                );
        return categories.stream()
                .map(category -> CategoryMapper.INSTANCE.toDto(category))
                .toList();
    }

    public SuccessMessage addNewCategory(CategoryDto categoryDto){
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        DatabaseExecutor.executeInTransactionWithoutResult(em ->
            categoryRepository.save(category, em)
        );
        return SuccessMessage.getInstance();
    }
}
