package com.example.oauth2demo.controller;

import com.example.oauth2demo.module.TestUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
public class TestController {

    @RequestMapping(path = "/test/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TestUser getTestUser(@PathVariable("name") String name) {
        return new TestUser(name);
    }
}
