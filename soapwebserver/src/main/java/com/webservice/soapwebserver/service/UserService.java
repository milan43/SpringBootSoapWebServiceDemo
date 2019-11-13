package com.webservice.soapwebserver.service;

import com.webservice.schema.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Milan Paudyal
 * @since : 11/13/19, Wed
 **/

@Service
public class UserService {

    private final Map<String, User> userMap = new HashMap<>();

    @PostConstruct
    public void initialize() {
        User u1 = new User();
        u1.setId(1);
        u1.setName("Jack");
        u1.setSalary(10000.0);

        User u2 = new User();
        u2.setId(2);
        u2.setName("Lary");
        u2.setSalary(30000.0);

        User u3 = new User();
        u3.setId(3);
        u3.setName("Nikola");
        u3.setSalary(20000.0);

        userMap.put(u1.getName(), u1);
        userMap.put(u2.getName(), u2);
        userMap.put(u3.getName(), u3);
    }

    public User getUser(String name) {
        return userMap.get(name);
    }

}
