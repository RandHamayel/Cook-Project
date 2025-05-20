package cookingsystem.features.notificationssystem;

import java.time.LocalDateTime;
import java.util.*;

public class NotificationsSystem {

    // تمثيل التذكير بموعد التسليم
    public void sendDeliveryReminder(String deliveryDate, String notificationTime, String timeWindow) {
        System.out.println("Sending SMS reminder:");
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Notification Time: " + notificationTime);
        System.out.println("Delivery Time Window: " + timeWindow);
    }

    // تمثيل تنبيه المهام للطهاة قبل 30 دقيقة
    public void sendCookingTaskAlert(List<Map<String, String>> tasks) {
        System.out.println("Pushing notifications to chef's device with upcoming tasks:");
        for (Map<String, String> task : tasks) {
            System.out.println("Meal: " + task.get("Meal Name") + ", Preparation Time: " + task.get("Preparation Time"));
        }
    }

    // تمثيل تنبيه نفاد المخزون الطارئ
    public void emergencyStockAlert(String item) {
        System.out.println("URGENT: Item out of stock - " + item);
        System.out.println("Showing urgent banner and allowing immediate supplier contact...");
    }
}
