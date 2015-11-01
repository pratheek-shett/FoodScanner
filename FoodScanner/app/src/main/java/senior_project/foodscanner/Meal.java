package senior_project.foodscanner;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * This class represents a meal.
 */
public class Meal implements Serializable {

    private static final long serialVersionUID = 418772005483570552L;

    public enum MealType{
        BREAKFAST ("Breakfast"),
        BRUNCH ("Brunch"),
        LUNCH ("Lunch"),
        SNACK ("Snack"),
        DINNER ("Dinner"),
        DESSERT ("Dessert");


        private final String name;

        MealType(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }
    }

    // Meal Details
    private MealType type;
    private GregorianCalendar date;
    private List<FoodItem> food;

    public Meal(GregorianCalendar date, MealType type){
        this.date = date;
        this.type = type;
        food = new ArrayList<>();
    }

    public void setType(MealType type){
        this.type = type;
    }

    public MealType getType(){
        return type;
    }

    public GregorianCalendar getDate(){
        return date;
    }

    public void addFoodItem(FoodItem item){
        // Check if food item has already been added
        for (FoodItem fi : food) {
            if (fi.equals(item)) {
                // Add one more portion of food item
                fi.addPortion();
                return;
            }
        }

        // Food item hasn't already been added
        food.add(item);
    }

    public void removeFoodItem(FoodItem item) {
        food.remove(item);
    }

    public FoodItem getFoodItem(int index) {
        return food.get(index);
    }

    public List<FoodItem> getFood() {
        return food;
    }

    public void replaceFoodItem(FoodItem oldFood, FoodItem newFood) {
        newFood.replacePortions(oldFood.getPortions());
        this.addFoodItem(newFood);
        this.removeFoodItem(oldFood);
    }
}
