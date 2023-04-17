package gov.iti.jets.sakila.dtos.film;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Category} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDto extends BaseDto implements Serializable {
    private Short id;
    @Size(max = 25)
    @NotNull
    private String name;
}