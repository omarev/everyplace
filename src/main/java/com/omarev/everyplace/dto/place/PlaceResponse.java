package com.omarev.everyplace.dto.place;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Data
public class PlaceResponse {
    private UUID id;

    private String name;

    private String description;

    private String latitude;

    private String longitude;

    private Double rate;

    private Set images;
}
