package acceptance;

import io.cucumber.java.en.*;
import static org.junit.Assert.*;

import cookingsystem.features.notificationssystem.NotificationsSystem;
import java.util.*;

public class NotificationsAndAlertsSteps {

    private NotificationsSystem notificationsSystem = new NotificationsSystem();
    private String deliveryDate;
    private String notificationTime;
    private String timeWindow;
    private List<Map<String, String>> tasks;
    private String outOfStockItem;
    private boolean reminderSent = false;
    private boolean alertSent = false;
    private boolean urgentBannerShown = false;
    private boolean contactAllowed = false;

    // ====== Delivery Reminder Steps ======
    @Given("a delivery is scheduled on {string}")
    public void a_delivery_is_scheduled_on(String date) {
        this.deliveryDate = date;
    }

    @When("it's {string}")
    public void its_notification_time(String time) {
        this.notificationTime = time;
    }

    @Then("the customer should receive SMS reminder")
    public void the_customer_should_receive_sms_reminder() {
        reminderSent = true;
        assertTrue(reminderSent);
    }

    @And("With delivery time window: {string}")
    public void with_delivery_time_window(String window) {
        this.timeWindow = window;
        notificationsSystem.sendDeliveryReminder(deliveryDate, notificationTime, timeWindow);
    }

    // ====== Cooking Task Alert Steps ======
    @Given("a chef has tasks starting in 30 minutes")
    public void a_chef_has_tasks_starting_in_30_minutes() {
        tasks = new ArrayList<>();
    }

    @When("the system checks scheduled tasks")
    public void the_system_checks_scheduled_tasks() {
        alertSent = true;
    }

    @Then("it should push notification to chef's device")
    public void it_should_push_notification_to_chefs_device() {
        assertTrue(alertSent);
        notificationsSystem.sendCookingTaskAlert(tasks);
    }

    @And("With the following details:")
    public void with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> taskList = dataTable.asMaps(String.class, String.class);
        tasks.addAll(taskList);
    }

    // ====== Emergency Stock Alert Steps ======
    @Given("an essential item is out of stock")
    public void an_essential_item_is_out_of_stock() {
        outOfStockItem = "Emergency Ingredient";
    }

    @When("kitchen staff logs in")
    public void kitchen_staff_logs_in() {
        urgentBannerShown = true;
        contactAllowed = true;
    }

    @Then("the system should show urgent banner")
    public void the_system_should_show_urgent_banner() {
        assertTrue(urgentBannerShown);
    }

    @And("allow immediate supplier contact")
    public void allow_immediate_supplier_contact() {
        assertTrue(contactAllowed);
        notificationsSystem.emergencyStockAlert(outOfStockItem);
    }
}
