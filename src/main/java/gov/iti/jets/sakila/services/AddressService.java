package gov.iti.jets.sakila.services;

import gov.iti.jets.sakila.dtos.location.AddressDto;
import gov.iti.jets.sakila.mappers.AddressMapper;
import gov.iti.jets.sakila.persistence.entities.Address;
import gov.iti.jets.sakila.persistence.entities.City;
import gov.iti.jets.sakila.persistence.repositories.AddressRepository;
import gov.iti.jets.sakila.persistence.repositories.CityRepository;

import java.util.Collection;

public class AddressService extends BaseService<Address, AddressDto, Integer> {
    public static final AddressService INSTANCE = new AddressService();
    private final CityRepository cityRepository = CityRepository.getInstance();
    private final AddressRepository addressRepository = AddressRepository.getInstance();
    private final AddressMapper addressMapper = AddressMapper.INSTANCE;
    private AddressService(){
        super(AddressRepository.getInstance(), AddressMapper.INSTANCE, Address.class);
    }
    public Collection<AddressDto> findAllAddressesByCityId(Integer cityId) {
        City city = cityRepository.findById(City.class, cityId);
        System.out.println(city.getAddresses().stream().findFirst().get());
        return AddressMapper.INSTANCE.collectionToDto(city.getAddresses());
    }
}
