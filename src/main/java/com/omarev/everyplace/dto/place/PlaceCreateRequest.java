package com.omarev.everyplace.dto.place;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
public class PlaceCreateRequest {

    private UUID id;

    @NotNull(message = "Latitude should not be null")
    private String name;

    @NotNull(message = "Latitude should not be null")
    private String description;

    @NotNull(message = "Latitude should not be null")
    private String latitude;

    @NotBlank(message = "Longitude should not be null")
    private String longitude;

    private Double rate;
}
