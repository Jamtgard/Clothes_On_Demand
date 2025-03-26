package org.example.Models.Command;

import org.example.Models.Clothing.Article;

public interface ArticleProcessingCommand {
    Article process(Article article, String value);
}
