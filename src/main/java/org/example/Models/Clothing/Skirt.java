package org.example.Models.Clothing;

public class Skirt extends Article {

    private String waistline;
    private String pattern;

    public Skirt(){super();}

    public String getWaistline() {return waistline;}
    public void setWaistline(String waistline) {this.waistline = waistline;}

    public String getPattern() {return pattern;}
    public void setPattern(String pattern) {this.pattern = pattern;}

    @Override
    public String toString() {
        return super.toString() + ", Waistline=" + waistline + ", Pattern=" + pattern + "]";
    }
}
