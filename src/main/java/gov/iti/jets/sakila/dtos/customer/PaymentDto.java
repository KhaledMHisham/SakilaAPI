package gov.iti.jets.sakila.dtos.customer;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Payment} entity
 */
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PaymentDto implements Serializable {
    private Integer id;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Instant paymentDate;
}