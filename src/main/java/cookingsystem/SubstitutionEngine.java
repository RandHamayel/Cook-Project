package cookingsystem;

import java.util.*;

public class SubstitutionEngine {
   private static final Map<String, String> dairySubstitutes = Map.of(
       "milk", "almond milk",
       "butter", "olive oil",
       "cheese", "nutritional yeast"
   );

   public static void suggestSubstitutes(List<Ingredient> ingredients, List<String> allergies) {
       for (Ingredient ingredient : ingredients) {
           String name = ingredient.getName().toLowerCase();
           if (ingredient.isAllergen() && allergies.contains("dairy")) {
               if (dairySubstitutes.containsKey(name)) {
                   System.out.println("Substitute " + name + " with " + dairySubstitutes.get(name) + " (highlighted in yellow)");
               }
           }
       }
   }
}
