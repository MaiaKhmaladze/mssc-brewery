package com.example.msscbrewery.web.services;

import com.example.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService
{

    BeerDto getBeerById( UUID beerId );

    BeerDto saveNewBeer( BeerDto beerDto );

    void updateBeerById( UUID beerId, BeerDto beerDto );

    void deleteBeerById( UUID beerId );
}
