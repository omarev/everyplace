package com.omarev.everyplace;

import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SeedConsoleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SeedConsoleApplication.class, args);
    }

    @Autowired
    PlaceService placeService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TEST");

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


    }
}
