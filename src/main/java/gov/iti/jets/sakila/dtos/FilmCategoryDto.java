package gov.iti.jets.sakila.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.FilmCategory} entity
 */
@Data
public class FilmCategoryDto implements Serializable {
    @Size(max = 25)
    @NotNull
    private CategoryDto category;
}