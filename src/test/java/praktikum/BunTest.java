package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BunTest {

    @Test
    public void testBun1(){
        Bun bun1 = Mockito.mock(Bun.class);
        Assert.assertEquals(0f, bun1.getPrice(), 0.001);
    }

    @Test
    public void testBun2(){
        Bun bun1 = Mockito.mock(Bun.class);
        Assert.assertNull(bun1.getName());
    }

    @Test
    public void testBun3Constructor(){
        Bun bun1 = new Bun("lala", 12f);
        Assert.assertEquals("lala", bun1.getName());
        Assert.assertEquals(12f, bun1.getPrice(), 0.000f);
    }


}
