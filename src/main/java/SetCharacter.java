import org.apache.commons.lang3.builder.EqualsBuilder;

public interface SetCharacter<T> extends Comparable<SetCharacter<T>>{

    T getValue();

    default boolean isSameCharacter(SetCharacter<?> other){
<<<<<<< HEAD
        return getValue().equals(other.getValue());
=======
        return EqualsBuilder.reflectionEquals(getValue(), other.getValue());
>>>>>>> b6458cabb16e92f90145ad3da5074e0cb8c0160f
    }
}
