package com.webservice.soapclient.client;

import com.webservice.soapclient.schema.GetUserRequest;
import com.webservice.soapclient.schema.GetUserResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author : Milan Paudyal
 * @since : 11/13/19, Wed
 **/

@Service
public class SoapClient {

    private WebServiceTemplate webServiceTemplate;

    public SoapClient(Jaxb2Marshaller marshaller) {
        webServiceTemplate = new WebServiceTemplate(marshaller);
    }

    public GetUserResponse getUserDetail(String name) {
        GetUserRequest request = new GetUserRequest();
        request.setName(name);
        return (GetUserResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8081/soapWS", request);
        //return userResponse.getUser();
    }

}