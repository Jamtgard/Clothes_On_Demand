package org.example.Models.Clothing;

public class TShirt extends Article{

    private String sleeves;
    private String neck;

    public TShirt() {super();}

    public String getSleeves() {return sleeves;}
    public void setSleeves(String sleeves) {this.sleeves = sleeves;}

    public String getNeck() {return neck;}
    public void setNeck(String neck) {this.neck = neck;}

    @Override
    public String toString() {
        return super.toString() + ", Sleeves=" + sleeves + ", Neck=" + neck + "]";
    }
}
