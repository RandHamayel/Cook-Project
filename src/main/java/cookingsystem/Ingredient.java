package cookingsystem;

public class Ingredient {
    private String name;
    private boolean isAllergen;

    public Ingredient(String name, boolean isAllergen) {
        this.name = name;
        this.isAllergen = isAllergen;
    }

    public String getName() {
        return name;
    }

    public boolean isAllergen() {
        return isAllergen;
    }
}
