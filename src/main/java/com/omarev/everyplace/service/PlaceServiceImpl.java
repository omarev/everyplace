package com.omarev.everyplace.service;

import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlaceServiceImpl implements PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public List<Place> findAll()
    {
        return placeRepository.findAll();
    }

    public Optional<Place> findById(UUID id){
        return placeRepository.findById(id);
    }


//    public Place update (Place updated, Long id) {
//        Place persisted = findById(id);
//        persisted.setName(updated.getName());
//        return save(persisted);
//    }

    public Place save(Place place) {
        return placeRepository.save(place);
    }
}
