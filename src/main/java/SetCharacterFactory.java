import lombok.Data;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.StringUtils.isNumeric;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

public class SetCharacterFactory { //object-oriented design pattern

    //should only ever be one fac

    private static final SetCharacterFactory instance = new SetCharacterFactory();

    public static SetCharacterFactory getInstance () {
        return instance;
    }

    //Prevent others from creating this class
    private SetCharacterFactory() {}

    public SetCharacter<?> of(String value){
        checkArgument(isNotBlank(value), "Value is required"); //Throw IllegalArgumentException
        if (isParsable(value)){
            if(isNumeric(value)){
                return new IntegerCharacter(Integer.parseInt(value));
            } else {
                //Throw an exception to crash to program
                throw new IllegalArgumentException("Value has to be integer value");
            }
        } else {
            return new AlphaCharacter(value);
        }
    }

    @Data
    class IntegerCharacter implements SetCharacter<Integer> {

        private final int value;

        @Override
        public Integer getValue() {
            return value;
        }
    }

    @Data
    class AlphaCharacter implements SetCharacter<String> {

        private final String value;

        @Override
        public String getValue() {
            return value;
        }
    }
}
