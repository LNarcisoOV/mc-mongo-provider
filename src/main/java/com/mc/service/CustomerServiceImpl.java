package com.mc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mc.model.Address;
import com.mc.model.Customer;
import com.mc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
    
    public Customer getByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        Customer customer = (Customer) mongoTemplate.find(query, Customer.class);
        return customer;
    }

}
