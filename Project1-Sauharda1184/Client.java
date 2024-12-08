import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private double balance;
    private List<WishItem> wishlist;
    private List<Invoice> invoices;

    public Client(String name) {
        this.name = name;
        this.balance = 0.0;
        this.wishlist = new ArrayList<>();
        this.invoices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void subtractBalance(double amount) {
        balance -= amount;
    }

    public List<WishItem> getWishlist() {
        return wishlist;
    }

    public void addToWishlist(Product product, int quantity) {
        wishlist.add(new WishItem(product, quantity));
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', balance=" + balance + ", wishlist=" + wishlist + '}';
    }
}
