package common.validator;

import common.exceptions.InvalidParameterValueException;

public class UserValidator extends Validator{
    public static void validateName(String name) throws Exception{
        checkEmptinessOfParameter(name, "name");

        if (name.split("\\s+").length != 1){
            throw new InvalidParameterValueException("username must not contain whitespaces");
        }
    }
}
