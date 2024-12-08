import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private Client client;
    private List<WishItem> items;
    private double totalAmount;

    public Invoice(Client client) {
        this.client = client;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(WishItem item) {
        items.add(item);
        totalAmount += item.getProduct().getPrice() * item.getQuantity();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<WishItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder invoiceDetails = new StringBuilder("Invoice for " + client.getName() + ":\n");
        for (WishItem item : items) {
            invoiceDetails.append(item.getProduct().getName()).append(" - Quantity: ")
                          .append(item.getQuantity()).append(", Price: $")
                          .append(item.getProduct().getPrice()).append("\n");
        }
        invoiceDetails.append("Total Amount: $").append(totalAmount);
        return invoiceDetails.toString();
    }
}
