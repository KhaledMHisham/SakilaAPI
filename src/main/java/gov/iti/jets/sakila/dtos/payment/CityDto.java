package gov.iti.jets.sakila.dtos.payment;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.City} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto extends BaseDto implements Serializable {
    private Integer id;
    @Size(max = 50)
    @NotNull
    private String city;
    @NotNull
    private CountryDto country;
}