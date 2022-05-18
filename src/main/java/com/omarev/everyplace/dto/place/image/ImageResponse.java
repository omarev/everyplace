package com.omarev.everyplace.dto.place.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ImageResponse {
    private String path;
}
