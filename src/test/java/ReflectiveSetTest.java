import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class ReflectiveSetTest {

    @DataProvider(name = "reflexiveSets")
    public static Object [][] reflexiveSets() {
        return new Object[][] {
                {"ABAABB", true},
                {"ABAABBCACC", true},
                {"ABCDAABBCCDD", true},
                {"ABCDEFAABBCCDDEEFF", true},
                {"ABAABA", false},
                {"ABCDAABBCCAB", false},
                {"123411223344", true},
                {"123411223344", true},
                {"123411223334", false},
                {"1A2B11AA22BB", true},
        };
    }

    @Test(dataProvider = "reflexiveSets") //getting our data from reflexiveSets
    public void testProcess(String input, Boolean result) throws Exception {
        Stream<String> characterStream = input.chars().mapToObj(i -> Character.toString((char) i));
        Collection<SetCharacter<?>> characters = characterStream.map(SetCharacterFactory.getInstance()::of).collect(toList());

        //Create a new ReflectiveSet object. Pass characters to its constructor

        //ReflectiveSet set = new ReflectiveSet(characters);

        //Next, call process() on your ReflectiveSet object

       // set.process();

        //finally, assert that ReflectiveSet.isValid == result, using assertThat

        //assertThat(set.isValid()).isEqualTo(result);

        assertThat(new ReflectiveSet(characters).process().isValid()).isEqualTo(result); //verifying whether isValid is in fact what our test says it should be
    }
}