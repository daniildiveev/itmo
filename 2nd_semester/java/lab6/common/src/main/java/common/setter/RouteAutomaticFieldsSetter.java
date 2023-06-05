package common.setter;

import common.entities.Route;
import common.exceptions.InvalidParameterValueException;
import common.handler.CollectionHandler;
import common.handler.IOHandler;

import java.time.LocalDateTime;
import java.util.*;

public class RouteAutomaticFieldsSetter {
    public static int generateValidId(CollectionHandler collectionHandler){
        PriorityQueue<Route> collection = collectionHandler.getCollection();

        if(!collection.isEmpty()){
            List<Integer> usedIds = collection.stream().map(Route::getId).distinct().toList();
            int maxId = Collections.max(usedIds);

            for(int i=1; i<maxId; i++){
                if(!usedIds.contains(i)){
                    return i;
                }
            }

            return maxId + 1;
        } else {
            return 1;
        }
    }

    public static LocalDateTime generateTimestamp(){
        return LocalDateTime.now();
    }

    public static boolean validateId(String idString){
        try{
            int id = Integer.parseInt(idString);

            if(id < 1){
                throw new InvalidParameterValueException("Id must be greater than 1");
            }

            return true;
        } catch (NumberFormatException e){
            IOHandler.println("Cannot read id of integer type");
        } catch (InvalidParameterValueException e){
            IOHandler.println(e.getMessage());
        }

        return false;
    }

    public static boolean validateCreationDate(String creationDateString){
        try{
            LocalDateTime creationDate = LocalDateTime.parse(creationDateString);

            return true;
        } catch (Exception e){
            IOHandler.println(e.getMessage());
        }

        return false;
    }
}
