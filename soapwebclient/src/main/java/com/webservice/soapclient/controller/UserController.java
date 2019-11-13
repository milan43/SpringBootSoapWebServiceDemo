package com.webservice.soapclient.controller;

import com.webservice.soapclient.client.SoapClient;
import com.webservice.soapclient.schema.GetUserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Milan Paudyal
 * @since : 11/13/19, Wed
 **/

@RestController
public class UserController {

    private final SoapClient soapClient;

    public UserController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @GetMapping("/students/{name}")
    public GetUserResponse getStudent(@PathVariable String name) {
        return soapClient.getUserDetail(name);
    }

}
