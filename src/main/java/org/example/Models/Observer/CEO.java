package org.example.Models.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {
    private final int id;
    private final String name;

    public CEO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String grayColor = "\u001B[90m";
        String resetColor = "\u001B[0m";

        System.out.println(grayColor + "VD " + name + " notifierad: " + evt.getNewValue() + resetColor);
    }
}
