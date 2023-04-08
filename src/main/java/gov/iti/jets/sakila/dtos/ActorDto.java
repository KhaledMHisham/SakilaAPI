package gov.iti.jets.sakila.dtos;

import gov.iti.jets.sakila.persistence.entities.Actor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Actor} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ActorDto implements Serializable {
    private Integer id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @NotNull
    private Instant lastUpdate;
}