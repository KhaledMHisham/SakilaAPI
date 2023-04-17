package gov.iti.jets.sakila.dtos.store;

import gov.iti.jets.sakila.dtos.location.AddressDto;
import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Store} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StoreDto extends BaseDto implements Serializable {
    private Short id;
    @NotNull
    private StaffDto managerStaff;
    @NotNull
    private AddressDto address;
    private Set<StaffDto> staff = new LinkedHashSet<>();
}