package cookingsystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Customer extends User {
    private Set<String> dietaryPreferences = new HashSet<>();
    private List<String> allergies = new ArrayList<>();
    private List<Order> orderHistory = new ArrayList<>();

    public Customer(String username, String password) {
        super(username, password, "Customer");
    }

    public void addPreference(String pref) {
        dietaryPreferences.add(pref);
        System.out.println("Preferences saved successfully.");
    }

    public Set<String> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
        System.out.println("Allergy added.");
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }
    public void customizeDish(Dish dish, String remove, String add) {
        dish.customizeDish(remove, add);
        System.out.println("Updated Ingredients:");
        dish.printIngredients();
    }
    public void viewSubstitutions(Dish dish) {
        System.out.println("Checking for allergy-friendly substitutes:");
        SubstitutionEngine.suggestSubstitutes(dish.getIngredients(), allergies);
    }
    public void showMenu(Scanner sc) {
        Dish sampleDish = Dish.sampleDish("pasta");
        System.out.println("\n--- CUSTOMER MENU ---");
        System.out.println("1. Customize Dish");
        System.out.println("2. View Substitutions");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
        int choice = sc.nextInt(); sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Remove ingredient: ");
                String remove = sc.nextLine();
                System.out.print("Add ingredient: ");
                String add = sc.nextLine();
                customizeDish(sampleDish, remove, add);
                break;
            case 2:
                addAllergy("dairy");
                viewSubstitutions(sampleDish);
                break;
            case 0:
                System.out.println("Goodbye!");
                return;
        }
        showMenu(sc);
    }

}