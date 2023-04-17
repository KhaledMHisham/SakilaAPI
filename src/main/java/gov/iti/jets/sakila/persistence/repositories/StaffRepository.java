package gov.iti.jets.sakila.persistence.repositories;

import gov.iti.jets.sakila.persistence.entities.Staff;

public class StaffRepository extends CrudRepository<Staff, Short>{
    private static StaffRepository staffRepository = new StaffRepository();
    private StaffRepository(){}
    public static StaffRepository getInstance(){
        return staffRepository;
    }
}
