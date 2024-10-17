import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionTestsParametrized {
    private Feline feline;
    private String sex;

    public LionTestsParametrized(Feline feline, String sex) {
        this.feline = feline;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                { new Feline(), "Самец" },
                { new Feline(), "Самка" }
        };
    }

    @Test
    public void doesHaveManeReturnsTrueIfMaleFalseIfFemale() throws Exception {
        try {
            Lion lion = new Lion(feline, sex);
            if (sex.equals("Самец")) {
                assertTrue("doesHaveMane \"Самец\" expected true, got " + lion.doesHaveMane(), lion.doesHaveMane());
            } else {
                assertFalse("doesHaveMane \"Самка\" expected false, got " + lion.doesHaveMane(), lion.doesHaveMane());
            }
        }
        catch (Exception exception) {
            assertTrue("doesHaveManeReturnsTrueIfMaleFalseIfFemale expected boolean exception thrown. Message: " + exception.getMessage(), false);
        }
    }
}
