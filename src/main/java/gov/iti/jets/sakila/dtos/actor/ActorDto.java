package gov.iti.jets.sakila.dtos.actor;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Actor} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActorDto extends BaseDto implements Serializable {
    private Integer id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @NotNull
    private Instant lastUpdate;
    private Set<FilmActorDto> filmActors;
}