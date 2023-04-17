package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Actor;
import gov.iti.jets.sakila.persistence.entities.Address;
import jakarta.persistence.EntityManager;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class AddressRepository extends CrudRepository<Address, Integer> {
    private static AddressRepository addressRepository = new AddressRepository();
    private AddressRepository(){}
    public static AddressRepository getInstance(){
        return addressRepository;
    }

    @Override
    public Address insert(Address obj) {
        obj.setLocation(new byte[]{0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        return super.insert(obj);
    }
}