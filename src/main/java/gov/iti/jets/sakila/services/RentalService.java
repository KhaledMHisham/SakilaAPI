package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.rental.RentalDto;
import gov.iti.jets.sakila.mappers.BaseMapper;
import gov.iti.jets.sakila.mappers.RentalMapper;
import gov.iti.jets.sakila.persistence.entities.Rental;
import gov.iti.jets.sakila.persistence.repositories.CrudRepository;
import gov.iti.jets.sakila.persistence.repositories.RentalRepository;

public class RentalService extends BaseService<Rental, RentalDto, Integer>  {

    public static final RentalService INSTANCE = new RentalService();
    public RentalService() {
        super(RentalRepository.getInstance(), RentalMapper.INSTANCE, Rental.class);
    }
}
