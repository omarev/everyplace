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
        sofia.setName("Sofia");
        sofia.setDescription("Sofia is the capital and largest city of Bulgaria. It is situated in the Sofia Valley at the foot of the Vitosha mountain in the western parts of the country.");
        sofia.setLatitude("1");
        sofia.setLongitude("1");
        sofia.setRate(0d);
        sofia.setRateCount(0L);

        Place savedSofia = placeService.save(sofia);

        System.out.println(savedSofia.getId());

        Set images = new HashSet<PlaceImage>();
        images.add(
            PlaceImage.builder()
                .place(savedSofia.getId())
                .path("https://en.wikipedia.org/wiki/Sofia#/media/File:Sofia_333.jpg")
                .build()
        );
        images.add(
            PlaceImage.builder()
                .place(savedSofia.getId())
                .path("https://upload.wikimedia.org/wikipedia/commons/d/d2/BusinessParkSofia_view3.jpg")
                .build()
        );


        savedSofia.setImages(images);

        placeService.save(savedSofia);

        Place varna = new Place(
            UUID.fromString("3f683a3a-4fe9-49d5-a01e-eb747c466774"),
            "Varna",
            "Varna is the third-largest city in Bulgaria and the largest city and seaside resort on the Bulgarian Black Sea Coast and in the Northern Bulgaria region.",
            "2",
            "2",
            0d,
            0L,
                null
        );

        Place varnaSaved = placeService.save(varna);

        Set varnaImages = new HashSet<PlaceImage>();
        varnaImages.add(
            PlaceImage.builder()
                .place(varnaSaved.getId())
                .path("https://en.wikipedia.org/wiki/Varna,_Bulgaria#/media/File:Varna-Collage-TB.jpg")
                .build()
        );
        varnaSaved.setImages(varnaImages);

        placeService.save(varnaSaved);

        System.out.println("Seed users");
        User user = User.builder().username("user").password("password").build();

        userService.save(user);

        System.out.println("Seeder finished!");
    }
}
