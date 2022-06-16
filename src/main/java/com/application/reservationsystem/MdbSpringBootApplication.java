package com.application.reservationsystem;

import com.application.reservationsystem.model.RestaurantItems;
import com.application.reservationsystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class MdbSpringBootApplication implements CommandLineRunner {

    @Autowired
    ItemRepository restaurantItemRepo;

    public static void main(String[] args) {
        SpringApplication.run(MdbSpringBootApplication.class, args);
    }

    public void run(String... args) {

        System.out.println("-------------CREATE Restaurant ITEMS-------------------------------\n");

        //createRestaurantItems();

        System.out.println("\n----------------SHOW ALL Restaurant ITEMS---------------------------\n");

        showAllRestaurantItems();

        System.out.println("\n--------------GET ITEM BY NAME-----------------------------------\n");

        getRestaurantItemByName("Whole Wheat Biscuit");

        System.out.println("\n-----------GET ITEMS BY CATEGORY---------------------------------\n");

        System.out.println("\n-----------UPDATE CATEGORY NAME OF SNACKS CATEGORY----------------\n");

        System.out.println("\n----------DELETE A Restaurant ITEM----------------------------------\n");

        deleteRestaurantItem("Kodo Millet");

        System.out.println("\n------------FINAL COUNT OF Restaurant ITEMS-------------------------\n");

        findCountOfRestaurantItems();

        System.out.println("\n-------------------THANK YOU---------------------------");

    }

    /*//CREATE
    void createRestaurantItems() {
        System.out.println("Data creation started...");
        restaurantItemRepo.save(new RestaurantItems());
        restaurantItemRepo.save(new RestaurantItems());
        restaurantItemRepo.save(new RestaurantItems());
        restaurantItemRepo.save(new RestaurantItems());
        restaurantItemRepo.save(new RestaurantItems());
        System.out.println("Data creation complete...");
    }*/

    // READ
    // 1. Show all the data
    public void showAllRestaurantItems() {
        restaurantItemRepo.findAll().forEach(item -> item.getWebsite());
    }

    // 2. Get item by name
    public void getRestaurantItemByName(String name) {
        System.out.println("Getting item by name: " + name);
        RestaurantItems item = restaurantItemRepo.findItemByName(name);
       // System.out.println(getItemDetails(item));
    }

    // 3. Get count of documents in the collection
    public void findCountOfRestaurantItems() {
        long count = restaurantItemRepo.count();
        System.out.println("Number of documents in the collection: " + count);
    }

   /* // Print details in readable form

    public String getItemDetails(RestaurantItems item) {

        System.out.println(
                "Item Name: " + item.getName() +
                        ", \nWebsite: " + item.getWebsite() +
                        ", \nAddress: " + item.getAddress()
        );
        return "";
    }*/


    // DELETE
    public void deleteRestaurantItem(String id) {
        restaurantItemRepo.deleteById(id);
        System.out.println("Item with id " + id + " deleted...");
    }
}