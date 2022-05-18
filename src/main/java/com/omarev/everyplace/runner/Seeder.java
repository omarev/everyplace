package com.omarev.everyplace.runner;

import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    PlaceService placeService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Seeder started");

        System.out.println(UUID.randomUUID());

        //Place place = new Place(UUID.randomUUID(), "Test Place", "Test description", "1", "1", 0d);

        Place place = new Place();
        place.setName("Test Place");
        place.setDescription("Test description");
        place.setLatitude("1");
        place.setLongitude("1");
        place.setRate(0d);

        placeService.save(place);

        Place place2 = new Place(UUID.fromString("3f683a3a-4fe9-49d5-a01e-eb747c466774"),"Test2 Place", "Test2 description", "2", "2", 0d);

        placeService.save(place2);

        System.out.println("Seeder finished!");
    }
}
