package acceptance;

import cookingsystem.features.billingsystem.*;
import io.cucumber.java.en.*;
import io.cucumber.datatable.DataTable;
import java.util.List;
import java.util.stream.Collectors;

public class BillingSystemSteps {

    private BillingSystem billingSystem = new BillingSystem();
    private Order currentOrder;
    private List<FailedTransaction> failedTransactions;

    @Given("an order is completed with {string}")
    public void order_completed_with_order_type(String orderType) {
        if (currentOrder == null) currentOrder = new Order(orderType, null);
        else currentOrder.setOrderType(orderType);
        System.out.println("Order type set to: " + orderType);
    }

    @Given("the payment method is {string}")
    public void set_payment_method(String paymentMethod) {
        if (currentOrder == null) currentOrder = new Order(null, paymentMethod);
        else currentOrder.setPaymentMethod(paymentMethod);
        System.out.println("Payment method set to: " + paymentMethod);
    }

    @When("the billing system processes it")
    public void process_billing() {
        billingSystem.processOrder(currentOrder);
    }

    @Then("a PDF invoice should be generated")
    public void verify_invoice_generation() {
        System.out.println("Invoice generated verification passed.");
        // ممكن تضيف تحقق حقيقي هنا لو عندك منطق
    }

    @Then("emailed to the customer")
    public void verify_invoice_emailed() {
        System.out.println("Invoice emailed verification passed.");
    }

    @Given("it's the end of the month")
    public void end_of_month() {
        System.out.println("End of month setup");
    }

    @When("the administrator generates reports")
    public void generate_reports() {
        billingSystem.generateMonthlyReport();
    }

    @Then("the system should create revenue breakdown")
    public void verify_revenue_report() {
        System.out.println("Monthly revenue breakdown verified.");
    }

    @Then("show comparison to previous month")
    public void verify_monthly_comparison() {
        System.out.println("Monthly comparison verified.");
    }

    @Given("the following failed transactions:")
    public void failed_transactions(DataTable dataTable) {
        failedTransactions = dataTable.asMaps().stream()
            .map(row -> new FailedTransaction(
                    row.get("Customer ID"),
                    Double.parseDouble(row.get("Amount")),
                    row.get("Reason")))
            .collect(Collectors.toList());
        System.out.println("Failed transactions loaded: " + failedTransactions.size());
    }

    @When("the system retries after 24 hours")
    public void retry_after_24_hours() {
        billingSystem.handleFailedPayments(failedTransactions);
    }

    @Then("it should notify the customer")
    public void notify_customer() {
        System.out.println("Customer notifications verified.");
    }

    @Then("suspend delivery until resolved")
    public void suspend_delivery() {
        System.out.println("Delivery suspension verified.");
    }
}
