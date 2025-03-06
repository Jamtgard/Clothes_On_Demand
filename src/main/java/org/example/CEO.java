package org.example;

public class CEO {

    private int id;
    private String name;

    public CEO() {}
    public CEO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void approve(){
        System.out.println("Ser bra ut, cashen ska in! *dunk på ryggen* ");
    }
    public void reject(){
        System.out.println("jaha.. får bli övertid för er denna vecka..");
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

}
