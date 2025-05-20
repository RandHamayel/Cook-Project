package cookingsystem.features.customerprofile;

public class Chef {

    public void viewCustomerPreferences(Customer customer) {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Dietary Preference: " + customer.getDietaryPreference());
        System.out.println("Allergies (highlighted in red):");
        for (String allergy : customer.getAllergies()) {
            System.out.println("\u001B[31m" + allergy + "\u001B[0m");  // ANSI red text
        }
    }
}
