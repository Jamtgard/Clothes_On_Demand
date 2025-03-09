package org.example.Models.Clothing;

public abstract class Article {

    private static int articleCounter = 1;

    private final int id;
    private String name;
    private double price;
    private String size;
    private String material;
    private String color;

    public Article(){
        this.id = articleCounter++;
    }

    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public String getSize() {return size;}
    public void setSize(String size) {this.size = size;}

    public String getMaterial() {return material;}
    public void setMaterial(String material) {this.material = material;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    @Override
    public String toString() {
        return name + " [ID=" + id +
                ", Size=" + size +
                ", Material=" + material +
                ", Color=" + color +
                ", Price=" + price + " SEK]";
    }
}
