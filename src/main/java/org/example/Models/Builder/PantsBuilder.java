//package org.example.Models.Builder;
//
//import org.example.Models.Clothing.Article;
//import org.example.Models.Clothing.Pants;
//
//public class PantsBuilder extends ArticleBuilder {
//
//
//    @Override
//    public ArticleBuilder createNewArticle(){
//        this.article = new Pants();
//        return this;
//    }
//
//    @Override
//    public ArticleBuilder setSize(String size){
//        article.setSize(size);
//        return this;
//    }
//
//    @Override
//    public ArticleBuilder setMaterial(String material){
//        article.setMaterial(material);
//        return this;
//    }
//
//    @Override
//    public ArticleBuilder setColor(String color){
//        article.setColor(color);
//        return this;
//    }
//
//    @Override
//    public ArticleBuilder setPrice(double price){
//        article.setPrice(price);
//        return this;
//    }
//
//    public PantsBuilder setFit (String fit){
//        ((Pants) article).setFit(fit);
//        return this;
//    }
//
//    public PantsBuilder setFit (String fit){
//        ((Pants) article).setFit(fit);
//        return this;
//    }
//
//    @Override
//    public Article build() {
//        return null;
//    }
//}
