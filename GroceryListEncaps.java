//draia, 21/08/2018

package masterclass;

import java.util.ArrayList;

public class GroceryListEncaps {

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

    public void modifyGroceryItem(String currentItem, String newItem) {
        int index = findItem(currentItem);
        if(index >= 0) {
            modifyGroceryItem(index, newItem);
        }
    }
    private void modifyGroceryItem(int index, String newItem) { //made private, forcing the users of the class to use the simple one
        groceryList.set(index, newItem);
        System.out.println("Grocery item " + (index+1) + " has been modified.");
    }

    public void removeGroceryItem(String item) {
        int index = findItem(item);
        if (index >= 0 ) {
            removeGroceryItem(index);
        }
    }
    private void removeGroceryItem(int index) {
        groceryList.remove(index);
        System.out.println("Grocery item " + (index+1) + " has been removed.");
    }

    private int findItem(String searchItem){
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
