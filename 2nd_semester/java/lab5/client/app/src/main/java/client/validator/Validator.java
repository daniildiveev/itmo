package client.validator;

import client.exceptions.InvalidParameterValueException;

public abstract class Validator {
    public static void checkEmptinessOfParameter(String parameter, String parameterName) throws InvalidParameterValueException{
        if (parameter.trim().isEmpty() || parameter.trim().equals("null")){
            throw new InvalidParameterValueException(parameterName + " parameter of" + getEntityName() +" cannot be null");
        }
    }

    public static String getEntityName(){
        return "None";
    }
}
