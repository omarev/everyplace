package com.omarev.everyplace.runner;

import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.entity.PlaceImage;
import com.omarev.everyplace.entity.User;
import com.omarev.everyplace.service.PlaceService;
import com.omarev.everyplace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class Seeder implements CommandLineRunner {

    @Autowired
    PlaceService placeService;

    @Autowired
    UserService userService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Seeder started");

        System.out.println("Seed places");

        Place sofia = new Place();
        sofia.setName("Test Place");
        sofia.setDescription("Test description");
        sofia.setLatitude("1");
        sofia.setLongitude("1");
        sofia.setRate(0d);
        sofia.setRateCount(0L);

        Place savedPlace = placeService.save(sofia);

        System.out.println(savedPlace.getId());

        Set images = new HashSet<PlaceImage>();
        images.add(
            PlaceImage.builder()
                .place(savedPlace.getId())
                .path("https://en.wikipedia.org/wiki/Sofia#/media/File:Sofia_333.jpg")
                .build()
        );
        savedPlace.setImages(images);

        placeService.save(savedPlace);

        Place varna = new Place(
            UUID.fromString("3f683a3a-4fe9-49d5-a01e-eb747c466774"),
            "Varna",
            "Test2 description",
            "2",
            "2",
            0d,
            0L,
                null
        );

        placeService.save(varna);

        Set varnaImages = new HashSet<PlaceImage>();
        images.add(
            PlaceImage.builder()
                .place(savedPlace.getId())
                .path("https://en.wikipedia.org/wiki/Varna,_Bulgaria#/media/File:Varna-Collage-TB.jpg")
                .build()
        );
        savedPlace.setImages(images);

        placeService.save(savedPlace);

        System.out.println("Seed users");
        User user = User.builder().username("user").password("password").build();

        userService.save(user);

        System.out.println("Seeder finished!");
    }
}
