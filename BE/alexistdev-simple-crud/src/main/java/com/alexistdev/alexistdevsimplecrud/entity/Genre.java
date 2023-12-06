package com.alexistdev.alexistdevsimplecrud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Genre {
    @Id
    private String id;

    @Column(name="name",unique = true)
    private String name;

}
