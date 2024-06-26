package com.example.msscbrewery.web.services;

import com.example.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
public class BeerServiceImpl implements BeerService
{
    @Override
    public BeerDto
    getBeerById( UUID beerId )
    {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDto saveNewBeer( BeerDto beerDto )
    {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updateBeerById( UUID beerId, BeerDto beerDto )
    {
        // TODO update beer
    }

    @Override
    public void deleteBeerById( UUID beerId )
    {
        // TODO delete beer
        log.debug("beer is deleted");
    }
}
