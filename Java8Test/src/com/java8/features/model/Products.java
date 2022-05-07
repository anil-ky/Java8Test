package com.java8.features.model;

public class Products {
    private int id;
    private String model;
    private String camera;
    private Float price;

    public Products(int id, String model, String camera, Float price) {
        this.id = id;
        this.model = model;
        this.camera = camera;
        this.price = price;
    }

    Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
