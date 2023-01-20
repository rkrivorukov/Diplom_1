package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void availableBunsTest() {
        Database database = new Database();
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void availableIngredientsTest() {
        Database database = new Database();
        assertEquals(6, database.availableIngredients().size());
    }
}