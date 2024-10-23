package com.example.pz_9;

public class User {
    private String name;
    private String description;
    private int imageResId;

    public User(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Геттеры
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getImageResId() { return imageResId; }
}
