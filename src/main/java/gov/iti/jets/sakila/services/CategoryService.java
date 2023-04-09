package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.CategoryDto;
import gov.iti.jets.sakila.dtos.messages.ResourceCreatedMessage;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.CategoryMapper;
import gov.iti.jets.sakila.persistence.entities.Category;
import gov.iti.jets.sakila.persistence.repositories.CategoryRepository;
import gov.iti.jets.sakila.persistence.repositories.FilmCategoryRepository;
import gov.iti.jets.sakila.persistence.utils.DatabaseExecutor;

import java.util.List;

public enum CategoryService {

    INSTANCE;
    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();
    private final FilmCategoryRepository filmCategoryRepository = FilmCategoryRepository.getInstance();
    public List<CategoryDto> getAllCategories() {
        List<Category> categories =
                DatabaseExecutor.execute( em ->
                    categoryRepository.findAll(em)
                );
        return categories.stream()
                .map(category -> CategoryMapper.INSTANCE.toDto(category))
                .toList();
    }

    public ResourceCreatedMessage addNewCategory(CategoryDto categoryDto){
        Category category = CategoryMapper.INSTANCE.toEntity(categoryDto);
        DatabaseExecutor.executeInTransactionWithoutResult(em ->
            categoryRepository.save(category, em)
        );
        return ResourceCreatedMessage.getInstance();
    }

    public SuccessMessage updateCategory(Short categoryId, CategoryDto categoryDto) {
        DatabaseExecutor.executeInTransactionWithoutResult(em -> {
                Category category = categoryRepository.findById(categoryId, em);
                CategoryMapper.INSTANCE.partialUpdate(categoryDto, category);
                categoryRepository.save(category, em);
            }
        );
        return SuccessMessage.getInstance();
    }

    public SuccessMessage deleteCategory(Short categoryId) {
        DatabaseExecutor.executeInTransactionWithoutResult(em->{
            Category category = categoryRepository.findById(categoryId, em);
            category.getFilmCategories()
                    .stream()
                    .forEach(filmCategory -> filmCategoryRepository.remove(filmCategory, em));
            categoryRepository.remove(category, em);
        });
        return SuccessMessage.getInstance();
    }
}
