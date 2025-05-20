package acceptance;

import io.cucumber.java.en.*;

public class AI_AssistanceSteps {

    @Given("user preferences include {string}")
    public void set_preferences(String preference) {
        System.out.println("User preferences: " + preference);
        // منطق تخزين التفضيلات
    }

    @Given("available ingredients are {string}")
    public void set_available_ingredients(String ingredients) {
        System.out.println("Available ingredients: " + ingredients);
        // منطق تخزين المكونات المتاحة
    }

    @When("requesting recipe recommendations")
    public void request_recommendations() {
        System.out.println("Requesting recipe recommendations...");
        // منطق جلب الوصفات
    }

    @Then("the system should prioritize vegan options")
    public void verify_vegan_filter() {
        System.out.println("System prioritizes vegan options.");
        // منطق التحقق من أولوية النباتي
    }

    @Then("exclude any animal products")
    public void exclude_animal_products() {
        System.out.println("System excludes animal products.");
        // منطق التحقق من استبعاد المنتجات الحيوانية
    }

    @Given("user has only {string} available")
    public void set_time_constraint(String time) {
        System.out.println("Time available: " + time);
        // تخزين الوقت، ممكن تحويل "30 minutes" إلى int
    }

    @When("searching for recipes")
    public void search_for_recipes() {
        System.out.println("Searching for recipes...");
        // منطق البحث
    }

    @Then("the system should exclude recipes over {int} mins")
    public void verify_time_filter(int minutes) {
        System.out.println("Filtering recipes over " + minutes + " minutes");
        // تحقق من استبعاد الوصفات الطويلة
    }

    @Then("sort by fastest preparation time")
    public void sort_by_fastest_preparation_time() {
        System.out.println("Sorting by fastest preparation time...");
        // منطق الفرز حسب الوقت
    }

    @Given("a recipe requires {string}")
    public void recipe_requires(String ingredient) {
        System.out.println("Recipe requires: " + ingredient);
        // تسجيل المكون المطلوب
    }

    @But("user is lactose intolerant")
    public void user_is_lactose_intolerant() {
        System.out.println("User is lactose intolerant.");
        // منطق تحديد أن المستخدم لا يتحمل اللاكتوز
    }

    @When("viewing the recipe")
    public void viewing_the_recipe() {
        System.out.println("Viewing the recipe.");
        // منطق عرض الوصفة مع استبدال المكونات
    }
    
    @Then("the system should suggest {string}")
    public void system_should_suggest_substitute(String substitute) {
        System.out.println("Suggested substitute: " + substitute);
        // منطق التحقق من الاقتراح المناسب
    }

    @And("adjust preparation instructions accordingly")
    public void adjust_preparation_instructions() {
        System.out.println("Adjusting preparation instructions accordingly...");
        // منطق التعديل على التعليمات
    }
}

