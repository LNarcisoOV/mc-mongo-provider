package com.mc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mc.service.AddressService;

@RestController
@RequestMapping("/mongo/address")
public class AddressController {
    
    @Autowired
    private AddressService addressService;

}
