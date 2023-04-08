package gov.iti.jets.sakila.dtos.messages;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class ResourceCreatedMessage extends Message{
    private static ResourceCreatedMessage instance = new ResourceCreatedMessage();
    public ResourceCreatedMessage(){
        super.setStatus(201);
        super.setMessage("Resource Created Successfully");
    }
    public static ResourceCreatedMessage getInstance(){
        return instance;
    }
}
