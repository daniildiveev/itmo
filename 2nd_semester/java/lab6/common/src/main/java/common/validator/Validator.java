package common.validator;

import common.exceptions.InvalidParameterValueException;

public abstract class Validator {
    public static void checkEmptinessOfParameter(String parameter, String parameterName) throws InvalidParameterValueException{
        if (parameter.trim().isEmpty() || checkIfNull(parameter)){
            throw new InvalidParameterValueException(parameterName + " parameter of" + getEntityName() +" cannot be null");
        }
    }

    public static boolean checkIfNull(String parameter){
        return parameter.trim().equals("null");
    }

    public static String getEntityName(){
        return "None";
    }
}
