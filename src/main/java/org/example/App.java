package org.example;

import org.example.Models.Business.Customer;
import org.example.Models.Clothing.Article;
import org.example.Models.Clothing.Pants;
import org.example.Models.Clothing.Skirt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        //Sout & toStringTests.
        /*
        Article pantsTest = new Pants();
        pantsTest.setColor("Green");
        ((Pants) pantsTest).setFit("Loose");
        Article skirtTest = new Skirt();
        skirtTest.setColor("Red");
        ((Skirt) skirtTest).setWaistline("Medium");

        System.out.println(pantsTest.toString());
        System.out.println(skirtTest.toString());

        Customer customer1 = new Customer("Simon", "Claesgatan", "Hackerman1995@msn.se");
        Customer customer2 = new Customer("Robin", "Nobelvägen", "Loket@staten.se");
        Customer customer3 = new Customer("Ebba", "Claesgatan", "kidnappar_barn@staten.se");
        Customer customer4 = new Customer("Kurt", "KoBeinsGatan", "Nirvana@gov.org");
        Customer customer5 = new Customer("Brus", "SpringstensVägen", "sprang_sen_barnsben@knegarna.com");

        System.out.println(customer1.toString());
        System.out.println(customer2.toString());
        System.out.println(customer3.toString());
        System.out.println(customer4.toString());
        System.out.println(customer5.toString());

         */

        /**
         *
         * Systemet ska som grund innehålla följande affärsobjekt (Business Object):
         * Customer, Order, Receipt, CEO, Pants, TShirt, Skirt
         *
         * Dessa bör ligga i lämpliga packages. Med designmönstren tillkommer fler klasser.
         * Väljer ni att skapa applikationen med meny i terminalen, utan JavaFX, får ni skapa lämpliga klasser för detta.
         *
         * Affärsobjekten ska innehålla följande gemensamma attribut:  id, name
         *
         *
         *
         */


        /**
         * Ord för Test:
         *
         * given - given antal hundar = 2
         * when - when result = owner.fetchRandom
         * then - then assertNotNull(result)
         */

        /**
         * MVC: / Paket
         * models - (Affärsobjekt: Customer, Order, Receipt, CEO, Pants, TShirt, Skirt)
         * observer - (Observer-mönster: Observer, Subject, CEO)
         * builder - (Builder-mönster: AbstractClothingBuilder, PantsBuilder, TShirtBuilder, SkirtBuilder)
         * command - (Command-mönster: Command, AddFeatureCommand)
         * main - (Hanterar menylogik och beställningsflöde)
         */

    }
}
