package com.application.reservationsystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryitems")
public class RestaurantItems {

    @Id
    private String id;

    private String name;
    private String website;
    private String address;
    private int avalibleTables;

    public RestaurantItems(String id, String name, String website, String address, int avalibleTables) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.address = address;
        this.avalibleTables = avalibleTables;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAvalibleTables() {
        return avalibleTables;
    }

    public void setAvalibleTables(int avalibleTables) {
        this.avalibleTables = avalibleTables;
    }
}