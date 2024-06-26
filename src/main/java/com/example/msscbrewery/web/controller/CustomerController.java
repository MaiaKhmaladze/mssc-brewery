package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.web.model.CustomerDto;
import com.example.msscbrewery.web.services.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController
{
    private final CustomerService customerService;

    public CustomerController( CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    ResponseEntity<CustomerDto> getCustomer( @PathVariable UUID customerId ){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity handlePost( @RequestBody CustomerDto customerDto ){
        CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/customer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{customerId}"})
    ResponseEntity updateCustomer( @PathVariable UUID customerId, @RequestBody CustomerDto customerDto ){
        customerService.updateCustomerById(customerId, customerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer( @PathVariable UUID customerId ){
        customerService.deleteCustomerById(customerId);
    }
}
