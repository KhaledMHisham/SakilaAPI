package gov.iti.jets.sakila.controllers.rest.exceptions.messages;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IllegalDeleteOperationMessage {
    private Integer status;
    private String message;
}
