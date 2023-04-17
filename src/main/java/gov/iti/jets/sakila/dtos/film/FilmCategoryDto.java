package gov.iti.jets.sakila.dtos.film;

import gov.iti.jets.sakila.dtos.BaseDto;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.FilmCategory} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmCategoryDto extends BaseDto implements Serializable {
    private CategoryDto category;
}