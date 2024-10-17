import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Spy
    private Feline feline = new Feline();

    @Test
    public void eatMeatInvokesGetFoodWithPredator() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyReturnsFeline() throws Exception {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithParamReturnsParam() throws Exception {
        assertEquals(3, feline.getKittens(3));
    }

    @Test
    public void getKittensWithoutParamsInvokesGetKittenWith1() throws Exception {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getKittensWithoutParamReturns1() throws Exception {
        assertEquals(1, feline.getKittens());
    }
}
