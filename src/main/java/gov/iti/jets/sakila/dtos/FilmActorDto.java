package gov.iti.jets.sakila.dtos;

import gov.iti.jets.sakila.dtos.ActorDto;
import gov.iti.jets.sakila.persistence.entities.FilmActor;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link FilmActor} entity
 */
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmActorDto implements Serializable {
    private ActorDto actor;
}