package org.example.Models.Command;

import org.example.Models.Clothing.Article;
import org.example.Models.Clothing.TShirt;

public class NeckCommand implements ArticleProcessingCommand{

    @Override
    public Article process(Article article, String value) {
        ((TShirt) article).setNeck(value);
        return article;
    }

}
