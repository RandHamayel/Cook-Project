package cookingsystem.features.aireciperecommendations;

public class RecipePreference {
    private String preference;
    private String ingredients;
    private String excludedItems;

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getExcludedItems() {
        return excludedItems;
    }

    public void setExcludedItems(String excludedItems) {
        this.excludedItems = excludedItems;
    }
}
