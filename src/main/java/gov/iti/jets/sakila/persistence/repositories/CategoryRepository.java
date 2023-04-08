package gov.iti.jets.sakila.persistence.repositories;

public class CategoryRepository {

    private static CategoryRepository categoryRepository = new CategoryRepository();
    private CategoryRepository(){}
    public static CategoryRepository getInstance(){
        return categoryRepository;
    }

}
