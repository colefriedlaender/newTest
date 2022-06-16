package com.application.reservationsystem.API;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.application.reservationsystem.model.RestaurantItems;
import com.application.reservationsystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    ItemRepository restaurantItemRepo;

    @GetMapping("/api/all")
    public List<RestaurantItems> all( ) {
        return restaurantItemRepo.findAll().stream().toList();
    }

    @GetMapping("/api/")
    public RestaurantItems findName(@RequestParam(value = "name") String name ) {
        return restaurantItemRepo.findItemByName(name);
    }
}