import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class SetTheory {

    public static void main (String [] arr) {

        try (Stream<String> stream = Files.lines(Paths.get("input.txt"))) {
            stream.forEach(SetTheory::processSetLine);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void processSetLine(String line){

        Stream<String>stringStream = line.chars().mapToObj(i-> Character.toString((char) i)); //breaking string into stream and stream feeds single letter at a time
        Collection<SetCharacter<?>> characters = stringStream.map(SetCharacterFactory.getInstance()::of).collect(toList());

        boolean isReflective = new ReflectiveSet(characters).process().isValid();
        boolean isSymmetric = new SymmetricSet(characters).process().isValid();
        boolean isTransitive = new TransitiveSet(characters).process().isValid();

        System.out.print(line + " ");
        if(isReflective){
            System.out.print("is Reflective\n");
        } else if (isSymmetric){
            System.out.print("is Symmetric\n");
        } else if (isTransitive){
            System.out.print("is Transitive\n");
        } else {
            System.out.print("is not a set\n");
        }

    }
}
