public class WaitItem {
    private Product product;
    private Client client;
    private int quantity;

    public WaitItem(Product product, Client client, int quantity) {
        this.product = product;
        this.client = client;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    public int getQuantity() {  // Added getter for quantity
        return quantity;
    }

    @Override
    public String toString() {
        return "WaitItem{product=" + product + ", client=" + client + ", quantity=" + quantity + "}";
    }
}
