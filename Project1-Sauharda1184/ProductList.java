import java.util.List;
import java.util.ArrayList;

public class ProductList {
    private List<Product> products;

    public ProductList() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null; // Product not found
    }

    public List<Product> getProducts() {
        return products;
    }

    public boolean isProductAvailable(String productName, int quantity) {
        Product product = getProduct(productName);
        return product != null && product.getQuantity() >= quantity;
    }

    @Override
    public String toString() {
        return products.toString();
    }
}
