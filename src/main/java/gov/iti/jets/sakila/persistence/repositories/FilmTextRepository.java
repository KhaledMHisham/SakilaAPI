package gov.iti.jets.sakila.persistence.repositories;

public class FilmTextRepository {
    private static FilmTextRepository filmTextRepository = new FilmTextRepository();
    private FilmTextRepository(){}
    public static FilmTextRepository getInstance(){
        return filmTextRepository;
    }

}
