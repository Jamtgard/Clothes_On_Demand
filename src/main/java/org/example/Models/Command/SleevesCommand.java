package org.example.Models.Command;

import org.example.Models.Clothing.Article;
import org.example.Models.Clothing.TShirt;

public class SleevesCommand implements ArticleProcessingCommand{

    @Override
    public Article process(Article article, String value) {
        ((TShirt) article).setSleeves(value);
        return article;
    }

}
