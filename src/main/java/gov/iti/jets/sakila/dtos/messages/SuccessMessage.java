package gov.iti.jets.sakila.dtos.messages;

public class SuccessMessage extends Message{
    private static SuccessMessage instance = new SuccessMessage();
    private SuccessMessage() {
        super.setStatus(200);
        super.setMessage("Success");
    }

    public static SuccessMessage getInstance() {
        return instance;
    }
}
