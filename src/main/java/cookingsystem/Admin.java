
package cookingsystem;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, "admin");
    }

 
    public void showMenu() {
        System.out.println("\n-- Admin Menu --");
        System.out.println("1. View All Users");
        System.out.println("2. Analyze Order Data");
        System.out.println("3. Logout");
        // Implement admin operations here
    }
}