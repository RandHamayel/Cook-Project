package cookingsystem;

abstract class User {
    private String username;
    private String password;
    private String role; // Customer, Chef, Admin

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() { return username; }
    public String getRole() { return role; }

    public boolean checkPassword(String pass) {
        return password.equals(pass);
    }
}
