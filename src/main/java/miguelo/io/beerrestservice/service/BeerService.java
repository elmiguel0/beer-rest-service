package miguelo.io.beerrestservice.service;

import java.util.List;
import java.util.UUID;

import miguelo.io.beerrestservice.model.Beer;

public interface BeerService {

    List<Beer> listBeers();
    
    Beer getBeerById(UUID id);
    
}
