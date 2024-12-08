import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.Queue;

public class Warehouse {
    private Map<String, Product> inventory;
    private Map<String, Queue<WaitItem>> waitlist;

    public Warehouse() {
        inventory = new HashMap<>();
        waitlist = new HashMap<>();
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
            fulfillWaitlist(productName);
        }
    }

    public void fulfillWaitlist(String productName) {
        Queue<WaitItem> queue = waitlist.get(productName);
        if (queue != null && !queue.isEmpty()) {
            while (!queue.isEmpty() && getProduct(productName).getQuantity() > 0) {
                WaitItem waitItem = queue.peek();
                Product product = waitItem.getProduct();
                Client client = waitItem.getClient();

                if (product.getQuantity() >= waitItem.getQuantity()) {
                    product.updateQuantity(product.getQuantity() - waitItem.getQuantity());
                    queue.remove();
                    System.out.println("Fulfilled waitlist for client: " + client.getName() + " for product: " + product.getName());
                }
            }
        }
    }

    public void addToWaitlist(Product product, Client client, int quantity) {
        waitlist.putIfAbsent(product.getName(), new LinkedList<>());
        waitlist.get(product.getName()).add(new WaitItem(product, client, quantity));
        System.out.println("Added client " + client.getName() + " to the waitlist for product: " + product.getName());
    }

    public boolean isProductAvailable(String productName, int quantity) {
        Product product = inventory.get(productName);
        return product != null && product.getQuantity() >= quantity;
    }
}
