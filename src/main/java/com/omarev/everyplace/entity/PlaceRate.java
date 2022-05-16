package com.omarev.everyplace.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "place_rates")
@AllArgsConstructor
@Data
public class PlaceRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double rate;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
