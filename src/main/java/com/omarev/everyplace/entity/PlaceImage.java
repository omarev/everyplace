package com.omarev.everyplace.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "place_images")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlaceImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ToString.Exclude
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "place_id", nullable = false)
//    private Place place;

    @Type(type="uuid-char")
    @Column(columnDefinition = "VARCHAR(36)", name = "place_id")
    private UUID place;

    @Column
    private String path;
}
