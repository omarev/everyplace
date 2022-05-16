package com.omarev.everyplace.repository;

import com.omarev.everyplace.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID> {
}
