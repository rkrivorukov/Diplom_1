package praktikum;

import org.junit.Test;

import java.util.StringJoiner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BurgerTest {

    @Test
    public void setBuns() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("bun1", 10.0f));
        assertNotNull(burger.bun);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "test", 10.0f);
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        Ingredient i1 = new Ingredient(IngredientType.SAUCE, "test1", 10.0f);
        Ingredient i2 = new Ingredient(IngredientType.FILLING, "test2", 15.0f);
        Ingredient i3 = new Ingredient(IngredientType.SAUCE, "test3", 20.0f);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        burger.addIngredient(i3);

        burger.removeIngredient(0);
        assertEquals(2, burger.ingredients.size());
        assertEquals(i2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredient() {
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
        assertEquals(4, burger.ingredients.size());
        assertEquals(i2, burger.ingredients.get(3));
    }

    @Test
    public void getPrice() {
        Burger burger = new Burger();
        burger.setBuns(new Bun("bun1", 5.0f));
        Ingredient i1 = new Ingredient(IngredientType.SAUCE, "test1", 10.0f);
        Ingredient i2 = new Ingredient(IngredientType.FILLING, "test2", 15.0f);
        Ingredient i3 = new Ingredient(IngredientType.SAUCE, "test3", 20.0f);
        burger.addIngredient(i1);
        burger.addIngredient(i2);
        burger.addIngredient(i3);
        assertEquals(55.0f, burger.getPrice(), 0.0001);
    }

    @Test
    public void getReceipt() {
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
}