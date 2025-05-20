package cookingsystem.features.customerprofile;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String dietaryPreference;
    private List<OrderHistory> orderHistory;
    private List<String> allergies;

    public Customer(String name) {
        this.name = name;
        this.orderHistory = new ArrayList<>();
        this.allergies = new ArrayList<>();
    }

    public String getDietaryPreference() {
        return dietaryPreference;
    }

    public void setDietaryPreference(String dietaryPreference) {
        this.dietaryPreference = dietaryPreference;
        System.out.println("Preferences saved successfully");
    }

    public void addOrder(OrderHistory order) {
        this.orderHistory.add(order);
    }

    public List<OrderHistory> getOrderHistory() {
        return orderHistory;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public String getName() {
        return name;
    }
}
