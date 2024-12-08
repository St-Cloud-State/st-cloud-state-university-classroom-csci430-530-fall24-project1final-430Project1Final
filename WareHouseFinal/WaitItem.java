public class WaitItem {
    private Product product;
    private Client client;

    public WaitItem(Product product, Client client) {
        this.product = product;
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "WaitItem{product=" + product + ", client=" + client + "}";
    }
}
