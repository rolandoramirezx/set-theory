package settheory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import settheory.SetCharacter;
import settheory.SetCharacterFactory;
import settheory.TransitiveSet;

import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class TransitiveSetTest {

    @DataProvider(name = "transitiveSets")
    public static Object [][] transitiveSets() { // [][] multi-dem array i.e array that contains arrays3
        return new Object[][] {
                {"ABCDAD", true},
                {"ABCDDD", false},
                {"ABCDEFADCF", false}
        };
    }

    @Test(dataProvider = "transitiveSets")
    public void testProcess(String input, Boolean result) throws Exception {
        Stream<String> characterStream = input.chars().mapToObj(i -> Character.toString((char) i));
        Collection<SetCharacter<?>> characters = characterStream.map(SetCharacterFactory.getInstance()::of).collect(toList()); // :: method reference Java 8

        assertThat(new TransitiveSet(characters).process().isValid()).isEqualTo(result);
    }
}