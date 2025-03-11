package org.example.Models.Builder;

import org.example.Models.Clothing.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleBuilderTest {

    private ArticleBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new ArticleBuilder();
    }

    @Test
    void setArticleTypeShouldCreateChoosenArticle() {
        builder.setArticleType(ArticleType.PANTS);
        Article pants = builder.build();
        assertTrue(pants instanceof Pants);
        assertEquals("Pants", pants.getName());

        builder.setArticleType(ArticleType.TSHIRT);
        Article tshirt = builder.build();
        assertTrue(tshirt instanceof TShirt);
        assertEquals("T-Shirt", tshirt.getName());

        builder.setArticleType(ArticleType.SKIRT);
        Article skirt = builder.build();
        assertTrue(skirt instanceof Skirt);
        assertEquals("Skirt", skirt.getName());
    }

    @Test
    void setArticleTypeShouldThrowExceptionIfNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> builder.setArticleType(null));
        assertEquals("Artikeltyp får inte vara null!", exception.getMessage());
    }

    @Test
    void setSizeShouldSetChoosenSizes() {
        builder.setArticleType(ArticleType.PANTS);

        builder.setSize("S");
        assertEquals("S", builder.build().getSize());

        builder.setSize("M");
        assertEquals("M", builder.build().getSize());

        builder.setSize("L");
        assertEquals("L", builder.build().getSize());
    }

    @Test
    void setMaterialShouldSetChoosenMaterials() {
        builder.setArticleType(ArticleType.TSHIRT);

        builder.setMaterial("Bomull");
        assertEquals("Bomull", builder.build().getMaterial());

        builder.setMaterial("Polyester");
        assertEquals("Polyester", builder.build().getMaterial());

        builder.setMaterial("Silke");
        assertEquals("Silke", builder.build().getMaterial());
    }

    @Test
    void setColorShouldSetChoosenColor() {
        builder.setArticleType(ArticleType.SKIRT);

        builder.setColor("Röd");
        assertEquals("Röd", builder.build().getColor());

        builder.setColor("Blå");
        assertEquals("Blå", builder.build().getColor());

        builder.setColor("Svart");
        assertEquals("Svart", builder.build().getColor());
    }

    @Test
    void setPriceShouldSetFixedPrice() {
        builder.setArticleType(ArticleType.PANTS);

        builder.setPrice(499.99);
        assertEquals(499.99, builder.build().getPrice(), 0.01);

        builder.setPrice(199.99);
        assertEquals(199.99, builder.build().getPrice(), 0.01);

        builder.setPrice(299.99);
        assertEquals(299.99, builder.build().getPrice(), 0.01);
    }

    @Test
    void setChoosenUniqueAttributesForPants() {
        builder.setArticleType(ArticleType.PANTS);
        Pants pants = (Pants) builder.build();

        pants.setFit("Slim");
        assertEquals("Slim", pants.getFit());

        pants.setFit("Regular");
        assertEquals("Regular", pants.getFit());

        pants.setLength("Lång");
        assertEquals("Lång", pants.getLength());

        pants.setLength("Kort");
        assertEquals("Kort", pants.getLength());
    }

    @Test
    void setChoosenUniqueAttributesForTShirt() {
        builder.setArticleType(ArticleType.TSHIRT);
        TShirt tshirt = (TShirt) builder.build();

        tshirt.setSleeves("Kort");
        assertEquals("Kort", tshirt.getSleeves());

        tshirt.setSleeves("Lång");
        assertEquals("Lång", tshirt.getSleeves());

        tshirt.setNeck("Rund");
        assertEquals("Rund", tshirt.getNeck());

        tshirt.setNeck("V-ringad");
        assertEquals("V-ringad", tshirt.getNeck());
    }

    @Test
    void setChoosenUniqueAttributesForSkirt() {
        builder.setArticleType(ArticleType.SKIRT);
        Skirt skirt = (Skirt) builder.build();

        skirt.setWaistline("Hög");
        assertEquals("Hög", skirt.getWaistline());

        skirt.setWaistline("Låg");
        assertEquals("Låg", skirt.getWaistline());

        skirt.setPattern("Randig");
        assertEquals("Randig", skirt.getPattern());

        skirt.setPattern("Blommig");
        assertEquals("Blommig", skirt.getPattern());
    }

    @Test
    void buildShouldCreateValidArticle() {
        builder.setArticleType(ArticleType.TSHIRT)
                .setSize("M")
                .setMaterial("Bomull")
                .setColor("Vit")
                .setPrice(199.99);

        Article article = builder.build();
        assertNotNull(article);
        assertTrue(article instanceof TShirt);
        assertEquals("M", article.getSize());
        assertEquals("Bomull", article.getMaterial());
        assertEquals("Vit", article.getColor());
        assertEquals(199.99, article.getPrice(), 0.01);
    }

    @Test
    void buildShouldThrowExceptionIfArticleTypeNotSet() {
        Exception exception = assertThrows(IllegalStateException.class, builder::build);
        assertEquals("Artikeltyp måste sättas innan `build()` anropas!", exception.getMessage());
    }

    @Test
    void setSizeShouldThrowExceptionIfArticleTypeNotSet() {
        Exception exception = assertThrows(IllegalStateException.class, () -> builder.setSize("M"));
        assertEquals("Artikeltyp måste sättas innan egenskaper kan tilldelas!", exception.getMessage());
    }

    @Test
    void setMaterialShouldThrowExceptionIfArticleTypeNotSet() {
        Exception exception = assertThrows(IllegalStateException.class, () -> builder.setMaterial("Bomull"));
        assertEquals("Artikeltyp måste sättas innan egenskaper kan tilldelas!", exception.getMessage());
    }

    @Test
    void setColorShouldThrowExceptionIfArticleTypeNotSet() {
        Exception exception = assertThrows(IllegalStateException.class, () -> builder.setColor("Röd"));
        assertEquals("Artikeltyp måste sättas innan egenskaper kan tilldelas!", exception.getMessage());
    }

    @Test
    void setPriceShouldThrowExceptionIfArticleTypeNotSet() {
        Exception exception = assertThrows(IllegalStateException.class, () -> builder.setPrice(499.99));
        assertEquals("Artikeltyp måste sättas innan egenskaper kan tilldelas!", exception.getMessage());
    }
}
