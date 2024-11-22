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
    //here, reason of the usage of *GetMapping* is its reads the data from database
    //post-save data to the database
    //put-update the database
    //Delete-delete from the database
    @GetMapping(path ="/get-text" )
    public String getMyText(){
        return "Hello World!..";
    }
    @GetMapping("/get-name")
    public String getMyName(){
        return "Kamal";
    }
    
}
