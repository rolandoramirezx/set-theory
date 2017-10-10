import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SymmetricSetTest {

        @DataProvider(name = "symmetricSets")
        public static Object [][] symmetricSets() {
            return new Object[][] {
                    {"ABCDBADC", true},
                    {"ABCDEFBADCFE", true},
                    {"ABCDBABB", false},
                    {"ABCDEFBA", false}
            };
        }

    @Test(dataProvider = "symmetricSets")
    public void testProcess(String input, Boolean result) throws Exception {
        Stream<String> characterStream = input.chars().mapToObj(i -> Character.toString((char) i));
        Collection<SetCharacter<?>> characters = characterStream.map(SetCharacterFactory.getInstance()::of).collect(toList()); // :: method reference Java 8

        assertThat(new SymmetricSet(characters).process().isValid()).isEqualTo(result);
    }
}