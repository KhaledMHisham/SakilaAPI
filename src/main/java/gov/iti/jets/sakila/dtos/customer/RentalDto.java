package gov.iti.jets.sakila.dtos.customer;

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
public class RentalDto implements Serializable {
    private Integer id;
    @NotNull
    private Instant rentalDate;
    private Instant returnDate;
}