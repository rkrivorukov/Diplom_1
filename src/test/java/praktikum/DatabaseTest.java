package praktikum;

import org.junit.Test;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

public class DatabaseTest {

    @Test
    public void availableBuns() {
        Database database = new Database();
        assertEquals(3, database.availableBuns().size());
    }

    @Test
    public void availableIngredients() {
        Database database = new Database();
        assertEquals(6, database.availableIngredients().size());
    }
}