package com.omarev.everyplace.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "places")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="uuid-char")
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Name should not be null")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Description should not be null")
    private String description;

    @Column(nullable = false)
    @NotBlank(message = "Latitude should not be null")
    private String latitude;

    @Column(nullable = false)
    @NotBlank(message = "Longitude should not be null")
    private String longitude;

    @Column(nullable = false)
    private Double rate = 0d;

    //@Column(nullable = false)
    //private User createdBy;

//    @Column(nullable = false)
//    private Date createdAt;
}
