package gov.iti.jets.sakila.dtos.payment;

import gov.iti.jets.sakila.dtos.BaseDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for the {@link gov.iti.jets.sakila.persistence.entities.Payment} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto extends BaseDto implements Serializable {
    private Integer id;
    @NotNull
    private CustomerDto customer;
    @NotNull
    private StaffDto staff;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private Instant paymentDate;
}