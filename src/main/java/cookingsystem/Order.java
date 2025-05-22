package cookingsystem;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

class Order {
    private Date date;
    private List<String> items;
    private double totalPrice;

    public Order(Date date, List<String> items, double totalPrice) {
        this.date = date;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public Date getDate() { return date; }
    public List<String> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("%s | %-25s | $%.2f", sdf.format(date), String.join(", ", items), totalPrice);
    }
}
