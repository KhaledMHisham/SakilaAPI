package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Actor;

public class AddressRepository {
    private static AddressRepository addressRepository = new AddressRepository();
    private AddressRepository(){}
    public static AddressRepository getInstance(){
        return addressRepository;
    }
}