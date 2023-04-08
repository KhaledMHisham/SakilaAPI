package gov.iti.jets.sakila.persistence.repositories;

public class RentalRepository {
    private static RentalRepository rentalRepository = new RentalRepository();
    private RentalRepository(){}
    public static RentalRepository getInstance(){
        return rentalRepository;
    }
}
