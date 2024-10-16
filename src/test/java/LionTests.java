import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;

@RunWith(Parameterized.class)
public class LionTests {

    private String sex;

    @Mock
    private Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public LionTests(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                { "Самец" },
                { "Самка" },
                { "" }
        };
    }

    @Test
    public void getKittensInvokesFelineGetKittens() throws Exception {
        assumeThat(sex, anyOf(is("Самец"), is("Самка")));
        Lion lion = new Lion(feline, sex);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void getFoodInvokesFelineEatMeat() throws Exception {
        assumeThat(sex, anyOf(is("Самец"), is("Самка")));
        Lion lion = new Lion(feline, sex);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }

    @Test
    public void doesHaveManeReturnsTrueIfMale() throws Exception {
        assumeThat(sex,is("Самец"));
        Lion lion = new Lion(feline, sex);
        assertTrue("Самец, doesHaveMane: ", lion.doesHaveMane());
    }

    @Test
    public void doesHaveManeReturnsFalseIfFemale() throws Exception {
        assumeThat(sex,is("Самка"));
        Lion lion = new Lion(feline, sex);
        assertFalse("Самка, doesHaveMane: ", lion.doesHaveMane());
    }

    @Test
    public void lionConstructorExceptionMessageCheck() throws Exception {
        assumeThat(sex, not(anyOf(is("Самец"), is("Самка"))));
        try {
            Lion lion = new Lion(feline, "");
        }
        catch (Exception exception) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
