package gov.iti.jets.sakila.dtos.store;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Staff} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StaffDto extends BaseDto implements Serializable {
    private Short id;
    @Size(max = 45)
    @NotNull
    private String firstName;
    @Size(max = 45)
    @NotNull
    private String lastName;
    @Size(max = 50)
    private String email;
    @NotNull
    private Boolean active;
    @Size(max = 16)
    @NotNull
    private String username;
}