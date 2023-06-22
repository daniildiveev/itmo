package common.validator;

import common.exceptions.InvalidNumberOfArgumentsException;
import common.exceptions.InvalidParameterValueException;

public class RouteValidator extends Validator{
    public static void validate(String [] args) throws Exception{
        if(args.length != 12){
            throw new InvalidNumberOfArgumentsException("args must have precisely 12 elements");
        }
        checkEmptinessOfParameter(args[0], "name");
        checkEmptinessOfParameter(args[11], "distance");

        CoordinatesValidator.validate(args[1], args[2]);
        LocationValidator.validate(args[3],args[4],args[5],args[6]);
        LocationValidator.validate(args[7],args[8],args[9],args[10]);

        try{
            Long distance = Long.parseLong(args[11]);

            if(distance <= 1){
                throw new InvalidParameterValueException("distance must be greater than 1");
            }
        } catch(NumberFormatException e){
            throw new InvalidParameterValueException(e.getMessage());
        }
    }

    public static void validateParams(
            int id,
            String name,
            Long coordinatesX,
            Integer coordinatesY,
            Integer fromX,
            String fromName,
            Integer toX,
            String toName,
            long distance) throws InvalidParameterValueException{
        if (id < 0){
            throw new InvalidParameterValueException("id must be an integer greater than zero");
        }

        checkEmptinessOfParameter(name, "name");
        if (checkIfNull(coordinatesX) || checkIfNull(coordinatesY)){
            throw new InvalidParameterValueException("coordinates parameters cannot be null");
        }

        if (checkIfNull(fromX) || checkIfNull(fromName) || checkIfNull(toX) || checkIfNull(toName)){
            throw new InvalidParameterValueException("X and name of Location cannot be null");
        }

        if(distance < 1){
            throw new InvalidParameterValueException("distance must be greater than 1");
        }
    }

    public static String getEntityName(){
        return "Route";
    }
}
