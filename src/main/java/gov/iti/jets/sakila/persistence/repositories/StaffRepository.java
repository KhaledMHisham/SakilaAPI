package gov.iti.jets.sakila.persistence.repositories;

public class StaffRepository {
    private static StaffRepository staffRepository;
    private StaffRepository(){}
    public static StaffRepository getInstance(){
        return staffRepository;
    }
}
