package masterclass;

// Create a concrete class from your abstract list item class and use this in a LinkedList
// class to implement a linked list that will add items in order (so that they are sorted
// alphabetically). Duplicate values are not added.

public class GroceryList {
    private FoodItem[] foodItems;


    public GroceryList() {
        foodItems = new FoodItem[0];
    }

    private FoodItem[] enlargeList() {
        int size = foodItems.length;
        FoodItem[] newList = new FoodItem[size + 1];
        for (int i = 0; i < size ; i++) {
            newList[i] = foodItems[i];
        }
        foodItems = newList;
        return foodItems;
    }

    private FoodItem[] sortList() {
        int size = foodItems.length;
        FoodItem[] sortedList = new FoodItem[size];

        for (int i = 0; i < size; i++) {
            FoodItem currentItem = foodItems[i];
            if(currentItem.moveToPrevious() == null){
                sortedList[0] = currentItem;
            }
        }

        for (int i = 0; i < size-1; i++) {
            sortedList[i+1] = (FoodItem)sortedList[i].moveToNext();
        }

        foodItems = sortedList;
        return foodItems;
    }

    public String toString() {
        String loggedList = "";
        for (int i = 0; i < foodItems.length; i++) {
            loggedList += ("[" + i + "] " + foodItems[i].getName() + "\n");
        }
        System.out.println(loggedList);
        return loggedList;
    }

    public void addFoodItem(String foodItemName) {
        int size = foodItems.length;

        System.out.println("attempting to add " + foodItemName);

        FoodItem foodItem = new FoodItem(foodItemName);

        if(size == 0){
            foodItems = new FoodItem[1];
            foodItems[0] = foodItem;
            System.out.println(foodItem.getName() + " is the first item on the list");
            System.out.println("added " + foodItemName);
            return;
        }

        for (int i = 0; i < size; i++) {
            int comparison = foodItem.compareTo(foodItems[i]);

            if (comparison == 0) {
                System.out.println(foodItem.getName() + " is already on the list");
                return;
            } else {

                if(comparison > 0) {
                    if(i == (size - 1)) {
                        System.out.println("reached the end of the list without finding a lesser value");
                        foodItem.setPreviousItem(foodItems[i]);
                        foodItems[i].setNextItem(foodItem);
                        addingHelp(size, foodItem);
                        return;
                    }

                } else if(comparison < 0) {
                    foodItem.setNextItem(foodItems[i]);
                    foodItems[i].setPreviousItem(foodItem);
                    if (i > 0) {
                        foodItem.setPreviousItem(foodItems[i-1]);
                        foodItems[i-1].setNextItem(foodItem);
                    }
                    addingHelp(size, foodItem);
                    return;
                }
            }
        }
    }

    private void addingHelp(int size, FoodItem foodItem) {
        enlargeList();
        foodItems[size] = foodItem;
        sortList();
        System.out.println("added " + foodItem.getName());
    }

 /*   private void binarySearch(FoodItem foodItem) {
        sortList();
        FoodItem[] trimmedList;
        int size = foodItems.length;
        int it = 1;
        int min = 0;
        int max = size - 1;
        int avg = (min + max) / 2;
        boolean isEven = (min + max) % 2 == 0;
        int comparison = foodItem.compareTo(foodItems[avg]);

        if (comparison == 0) {
                System.out.println(foodItem.getName() + " is already on the list");
                return;
            }

        while((min <= max) && (comparison != 0)) {
            System.out.println("iteration: " + it++ + "\nmin: " + min + ", max: " + max + ", avg: " + avg + "\nisEven: " + isEven + ", comp: " + comparison + "\n===========");

            if(max - avg < 0) {
                foodItem.setNextItem(foodItems[avg]);
                foodItems[avg].setPreviousItem(foodItem);
                if (avg > 0) {
                    foodItem.setPreviousItem(foodItems[avg-1]);
                    foodItems[avg-1].setNextItem(foodItem);
                }
                addingHelp(size, foodItem);
                return;
            }
                 if ((!isEven) && (comparison < 0)){ //else!!!!!!!!!!!!!!!
                    trimmedList = new FoodItem[max - avg - 1];
                } else {
                    trimmedList = new FoodItem[max - avg];
                }

            System.out.println("trimmedList now size " + trimmedList.length);

                if(trimmedList.length == 0) {
                    System.out.println("wait, trimmedList size 0?");

                    if (comparison > 0) {
                        System.out.println("reached end of list; no lesser value");
                        foodItem.setPreviousItem(foodItems[avg]);
                        foodItems[avg].setNextItem(foodItem);
                        addingHelp(size, foodItem);

                        return;
                    } else {
                        foodItem.setNextItem(foodItems[avg]);
                        foodItems[avg].setPreviousItem(foodItem);
                        if (avg > 0) {
                            System.out.println("found lesser value");
                            foodItem.setPreviousItem(foodItems[avg-1]);
                            foodItems[avg-1].setNextItem(foodItem);
                        }
                        System.out.println("found greater value");

                        addingHelp(size, foodItem);

                        return;
                    }
                }

                if(comparison > 0) {
                    for (int j = 0; j < trimmedList.length; j++) {
                        trimmedList[j] = foodItems[avg + 1 + j];
                    }
                    System.out.println("changing min. Should change avg");
                    min = avg + 1;
                    avg = (min + max) / 2;

                } else if (comparison < 0){
                    for (int j = trimmedList.length - 1; j >= 0; j--) {
                        int k = 0;
                        trimmedList[j] = foodItems[avg - 1 - k++];
                    }
                    System.out.println("changing max. Should change avg");
                    max = avg - 1;
                    avg = (min + max) / 2;
                }
            }
//        if(comparison == 0) {
//            System.out.println("found " + foodItem.getName() + " at index " + avg);
//            return;//0;
//        }
//        return trimmedList;
    }*/

}
