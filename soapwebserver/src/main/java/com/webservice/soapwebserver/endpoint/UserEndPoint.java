package com.webservice.soapwebserver.endpoint;

import com.webservice.schema.GetUserRequest;
import com.webservice.schema.GetUserResponse;
import com.webservice.soapwebserver.service.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//import com.webservice.soapwebserver.service.UserService;

/**
 * @author : Milan Paudyal
 * @since : 11/13/19, Wed
 **/

@Endpoint
public class UserEndPoint {

    private final UserService userService;

    public UserEndPoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = "http://webservice.com/schema", localPart = "getUserRequest")
    @ResponsePayload // to convert the response into soap
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest userRequest) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUser(userRequest.getName()));
        return response;
    }

}
