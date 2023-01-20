package praktikum;

import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class BunTest {

    @Test
    public void bunGetPriceTest(){
        Bun bun = Mockito.mock(Bun.class);
        Assert.assertEquals(0f, bun.getPrice(), 0.001);
    }

    @Test
    public void bunGetNameTest(){
        Bun bun = Mockito.mock(Bun.class);
        Assert.assertNull(bun.getName());
    }

    @Test
    public void bunConstructorTest(){
        Bun bun = new Bun("lala", 12f);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat("lala").isEqualTo(bun.getName());
        softAssertions.assertThat(12f).isEqualTo(bun.getPrice());
        softAssertions.assertAll();
    }


}
