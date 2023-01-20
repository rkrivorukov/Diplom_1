package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class BurgerTest {

    private final Burger burger;
    private final float price;

    public BurgerTest(Burger burger, float price) {
        this.burger = burger;
        this.price = price;
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("bun1", 10.0f));
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test", 10.0f);
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        Ingredient i1 = new Ingredient(IngredientType.SAUCE, "test1", 10.0f);
        Ingredient i2 = new Ingredient(IngredientType.FILLING, "test2", 15.0f);
        Ingredient i3 = new Ingredient(IngredientType.SAUCE, "test3", 20.0f);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        burger.addIngredient(i3);

        burger.removeIngredient(0);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(2).isEqualTo(burger.ingredients.size());
        softAssertions.assertThat(i2).isEqualTo(burger.ingredients.get(0));
        softAssertions.assertAll();
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        Ingredient i1 = new Ingredient(IngredientType.SAUCE, "test1", 10.0f);
        Ingredient i2 = new Ingredient(IngredientType.FILLING, "test2", 15.0f);
        Ingredient i3 = new Ingredient(IngredientType.SAUCE, "test3", 20.0f);
        Ingredient i4 = new Ingredient(IngredientType.FILLING, "test4", 25.0f);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        burger.addIngredient(i3);
        burger.addIngredient(i4);

        burger.moveIngredient(1, 3);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(4).isEqualTo(burger.ingredients.size());
        softAssertions.assertThat(i2).isEqualTo(burger.ingredients.get(3));
        softAssertions.assertAll();
    }

    @Test
    public void getPriceTest() {
        assertEquals(price, burger.getPrice(), 0.0001);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("bun1", 5.0f));
        Ingredient i1 = new Ingredient(IngredientType.SAUCE, "test1", 10.0f);
        Ingredient i2 = new Ingredient(IngredientType.FILLING, "test2", 15.0f);
        Ingredient i3 = new Ingredient(IngredientType.SAUCE, "test3", 20.0f);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        burger.addIngredient(i3);

        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("(==== bun1 ====)")
                .add("= sauce test1 =")
                .add("= filling test2 =")
                .add("= sauce test3 =")
                .add("(==== bun1 ====)")
                .add("")
                .add("Price: 55,000000")
                .add("");
        assertEquals(joiner.toString(), burger.getReceipt());

    }

    @Parameterized.Parameters
    public static Object[][] data() {
        Bun bun = Mockito.mock(Bun.class);
        Mockito.doReturn(5.0f).when(bun).getPrice();
        Burger burger1 = new Burger();
        burger1.setBuns(bun);
        Ingredient i1 = new Ingredient(IngredientType.SAUCE, "test1", 10.0f);
        Ingredient i2 = new Ingredient(IngredientType.FILLING, "test2", 15.0f);
        Ingredient i3 = new Ingredient(IngredientType.SAUCE, "test3", 20.0f);
        burger1.addIngredient(i1);
        burger1.addIngredient(i2);
        burger1.addIngredient(i3);

        Burger burger2 = new Burger();
        burger2.setBuns(bun);
        Ingredient i4 = new Ingredient(IngredientType.FILLING, "test4", 10.0f);
        burger2.addIngredient(i4);
        return new Object[][] {
                {burger1, 55.0f},
                {burger2, 20.0f}
        };
    }
}