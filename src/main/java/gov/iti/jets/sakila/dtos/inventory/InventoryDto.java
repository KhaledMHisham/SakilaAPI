package gov.iti.jets.sakila.dtos.inventory;

import gov.iti.jets.sakila.dtos.BaseDto;
import gov.iti.jets.sakila.dtos.inventory.FilmDto;
import gov.iti.jets.sakila.dtos.inventory.StoreDto;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Inventory} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class InventoryDto extends BaseDto implements Serializable {
    private Integer id;
    @NotNull
    private FilmDto film;
    @NotNull
    private StoreDto store;
}