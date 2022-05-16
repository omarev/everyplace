package com.omarev.everyplace.controller;

import com.omarev.everyplace.convertor.PlaceConvertor;
import com.omarev.everyplace.dto.place.PlaceCreateRequest;
import com.omarev.everyplace.dto.place.PlaceResponse;
import com.omarev.everyplace.dto.place.PlaceUpdateRequest;
import com.omarev.everyplace.exception.RecordNotFoundException;
import com.omarev.everyplace.service.PlaceService;
import com.omarev.everyplace.entity.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping(value = "places")
public class PlaceController {

    @Autowired
    private PlaceConvertor placeConvertor;

    @Autowired
    private PlaceService placeService;

    @GetMapping()
    public List<Place> getPlaces() {

        List<Place> places = placeService.findAll();

        return places;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Place> Read(@PathVariable UUID id) {
        Optional<Place> place = placeService.findById(id);
        return ResponseEntity.of(place);
    }

    @PostMapping()
    ResponseEntity<PlaceResponse> Create(@RequestBody @Valid  PlaceCreateRequest placeCreateRequest) {
        Place place = placeConvertor.convert(placeCreateRequest);

        Place saved = placeService.save(place);

        PlaceResponse placeBody = placeConvertor.convert(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeBody);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<PlaceResponse> Update(@PathVariable UUID id, @RequestBody @Valid PlaceUpdateRequest placeUpdateRequest) {

        Place place = placeService.findById(id).orElseThrow(() -> new RecordNotFoundException(String.format("Place #%s not found", id)));

        Place updatePlace = placeConvertor.convert(placeUpdateRequest, place);

        Place saved = placeService.save(updatePlace);

        PlaceResponse placeResponse = placeConvertor.convert(saved);

        return ResponseEntity.status(HttpStatus.OK).body(placeResponse);
    }

}
