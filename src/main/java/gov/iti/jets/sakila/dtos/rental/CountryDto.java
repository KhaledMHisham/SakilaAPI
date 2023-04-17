package gov.iti.jets.sakila.dtos.rental;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Country} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CountryDto extends BaseDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String country;
    @NotNull
    private Instant lastUpdate;
}