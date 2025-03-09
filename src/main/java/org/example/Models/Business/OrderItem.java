package org.example.Models.Business;

public class OrderItem {

    private String type;
    private String size;
    private String material;
    private String color;
    private String specificOne;
    private String specificTwo;

    public OrderItem(String type, String size, String material, String color, String specificOne, String specificTwo) {
        this.type = type;
        this.size = size;
        this.material = material;
        this.color = color;
        this.specificOne = specificOne;
        this.specificTwo = specificTwo;
    }

    public String getType() {return type;}
    public String getSize() {return size;}
    public String getMaterial() {return material;}
    public String getColor() {return color;}
    public String getSpecificOne() {return specificOne;}
    public String getSpecificTwo() {return specificTwo;}

    @Override
    public String toString() {
        return type + " (" + size + ", " + material + ", " + color + ", " + specificOne + ", " + specificTwo + ")";
    }
}
