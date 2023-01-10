package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void ingredientTest1() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cotlet", 11f);
        Assert.assertEquals("cotlet", ingredient.getName());
        Assert.assertEquals(11f, ingredient.getPrice(), 0.000f);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}
