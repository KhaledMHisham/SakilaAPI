package gov.iti.jets.sakila.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Language} entity
 */
@Data
public class LanguageDto implements Serializable {
    private Short id;
    @Size(max = 20)
    @NotNull
    private String name;
    @NotNull
    private Instant lastUpdate;
}