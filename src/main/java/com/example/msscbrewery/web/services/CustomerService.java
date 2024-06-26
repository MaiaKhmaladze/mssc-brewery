package com.example.msscbrewery.web.services;

import com.example.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService
{
    CustomerDto getCustomerById( UUID Id);

    CustomerDto saveNewCustomer( CustomerDto customerDto );

    void updateCustomerById( UUID customerId, CustomerDto customerDto );

    void deleteCustomerById( UUID customerId );
}
