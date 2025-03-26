package org.example.Models.Command;

import org.example.Models.Clothing.Article;
import org.example.Models.Clothing.Skirt;

public class WaistlineCommand implements ArticleProcessingCommand{

    @Override
    public Article process(Article article, String value) {
        ((Skirt) article).setWaistline(value);
        return article;
    }

}
