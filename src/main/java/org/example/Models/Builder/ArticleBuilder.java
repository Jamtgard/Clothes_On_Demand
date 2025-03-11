package org.example.Models.Builder;

import org.example.Models.Clothing.*;

public class ArticleBuilder {

    private Article article;
    private ArticleType articleType;

    public ArticleBuilder setArticleType(ArticleType articleType) {
        if (articleType == null){
            throw new IllegalArgumentException("Artikeltyp får inte vara null!");
        }
        this.articleType = articleType;

        switch (articleType){
            case PANTS:
                this.article = new Pants();
                this.article.setName("Pants");
                break;
            case TSHIRT:
                this.article = new TShirt();
                this.article.setName("T-Shirt");
                break;
            case SKIRT:
                this.article = new Skirt();
                this.article.setName("Skirt");
                break;
        }
        return this;
    }

    public ArticleBuilder setSize(String size) {
        ensureArticleExists();
        article.setSize(size);
        return this;
    }

    public ArticleBuilder setMaterial(String material) {
        ensureArticleExists();
        article.setMaterial(material);
        return this;
    }

    public ArticleBuilder setColor(String color) {
        ensureArticleExists();
        article.setColor(color);
        return this;
    }

    public ArticleBuilder setPrice(double price) {
        ensureArticleExists();
        article.setPrice(price);
        return this;
    }

    public Article build() {
        if (article == null) {
            throw new IllegalStateException("Artikeltyp måste sättas innan `build()` anropas!");
        }
        return article;
    }

    private void ensureArticleExists() {
        if (article == null) {
            throw new IllegalStateException("Artikeltyp måste sättas innan egenskaper kan tilldelas!");
        }
    }
}
