//draia, 21/08/2018

package masterclass;

import java.util.ArrayList;

public class GroceryList {

    //private int[] myNumbers = new int[50]; //spot the differences: we need to specify the range...
    public ArrayList<String> groceryList = new ArrayList<String>(); //datatype is defined btwn <>, ArrayList is a class for which you call a constructor,

    //myNumbers[0] = 17; // we can assign a value to an index thus
    public void addGroceryItem(String item) {
        groceryList.add(item); // the '.add' method is already there for adding to an arraylist.
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list."); // we use the '.size' method to get the array length
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i+1) + ", " + groceryList.get(i)); //'.get' method to access array elements
        }
    }

    public void modifyGroceryItem(int index, String newItem) {
        groceryList.set(index, newItem);
        System.out.println("Grocery item " + (index+1) + " has been modified.");
    }

    public void removeGroceryItem(int index) {
        String theItem = groceryList.get(index);
        groceryList.remove(index);
        System.out.println("Grocery item " + (index+1) + " has been removed.");
    }
}
