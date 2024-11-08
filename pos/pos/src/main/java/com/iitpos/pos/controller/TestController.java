package com.iitpos.pos.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")

public class TestController {

    //gives the end points for Mappings
    @GetMapping(path ="get-text" )
    public String getMyText(){
        return "Hello World!..";
    }
    @GetMapping("get-name")
    public String getMyName(){
        return "Kamal";
    }
}
