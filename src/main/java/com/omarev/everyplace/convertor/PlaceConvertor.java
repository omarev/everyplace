package com.omarev.everyplace.convertor;

import com.omarev.everyplace.dto.place.PlaceCreateRequest;
import com.omarev.everyplace.dto.place.PlaceResponse;
import com.omarev.everyplace.dto.place.PlaceUpdateRequest;
import com.omarev.everyplace.entity.Place;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class PlaceConvertor {

    public Place convert(PlaceCreateRequest request){
        return Place.builder()
                .name(request.getName())
                .description(request.getDescription())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .rate(0d)
                //.createdBy()
                //.createdAt(new Date())
                .build();
    }

    public Place convert(PlaceUpdateRequest request, Place place){

        return Place.builder()
                .id(place.getId())
                .name(request.getName())
                .description(request.getDescription())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .rate(place.getRate())
                .build();
    }


    public PlaceResponse convert(Place place){
        return PlaceResponse.builder()
                .id(place.getId())
                .name(place.getName())
                .description(place.getDescription())
                .latitude(place.getLatitude())
                .longitude(place.getLongitude())
                .rate(place.getRate())
                .build();
    }
}
