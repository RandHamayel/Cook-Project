package cookingsystem;

import java.util.*;

public class Dish {
    private String name;
    private List<Ingredient> ingredients;

    public Dish(String name, List<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public void customizeDish(String removeItem, String addItem) {
        ingredients.removeIf(i -> i.getName().equalsIgnoreCase(removeItem));
        ingredients.add(new Ingredient(addItem, false));
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void printIngredients() {
        System.out.println("Ingredients for " + name + ":");
        for (Ingredient i : ingredients) {
            System.out.println("- " + i.getName());
        }
    }

    public static Dish sampleDish(String name) {
        switch (name.toLowerCase()) {
            case "pasta":
                return new Dish("pasta", Arrays.asList(
                        new Ingredient("pasta", false),
                        new Ingredient("cheese", true),
                        new Ingredient("tomato sauce", false)
                ));
            case "salad":
                return new Dish("salad", Arrays.asList(
                        new Ingredient("lettuce", false),
                        new Ingredient("croutons", true),
                        new Ingredient("cheese", true)
                ));
            case "soup":
                return new Dish("soup", Arrays.asList(
                        new Ingredient("broth", false),
                        new Ingredient("cream", true),
                        new Ingredient("vegetables", false)
                ));
            default:
                return new Dish("custom", new ArrayList<>());
        }
    }
}
