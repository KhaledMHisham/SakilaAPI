package gov.iti.jets.sakila.controllers.rest.exceptions.messages;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundMessage {
    private Integer status;
    private String message;

}
