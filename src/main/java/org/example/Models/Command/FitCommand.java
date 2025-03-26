package org.example.Models.Command;

import org.example.Models.Clothing.Article;
import org.example.Models.Clothing.Pants;

public class FitCommand implements ArticleProcessingCommand{

    @Override
    public Article process(Article article, String value) {
        ((Pants) article).setFit(value);
        return article;

    }
}
