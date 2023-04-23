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

        try{
            Float y = Float.parseFloat(locationX);
        } catch (Exception e){
            throw new InvalidParameterValueException(e.getMessage());
        }

        try{
            Double y = Double.parseDouble(locationX);
        } catch (Exception e){
            throw new InvalidParameterValueException(e.getMessage());
        }
    }

    public static String getEntityName(){
        return "Location";
    }
}
