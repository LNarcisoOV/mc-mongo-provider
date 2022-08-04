package com.mc.service;

import com.mc.model.Customer;

public interface CustomerService {
    Customer getByName(String name);
}
