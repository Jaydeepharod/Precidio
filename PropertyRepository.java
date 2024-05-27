package com.example.rentify.repository;

import com.example.rentify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

import com.example.rentify.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByCityAndPriceLessThanEqualAndBedroomsGreaterThanEqualAndBathroomsGreaterThanEqual(
            String city, double price, int bedrooms, int bathrooms);
}
