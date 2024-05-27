package com.example.rentify.controller;

import com.example.rentify.model.User;
import com.example.rentify.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}

package com.example.rentify.controller;

import com.example.rentify.model.Property;
import com.example.rentify.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {

    @Autowired
    private PropertyRepository propertyRepository;

    @PostMapping("/post")
    public Property postProperty(@RequestBody Property property) {
        return propertyRepository.save(property);
    }

    @GetMapping("/seller/{sellerId}")
    public List<Property> getPropertiesBySeller(@PathVariable Long sellerId) {
        return propertyRepository.findBySellerId(sellerId);
    }

    @GetMapping("/search")
    public List<Property> searchProperties(
            @RequestParam String city,
            @RequestParam double maxPrice,
            @RequestParam int minBedrooms,
            @RequestParam int minBathrooms) {
        return propertyRepository.findByCityAndPriceLessThanEqualAndBedroomsGreaterThanEqualAndBathroomsGreaterThanEqual(
                city, maxPrice, minBedrooms, minBathrooms);
    }

    @DeleteMapping("/{id}")
    public void deleteProperty(@PathVariable Long id) {
        propertyRepository.deleteById(id);
    }
}