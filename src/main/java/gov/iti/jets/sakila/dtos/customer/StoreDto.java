package gov.iti.jets.sakila.dtos.customer;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Store} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StoreDto implements Serializable {
    private Short id;
    @NotNull
    private AddressDto address;
}