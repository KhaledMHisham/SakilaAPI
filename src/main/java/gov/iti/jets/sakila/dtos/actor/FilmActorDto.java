package gov.iti.jets.sakila.dtos.actor;

import gov.iti.jets.sakila.dtos.BaseDto;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.FilmActor} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmActorDto extends BaseDto implements Serializable {
    private FilmDto film;
}