package settheory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settheory.SetCharacter;
import settheory.SetCharacterFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class SetCharacterFactoryTest {

    @Test
    public void testGetInstance() throws Exception {
        assertThat( SetCharacterFactory.getInstance() ).isNotNull();
    }

    @Test
    public void testIsSameInstance() throws Exception {
        SetCharacterFactory lhs = SetCharacterFactory.getInstance();
        SetCharacterFactory rhs = SetCharacterFactory.getInstance();
        assertThat(lhs).isEqualTo(rhs);
    }

    @DataProvider(name = "illegalArgumentExceptions")
    public static Object[][] illegalArgumentExceptions() {
        return new Object[][]{
                {""}, //blank string
                {null},
                {"3.14"} //dealing with float numbers
        };
    }

    @Test(dataProvider = "illegalArgumentExceptions")
    public void testOfIllegalArgumentException(String value) throws Exception {
        assertThatIllegalArgumentException().isThrownBy( () -> SetCharacterFactory.getInstance().of(value));
    }

    @DataProvider(name = "validValues") //provider method feeds the tested data
    public static Object[][] Name() {
        return new Object [][] {
                {"A", SetCharacterFactory.AlphaCharacter.class, "A"},
                {"1", SetCharacterFactory.IntegerCharacter.class, 1}
        };
    }

    @Test(dataProvider = "validValues") //test method
    public void testValidValues(String value, Class<?> clazz, Object expected) throws Exception {
        assertThatCode(() -> {
            SetCharacter character = SetCharacterFactory.getInstance().of(value);

            //Check the type
            assertThat(character.getClass()).isEqualTo(clazz);

            //Check the value
            assertThat(character.getValue()).isEqualTo(expected);

        }).doesNotThrowAnyException();
    }
}