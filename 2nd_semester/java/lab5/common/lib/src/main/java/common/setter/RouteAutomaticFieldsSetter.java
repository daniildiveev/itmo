package common.setter;

import common.entities.Route;
import common.handler.CollectionHandler;

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
}
