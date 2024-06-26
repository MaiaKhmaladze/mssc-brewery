package com.example.msscbrewery.web.controller;

import com.example.msscbrewery.web.model.BeerDto;
import com.example.msscbrewery.web.services.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController
{
    private final BeerService beerService;

    public BeerController(BeerService beerService){
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    ResponseEntity<BeerDto> getBeer( @PathVariable UUID beerId ){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity handlePost( @RequestBody BeerDto beerDto ){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Localtion", "api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    ResponseEntity updateBeer( @PathVariable UUID beerId, @RequestBody BeerDto beerDto ){
        beerService.updateBeerById(beerId, beerDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteBeer( @PathVariable UUID beerId ){
        beerService.deleteBeerById(beerId);
    }
}
