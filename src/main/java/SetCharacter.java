import org.apache.commons.lang3.builder.EqualsBuilder;

public interface SetCharacter<T> extends Comparable<SetCharacter<T>>{

    T getValue();

    default boolean isSameCharacter(SetCharacter<?> other){
        return EqualsBuilder.reflectionEquals(getValue(), other.getValue());
    }
}
