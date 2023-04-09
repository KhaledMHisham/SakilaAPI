package gov.iti.jets.sakila.dtos;

import gov.iti.jets.sakila.persistence.entities.Actor;
import gov.iti.jets.sakila.persistence.entities.FilmCategory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Film} entity
 */
@Data
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmDto implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private Integer releaseYear;
    private LanguageDto language;
    private LanguageDto originalLanguage;
    private Short rentalDuration;
    private BigDecimal rentalRate;
    private Integer length;
    private BigDecimal replacementCost;
    private Instant lastUpdate;
    private Set<FilmActorDto> filmActors = new LinkedHashSet<>();
    private Set<FilmCategoryDto> filmCategories = new LinkedHashSet<>();

    @Size(max = 5)
    private String rating;
    @Size(max = 54)
    private String specialFeatures;
}