package gov.iti.jets.sakila.persistence.repositories;

public class FilmCategoryRepository {
    private static FilmCategoryRepository filmCategoryRepository = new FilmCategoryRepository();
    private FilmCategoryRepository(){}
    public static FilmCategoryRepository getInstance(){
        return filmCategoryRepository;
    }
}
