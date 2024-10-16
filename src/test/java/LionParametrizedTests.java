import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTests {

    private String sex;

    @Mock
    private Feline feline;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    public LionParametrizedTests(String sex) {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                { "Самец" },
                { "Самка" },
        };
    }

    @Test
    public void getKittensInvokesFelineGetKittens() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void doesHaveManeReturnsTrueIfMaleFalseIfFemale() throws Exception {
        Lion lion = new Lion(feline, sex);
        if (sex.equals("Самец")) {
            assertTrue("Самец, doesHaveMane: ", lion.doesHaveMane());
        }
        else {
            assertFalse("Самка, doesHaveMane: ", lion.doesHaveMane());
        }
    }

    @Test
    public void getFoodInvokesFelineEatMeat() throws Exception {
        Lion lion = new Lion(feline, sex);
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
