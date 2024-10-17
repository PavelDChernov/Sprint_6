import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTestsNonParametrized {
    private final String sex = "Самец";

    @Mock
    Feline feline = new Feline();

    @Test
    public void getKittensInvokesFelineGetKittens() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodInvokesFelineGetFoodPredator() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void lionConstructorExceptionMessageCheck() throws Exception {
        Lion lion;
        try {
            lion = new Lion(feline, "Лев");
            assertFalse("lionConstructorExceptionMessageCheck expected exception but object created", lion instanceof Lion);
        }
        catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
