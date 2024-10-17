import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    private Feline feline;

    @Test
    public void getSoundReturnsMeow() {
        Cat cat = new Cat(feline);
        assertEquals("Мяу", (cat).getSound());
    }

    @Test
    public void getFoodInvokesPredatorEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
