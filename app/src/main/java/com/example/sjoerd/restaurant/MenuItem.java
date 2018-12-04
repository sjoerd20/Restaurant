package com.example.sjoerd.restaurant;

public class MenuItem {

    private String name, description, imageURL, category;
    private float price;

    public MenuItem(String name, String description, String imageURL, String category, float price) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.category = category;
        this.price = price;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
