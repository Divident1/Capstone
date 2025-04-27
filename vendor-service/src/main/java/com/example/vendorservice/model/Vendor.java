package com.example.vendorservice.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category; // e.g., Decorator, DJ, Photographer
    private String description;
    private double price;
    private String contact;
    private String email;

    private String imageUrl;
    
    
}
