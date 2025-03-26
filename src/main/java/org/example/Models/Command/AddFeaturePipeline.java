package org.example.Models.Command;

import org.example.Models.Clothing.Article;

import java.util.ArrayList;

public class AddFeaturePipeline {
    private ArrayList<ArticleProcessingCommand> pipeline = new ArrayList<>();

    public void addCommand(ArticleProcessingCommand command) {pipeline.add(command);}

    public Article execute(Article article, String[] values) {
        Article result = article;
        for (int i = 0; i < pipeline.size(); i++) {
            result = pipeline.get(i).process(result, values[i]);
        }
        return result;
    }
}
