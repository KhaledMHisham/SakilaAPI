package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Rental;

public class RentalRepository extends CrudRepository<Rental, Integer>{
    private static RentalRepository rentalRepository = new RentalRepository();
    private RentalRepository(){}
    public static RentalRepository getInstance(){
        return rentalRepository;
    }
}
