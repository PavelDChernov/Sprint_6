import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionNonParametrizedTests {
    @Mock
    private Feline feline;

    @Test
    public void lionConstructorExceptionMessageCheck() throws Exception {
        try {
            Lion lion = new Lion(feline, "");
        }
        catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}