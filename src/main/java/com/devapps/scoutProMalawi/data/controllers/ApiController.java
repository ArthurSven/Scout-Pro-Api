package com.devapps.scoutProMalawi.data.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {



    @GetMapping(value = "/")
    public String getPage() {
        return "ScoutPro Api is Running";
    }

}
