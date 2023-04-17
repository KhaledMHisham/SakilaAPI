package gov.iti.jets.sakila.dtos.rental;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Rental} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RentalDto extends BaseDto implements Serializable {
    private Integer id;
    @NotNull
    private Instant rentalDate;
    @NotNull
    private InventoryDto inventory;
    @NotNull
    private CustomerDto customer;
    private Instant returnDate;
    @NotNull
    private StaffDto staff;
    @NotNull
    private Instant lastUpdate;
}