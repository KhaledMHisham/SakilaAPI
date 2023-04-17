package gov.iti.jets.sakila.dtos.film;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Film} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmDto extends BaseDto  implements Serializable {
    private Integer id;
    @Size(max = 128)
    @NotNull
    private String title;
    private String description;
    private Integer releaseYear;
    @NotNull
    private LanguageDto language;
    private LanguageDto originalLanguage;
    private Short rentalDuration;
    @NotNull
    private BigDecimal rentalRate;
    private Integer length;
    @NotNull
    private BigDecimal replacementCost;
    @Size(max = 5)
    private String rating;
    @Size(max = 54)
    private String specialFeatures;
    @NotNull
    private Instant lastUpdate;
    private Set<InventoryDto> inventories;
    private Set<FilmActorDto> filmActors;
    private Set<FilmCategoryDto> filmCategories;
}