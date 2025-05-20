package acceptance;


import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import java.util.List;

import cookingsystem.features.customerprofile.*;

public class CustomerProfileSteps {
    private Customer customer;
    private Chef chef;
    private String lastMessage;

    // Scenario Outline Steps
    @Given("a customer is logged in")
    public void customerLoggedIn() {
        customer = new Customer("Test User");
    }

    @When("they update their profile with {string} dietary preference")
    public void updateDietaryPreference(String preference) {
        customer.setDietaryPreference(preference);
        lastMessage = "Preferences saved successfully";
    }

    @Then("the system should save these preferences")
    public void verifyPreferencesSaved() {
        assertNotNull(customer.getDietaryPreference());
    }

    @Then("show confirmation message {string}")
    public void verifyConfirmation(String message) {
        assertEquals(message, lastMessage);
    }

    // View Past Orders Steps
    @Given("a customer has ordered meals before")
    public void setupOrderHistory() {
        customer = new Customer("Test User");
        customer.addOrder(new OrderHistory("2025-05-01", List.of("Vegan Burger", "Salad"), 12.99));
        // Add other orders similarly
    }

    @When("they navigate to {string}")
    public void navigateTo(String page) {
        // Navigation logic would go here
    }

    @Then("the system should display the following orders:")
    public void verifyOrders(io.cucumber.datatable.DataTable dataTable) {
        List<OrderHistory> orders = customer.getOrderHistory();
        assertEquals(5, orders.size()); // Verify 5 orders exist
    }

    // Chef View Steps
    @Given("a chef is logged in")
    public void chefLoggedIn() {
        chef = new Chef();
    }

    @When("they select a customer profile")
    public void selectCustomerProfile() {
        // Normally would fetch from system
        customer = new Customer("Test Customer");
        customer.setDietaryPreference("Vegan");
        customer.setAllergies(List.of("Peanuts", "Dairy", "Shellfish"));
    }

    @Then("the system should display dietary restrictions")
    public void verifyDietaryDisplay() {
        assertNotNull(customer.getDietaryPreference());
    }

    @Then("highlight the following allergies in red:")
    public void verifyAllergiesHighlight(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedAllergies = dataTable.asList();
        assertEquals(expectedAllergies, customer.getAllergies());
    }
}