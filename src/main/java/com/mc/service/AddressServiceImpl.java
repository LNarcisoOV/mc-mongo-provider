package com.mc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mc.model.Address;
import com.mc.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getByZipCode(String zipCode) {
        Query query = new Query();
        query.addCriteria(Criteria.where("zipCode").is(zipCode));
        Address address = (Address) mongoTemplate.find(query, Address.class);
        return address;
    }
}
