package gov.iti.jets.sakila.controllers.soap;
import jakarta.annotation.Resource;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.xml.ws.WebServiceContext;
import jakarta.xml.ws.handler.MessageContext;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class AccountService {

    @Resource
    private WebServiceContext webServiceContext;

    public String getActorInfos(String shit){
        return shit+"FROM SERVER";
    }
}
