package org.example.Models.Clothing;

public class Pants extends Article{

    private String fit;
    private String length;

    public Pants() {super();}

    public String getFit(){return fit;}
    public void setFit(String fit){this.fit=fit;}

    public String getLength(){return length;}
    public void setLength(String length){this.length=length;}

    @Override
    public String toString() {
        return super.toString() + ", Fit=" + fit + ", Length=" + length + "]";
    }
}
