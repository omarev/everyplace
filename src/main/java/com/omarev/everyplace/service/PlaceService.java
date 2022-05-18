package com.omarev.everyplace.service;

import com.omarev.everyplace.entity.Place;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlaceService {

    public List<Place> findAll();

    public Optional<Place> findById(UUID id);

    public Place save(Place place);
}
