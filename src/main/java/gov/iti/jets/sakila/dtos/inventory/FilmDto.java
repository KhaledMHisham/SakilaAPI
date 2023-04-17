package gov.iti.jets.sakila.dtos.inventory;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

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
    private Integer releaseYear;
    @NotNull
    private LanguageDto language;
    private Short rentalDuration;
    @NotNull
    private BigDecimal rentalRate;
    private Integer length;
    @NotNull
    private BigDecimal replacementCost;
}