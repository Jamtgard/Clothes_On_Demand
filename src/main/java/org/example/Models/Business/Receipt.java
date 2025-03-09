package org.example.Models.Business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {

    private int id;
    private String name;

    public Receipt() {}
    public Receipt(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void printReciept(){

        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);

        System.out.println("********** KVITTO **********");
        System.out.println("Datum: " + formattedDateTime);
        System.out.println("Kund-ID: " + "customerId");
        System.out.println("----------------------------");
        System.out.println("Varor:");
        System.out.println(" \uD83D\uDC56 Kaffebönor\t\t" + "20" + " SEK");
        System.out.println(" \uD83D\uDC55 Havremjölk\t\t" + "30" + " SEK");
        System.out.println("----------------------------");
        System.out.println("Exkl. moms:\t\t" + "37.5" + " SEK");
        System.out.println("Moms (25%):\t\t" + "12.5" + " SEK");
        System.out.println("----------------------------");
        System.out.println("Totalt:\t\t\t" + "50" + " SEK");
        System.out.println("Tack för ditt köp!");
        System.out.println("****************************");



        //System.out.println(createReciept());
    }

    private String createReciept(){
        return null;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
