package praktikum;

import org.junit.Test;
import org.assertj.core.api.SoftAssertions;


public class IngredientTest {

    @Test
    public void ingredientTest1() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "cotlet", 11f);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat("cotlet").isEqualTo(ingredient.getName());
        softAssertions.assertThat(11f).isEqualTo(ingredient.getPrice());
        softAssertions.assertThat(IngredientType.SAUCE).isEqualTo(ingredient.getType());
        softAssertions.assertAll();
    }
}
