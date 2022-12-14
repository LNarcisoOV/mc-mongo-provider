package com.mc.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mc.model.Customer;
import com.mc.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
    

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
    
    public Customer getByName(String name) {
        LOGGER.info("----- MONGO PROVIDER : FINDING CUSTOMER BY NAME: {} -----", name);
        
        final Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        final Customer customer = (Customer) mongoTemplate.find(query, Customer.class);
        
        LOGGER.info("----- MONGO PROVIDER : CUSTOMER: {} -----", customer.toString());
        
        return customer;
    }

}
