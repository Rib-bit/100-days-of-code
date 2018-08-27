package masterclass;

import java.util.List;

public interface ISaveable {
    List<String> saveToArrayList(String name, String type, String score, String integrity);//allow for an object to be saved in an ArrayList, return the ArrayList
    Object populateFields(List<String> objectList);//make it possible to populate an object's fields from an ArrayList
}
