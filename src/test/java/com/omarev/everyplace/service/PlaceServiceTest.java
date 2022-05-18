package com.omarev.everyplace.service;

import com.omarev.everyplace.entity.Place;
import com.omarev.everyplace.repository.PlaceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaceServiceTest {

    @Mock
    private PlaceRepository placeRepository;
    private PlaceService placeService;

    @BeforeEach
    public void setUp() {
        placeService = new PlaceServiceImpl(placeRepository);
    }

    @Test
    public void verifyFindAll() {
        when(placeRepository.findAll()).thenReturn(List.of(Place.builder().build()));
        List<Place> all = placeService.findAll();

        verify(placeRepository,times(1)).findAll();
    }
}