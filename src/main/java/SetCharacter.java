import lombok.Data;

@Data
public final class SetCharacter<T> { // final won't let inherit

    private final T value; //immutable class

    public SetCharacter(char c) { //is c number or string
        this.value = value;
    }
}