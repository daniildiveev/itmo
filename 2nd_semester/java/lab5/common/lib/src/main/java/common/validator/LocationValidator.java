package common.validator;

import common.exceptions.InvalidParameterValueException;

public class LocationValidator extends Validator{
    public static void validate(String locationX,
                                   String locationY,
                                   String locationZ,
                                   String locationName) throws InvalidParameterValueException {
        checkEmptinessOfParameter(locationX, "X");
        checkEmptinessOfParameter(locationName, "Y");

        try{
            Integer x = Integer.parseInt(locationX);
        } catch (Exception e){
            throw new InvalidParameterValueException(e.getMessage());
        }

        if(!checkIfNull(locationY)){
            try {
                Float y = Float.parseFloat(locationY);
            } catch (Exception e) {
                throw new InvalidParameterValueException(e.getMessage());
            }
        }

        if(!checkIfNull(locationZ)){
            try {
                Double z = Double.parseDouble(locationZ);
            } catch (Exception e) {
                throw new InvalidParameterValueException(e.getMessage());
            }
        }
    }

    public static String getEntityName(){
        return "Location";
    }
}
