package client.validator;

import client.exceptions.InvalidNumberOfArgumentsException;
import client.exceptions.InvalidParameterValueException;

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

    public static String getEntityName(){
        return "Route";
    }
}
