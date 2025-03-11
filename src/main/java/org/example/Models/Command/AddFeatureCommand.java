package org.example.Models.Command;

import org.example.Models.Clothing.*;

public class AddFeatureCommand {

    private final String featureOne;
    private final String featureTwo;

    public AddFeatureCommand(String featureOne, String featureTwo) {
        this.featureOne = featureOne;
        this.featureTwo = featureTwo;
    }

    public void execute(Article article) {
        if (article instanceof Pants){
            ((Pants) article).setFit(featureOne);
            ((Pants) article).setLength(featureTwo);
        } else if (article instanceof TShirt) {
            ((TShirt) article).setSleeves(featureOne);
            ((TShirt) article).setNeck(featureTwo);
        } else if (article instanceof Skirt) {
            ((Skirt) article).setWaistline(featureOne);
            ((Skirt) article).setPattern(featureTwo);
        }
    }
}
