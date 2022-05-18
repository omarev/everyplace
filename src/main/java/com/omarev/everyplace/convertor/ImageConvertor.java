package com.omarev.everyplace.convertor;

import com.omarev.everyplace.dto.place.image.ImageResponse;
import com.omarev.everyplace.entity.PlaceImage;
import org.springframework.stereotype.Component;

@Component
public class ImageConvertor {
    public ImageResponse convert(PlaceImage image){
        return ImageResponse.builder()
            .path(image.getPath())
            .build();
    }
}
