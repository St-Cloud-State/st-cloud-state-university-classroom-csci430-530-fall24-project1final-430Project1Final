public class WishItem {
    private Product product;
    private int quantity;

    public WishItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "WishItem{product=" + product + ", quantity=" + quantity + "}";
    }
}
