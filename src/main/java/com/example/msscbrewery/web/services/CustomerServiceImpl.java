package com.example.msscbrewery.web.services;

import com.example.msscbrewery.web.model.BeerDto;
import com.example.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService
{
    @Override
    public CustomerDto getCustomerById( UUID customerId )
    {
        return CustomerDto.builder().id(UUID.randomUUID())
                .name("Customer A")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer( CustomerDto customerDto )
    {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateCustomerById( UUID customerId, CustomerDto customerDto )
    {
        //updatecustomer
    }

    @Override
    public void deleteCustomerById( UUID customerId )
    {
        log.debug("beer is deleted");
    }

}
