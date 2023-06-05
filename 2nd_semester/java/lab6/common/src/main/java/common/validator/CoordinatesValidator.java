package common.validator;

import common.exceptions.InvalidParameterValueException;

public class CoordinatesValidator extends Validator{
    public static void validate(String coordinatesX, String coordinatesY) throws InvalidParameterValueException {
        checkEmptinessOfParameter(coordinatesX, "X");
        checkEmptinessOfParameter(coordinatesY, "Y");

        try {
            Long x = Long.parseLong(coordinatesX);
        } catch (Exception e){
            throw new InvalidParameterValueException(e.getMessage());
        }

        try {
            Integer y = Integer.parseInt(coordinatesY);

            if(y > 781){
                throw new InvalidParameterValueException("Y parameter of coordinates must be less or equal to 781");
            }
        } catch (NumberFormatException e){
            throw new InvalidParameterValueException(e.getMessage());
        }
    }

    public static String getEntityName(){
        return "Coordinates";
    }
}
