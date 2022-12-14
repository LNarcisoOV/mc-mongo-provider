package com.mc.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.mc.model.Address;
import com.mc.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
    

    private static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    public Address getByZipCode(String zipCode) {
        LOGGER.info("----- MONGO PROVIDER : FINDING ADDRESS BY ZIPCODE -----");
        final Query query = new Query();
        query.addCriteria(Criteria.where("zipCode").is(zipCode));
        final Address address = (Address) mongoTemplate.find(query, Address.class);
        return address;
    }
}
