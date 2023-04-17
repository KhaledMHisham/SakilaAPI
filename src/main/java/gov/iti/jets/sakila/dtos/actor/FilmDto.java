package gov.iti.jets.sakila.dtos.actor;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Film} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmDto extends BaseDto implements Serializable {
    private Integer id;
    @Size(max = 128)
    @NotNull
    private String title;
    private String description;
    private Integer releaseYear;
    private Integer length;
    @Size(max = 54)
    private String specialFeatures;
}