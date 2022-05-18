package com.omarev.everyplace.convertor;

import com.omarev.everyplace.dto.place.PlaceCreateRequest;
import com.omarev.everyplace.dto.place.PlaceResponse;
import com.omarev.everyplace.dto.place.PlaceUpdateRequest;
import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.entity.PlaceImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PlaceConvertor {

    @Autowired
    private ImageConvertor imageConvertor;

    public Place convert(PlaceCreateRequest request){
        Set images = new HashSet<PlaceImage>();
        return Place.builder()
                .name(request.getName())
                .description(request.getDescription())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .images(images)
                .rate(0d)
                .rateCount(0L)
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
                .images(
                    place.getImages()
                        .stream()
                        .map(image -> imageConvertor.convert(image)).collect(Collectors.toSet())
                )
                .build();
    }
}
