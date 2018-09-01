package masterclass;

public abstract class Food {
    String name;

    String getName() {
        return name;
    }

    Food previousFood;

    public Food getPreviousFood() {
        return previousFood;
    }

    Food nextFood;

    public Food getNextFood() {
        return nextFood;
    }

    abstract Food moveToNext();
    abstract Food moveToPrevious();
    abstract Food setNextItem(Food nextFood);
    abstract Food setPreviousItem(Food previousFood);

    int compareTo(Food food) {

        String name1 = this.getName();
        String name2 = food.getName();
        int comparison = name1.compareToIgnoreCase(name2);

        return comparison;
    }




}
