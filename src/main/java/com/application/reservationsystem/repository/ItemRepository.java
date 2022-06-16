package com.application.reservationsystem.repository;

import com.application.reservationsystem.model.RestaurantItems;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<RestaurantItems, String> {

    @Query("{name:'?0'}")
    RestaurantItems findItemByName(String name);

    @Query("{address:'?0'}")
    List<RestaurantItems> findAll(String address);

    public long count();

}