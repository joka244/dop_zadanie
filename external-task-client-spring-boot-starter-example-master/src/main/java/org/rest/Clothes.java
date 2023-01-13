package org.rest;


public class Clothes {
    private String id;
    private String company;
    private String type;
    private String name;
    private String size;
    private Double price;

    public Clothes() {
        this.id = "0000";
        this.company = "";
        this.type = "";
        this.name = "";
        this.size = "";
        this.price = 0.0;
    }

    @Override
    public String toString() {
        return company + " " + type + " " + name
                + " " + size + " "  + price + "P";
    }

    public Clothes(String id, String company, String type, String name, String size, double price) {
        this.id = id;
        this.company = company;
        this.type = type;
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}