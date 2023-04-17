package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.category.CategoryDto;
import gov.iti.jets.sakila.dtos.messages.SuccessMessage;
import gov.iti.jets.sakila.mappers.CategoryMapper;
import gov.iti.jets.sakila.persistence.entities.Category;
import gov.iti.jets.sakila.persistence.repositories.CategoryRepository;
import gov.iti.jets.sakila.persistence.repositories.FilmCategoryRepository;

public class CategoryService extends BaseService<Category, CategoryDto, Short> {

    public final static CategoryService INSTANCE = new CategoryService();
    private final FilmCategoryRepository filmCategoryRepository = FilmCategoryRepository.getInstance();
    private final CategoryRepository categoryRepository = CategoryRepository.getInstance();
    private CategoryService() {
        super(CategoryRepository.getInstance(), CategoryMapper.INSTANCE, Category.class);
    }

    @Override
    public SuccessMessage deleteById(Short categoryId) {
        Category category = categoryRepository.findById(Category.class, categoryId);
        category.getFilmCategories()
                .stream()
                .forEach(filmCategory -> filmCategoryRepository.delete(filmCategory));
        categoryRepository.delete(category);
        return SuccessMessage.getInstance();
    }
}
