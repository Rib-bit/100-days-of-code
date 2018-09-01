package masterclass;

public class FoodItem extends Food {
    private String name;

    public FoodItem(String name) {
        this.name = name;
    }

    @Override
    public Food getPreviousFood() {
        return super.previousFood;
    }

    @Override
    public Food getNextFood() {
        return super.nextFood;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    Food moveToNext() {
        return super.getNextFood();
    }

    @Override
    Food moveToPrevious() {
        return super.getPreviousFood();
    }

    @Override
    Food setNextItem(Food nextFoodItem) {
        this.nextFood = nextFoodItem;
        return nextFoodItem;
    }

    @Override
    Food setPreviousItem(Food previousFoodItem) {
        this.previousFood = previousFoodItem;
        return previousFoodItem;
    }
}
