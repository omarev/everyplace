package com.omarev.everyplace.dto.place;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Data
public class PlaceUpdateRequest {
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
