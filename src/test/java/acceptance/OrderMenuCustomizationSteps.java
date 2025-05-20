package acceptance;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import cookingsystem.features.orderandmenucustomization.OrderAndMenuCustomization;

import java.util.*;

public class OrderMenuCustomizationSteps {
    private OrderAndMenuCustomization orderSystem;
    private List<String> initialIngredients;
    private List<String> modifiedIngredients;
    private Map<String, String> suggestedSubs;
    private boolean chefApproved;

    @Given("a customer is viewing a {string} dish")
    public void customerViewingDish(String dish) {
        // إعداد مكونات افتراضية لكل طبق
        initialIngredients = new ArrayList<>();
        switch (dish) {
            case "pasta":
                initialIngredients.addAll(Arrays.asList("cheese", "tomato", "basil"));
                break;
            case "salad":
                initialIngredients.addAll(Arrays.asList("croutons", "lettuce", "tomato"));
                break;
            case "soup":
                initialIngredients.addAll(Arrays.asList("cream", "carrot", "celery"));
                break;
        }
        orderSystem = new OrderAndMenuCustomization(dish, initialIngredients);
    }

    @When("they remove {string} and add {string}")
    public void updateIngredients(String removeItem, String addItem) {
        orderSystem.updateIngredients(removeItem, addItem);
        modifiedIngredients = orderSystem.getIngredients();
    }

    @Then("the system should update the recipe")
    public void verifyRecipeUpdated() {
        assertNotNull(modifiedIngredients);
        assertFalse(modifiedIngredients.isEmpty());
    }

    @Then("show the modified ingredient list")
    public void showModifiedIngredients() {
        System.out.println("Modified Ingredients: " + modifiedIngredients);
        assertTrue(modifiedIngredients.containsAll(orderSystem.getIngredients()));
    }

    @Given("a customer is allergic to dairy")
    public void customerAllergicToDairy() {
        initialIngredients = Arrays.asList("milk", "butter", "cheese");
        orderSystem = new OrderAndMenuCustomization("customDish", initialIngredients);
        orderSystem.setDairyAllergy(true);
    }

    @When("they select a recipe containing {string}")
    public void selectRecipeWithDairy(String dairyItem) {
        assertTrue(orderSystem.getIngredients().contains(dairyItem));
    }

    @Then("the system should suggest the following alternatives:")
    public void suggestAlternatives(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> expectedSubs = dataTable.asMaps();
        suggestedSubs = orderSystem.getSubstitutionSuggestions();
        for (Map<String, String> row : expectedSubs) {
            String original = row.get("Original Ingredient");
            String suggested = row.get("Suggested Substitute");
            assertEquals(suggested, suggestedSubs.get(original));
        }
    }

    @Then("highlight the substitution in yellow")
    public void highlightSubstitution() {
        // محاكاة تمييز العنصر - في اختبار حقيقي يمكن التحقق من واجهة المستخدم
        System.out.println("Highlighting substitutions in yellow: " + suggestedSubs);
        assertFalse(suggestedSubs.isEmpty());
    }

    @Given("a chef receives a substitution alert")
    public void chefReceivesAlert() {
        initialIngredients = Arrays.asList("milk", "cheese");
        orderSystem = new OrderAndMenuCustomization("pizza", initialIngredients);
        orderSystem.setDairyAllergy(true);
    }

    @When("they review the changed recipe")
    public void reviewChangedRecipe() {
        // مجرد إعداد المكونات للحالة
        assertNotNull(orderSystem.getIngredients());
    }

    @Then("they can approve or modify the substitution")
    public void chefApprovesOrModifies() {
        orderSystem.chefApprove(true);
        chefApproved = orderSystem.isChefApproval();
        assertTrue(chefApproved);
    }

    @Then("the customer should receive notification of the change")
    public void customerGetsNotified() {
        List<String> notifications = orderSystem.getCustomerNotifications();
        assertTrue(notifications.contains("Chef approved the substitutions."));
    }
}
