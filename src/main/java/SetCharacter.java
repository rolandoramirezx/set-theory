import org.apache.commons.lang3.builder.EqualsBuilder;

public interface SetCharacter <T> {

    T getValue();

    default boolean isSameCharacter(SetCharacter<?> outer){
        return EqualsBuilder.reflectionEquals(getValue(), other.getValue());
    }
}