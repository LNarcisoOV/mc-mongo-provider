package com.mc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mc.service.CustomerService;

@RestController
@RequestMapping("/mongo/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String test() {
        return "HELLOW WORLD.";
    }
}
