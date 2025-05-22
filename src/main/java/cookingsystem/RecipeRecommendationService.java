package cookingsystem;



public class RecipeRecommendationService {

    public void recommendRecipes(RecipePreference preference) {
        //  preference
        System.out.println("Recommending recipes based on: " + preference.getPreference());
        
    }

   /* public void suggestSubstitutions(List<SubstitutionEngine> substitutions) {
         
        for (SubstitutionEngine sub : substitutions) {
            System.out.println("Substitute " + sub.getOriginal() + " with " + sub.getSubstitute());
        }
    }*/
}
