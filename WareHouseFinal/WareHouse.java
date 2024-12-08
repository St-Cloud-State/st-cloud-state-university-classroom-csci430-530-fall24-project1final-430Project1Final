import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<String, Product> inventory;

    public Warehouse() {
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return inventory.get(name);
    }

    public void receiveShipment(String productName, int quantity) {
        Product product = inventory.get(productName);
        if (product != null) {
            product.updateQuantity(product.getQuantity() + quantity);
        }
    }
}
