package cookingsystem.features.aireciperecommendations;

import java.util.List;

public class RecipeRecommendationService {

    public void recommendRecipes(RecipePreference preference) {
        //  preference
        System.out.println("Recommending recipes based on: " + preference.getPreference());
        
    }

    public void suggestSubstitutions(List<IngredientSubstitution> substitutions) {
         
        for (IngredientSubstitution sub : substitutions) {
            System.out.println("Substitute " + sub.getOriginal() + " with " + sub.getSubstitute());
        }
    }
}
