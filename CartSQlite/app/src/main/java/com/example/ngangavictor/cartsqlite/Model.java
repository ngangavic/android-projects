package com.example.ngangavictor.cartsqlite;

public class Model {
    private String id;
    private String name;
    private String price;
    private String quantity;

    public Model(String id,String name, String price, String quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }


}
