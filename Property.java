package com.example.rentify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String userType; // 'buyer' or 'seller'

    // Getters and setters
}

@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String type;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private double price;
    private double area;
    private int bedrooms;
    private int bathrooms;
    private String hospitals;
    private String colleges;
    private Long sellerId; // ID of the seller

    // Getters and setters
}
