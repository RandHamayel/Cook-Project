package cookingsystem.features.customerprofile;

import java.util.List;

public class OrderHistory {
    private String date;
    private List<String> items;
    private double totalPrice;

    public OrderHistory(String date, List<String> items, double totalPrice) {
        this.date = date;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public List<String> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void displayOrder() {
        System.out.println(date + " | " + String.join(", ", items) + " | $" + totalPrice);
    }
}
