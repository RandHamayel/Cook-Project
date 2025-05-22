package cookingsystem;

import java.util.Scanner;

public class Chef extends User {
   public Chef(String username, String password) {
        super(username, password, "Chef");
    }

    public void approveDish(Dish dish) {
        System.out.println("Reviewing customized dish:");
        dish.printIngredients();
        System.out.println("Substitutions approved. Notification sent to customer.");
    }
    public void showMenu(Scanner sc) {
        Dish sampleDish = Dish.sampleDish("salad");
        System.out.println("\n--- CHEF MENU ---");
        System.out.println("1. Approve Custom Dish");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
        int choice = sc.nextInt(); sc.nextLine();

        switch (choice) {
            case 1:
                approveDish(sampleDish);
                break;
            case 0:
                System.out.println("Goodbye!");
                return;
        }
        showMenu(sc);
    }
}
