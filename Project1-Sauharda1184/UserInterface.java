import java.util.Scanner;

public class UserInterface {
    private ClientList clientList;
    private ProductList productList;
    private Warehouse warehouse;

    public UserInterface(ClientList clientList, ProductList productList, Warehouse warehouse) {
        this.clientList = clientList;
        this.productList = productList;
        this.warehouse = warehouse;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Client");
            System.out.println("2. Add Product");
            System.out.println("3. Display Clients");
            System.out.println("4. Display Products");
            System.out.println("5. Add Item to Wishlist");
            System.out.println("6. Display Wishlist");
            System.out.println("7. Place Order");
            System.out.println("8. Record Payment");
            System.out.println("9. Receive Shipment");
            System.out.println("10. Print All Invoices");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter client name: ");
                    String clientName = scanner.nextLine();
                    clientList.addClient(new Client(clientName));
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    productList.addProduct(new Product(productName, quantity, price));
                    break;
                case 3:
                    System.out.println(clientList);
                    break;
                case 4:
                    System.out.println(productList);
                    break;
                case 5:
                    System.out.print("Enter client name: ");
                    String clientNameForWishlist = scanner.nextLine();
                    Client client = clientList.getClient(clientNameForWishlist);
                    if (client != null) {
                        System.out.print("Enter product name to add to wishlist: ");
                        String productNameForWishlist = scanner.nextLine();
                        System.out.print("Enter quantity: ");
                        int wishQuantity = scanner.nextInt();
                        Product productForWishlist = productList.getProduct(productNameForWishlist);
                        if (productForWishlist != null && warehouse.isProductAvailable(productForWishlist.getName(), wishQuantity)) {
                            client.addToWishlist(productForWishlist, wishQuantity);
                            System.out.println("Product added to wishlist.");
                        } else {
                            warehouse.addToWaitlist(productForWishlist, client, wishQuantity);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Wishlist:");
                    System.out.println(clientList.getClients());
                    break;
                case 7:
                    System.out.print("Enter client name to place order: ");
                    String clientNameForOrder = scanner.nextLine();
                    Client orderClient = clientList.getClient(clientNameForOrder);
                    if (orderClient != null) {
                        placeOrder(orderClient);
                    }
                    break;
                case 8:
                    System.out.print("Enter client name to record payment: ");
                    String clientNameForPayment = scanner.nextLine();
                    Client paymentClient = clientList.getClient(clientNameForPayment);
                    if (paymentClient != null) {
                        System.out.print("Enter payment amount: ");
                        double paymentAmount = scanner.nextDouble();
                        paymentClient.addBalance(paymentAmount);
                        System.out.println("Payment recorded.");
                    }
                    break;
                case 9:
                    System.out.print("Enter product name to receive shipment: ");
                    String productNameForShipment = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int shipmentQuantity = scanner.nextInt();
                    warehouse.receiveShipment(productNameForShipment, shipmentQuantity);
                    break;
                case 10:
                    printInvoices();
                    break;
                case 11:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void placeOrder(Client client) {
        Invoice invoice = new Invoice(client);
        double totalOrderCost = 0.0;
        for (WishItem wishItem : client.getWishlist()) {
            Product product = wishItem.getProduct();
            int quantity = wishItem.getQuantity();
            if (product.getQuantity() >= quantity) {
                product.updateQuantity(product.getQuantity() - quantity);
                totalOrderCost += product.getPrice() * quantity;
                invoice.addItem(wishItem);
            } else {
                warehouse.addToWaitlist(product, client, quantity);
            }
        }
        if (totalOrderCost <= client.getBalance()) {
            client.subtractBalance(totalOrderCost);
            client.addInvoice(invoice);
            client.getWishlist().clear();
            System.out.println("Order placed successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void printInvoices() {
        for (Client client : clientList.getClients()) {
            System.out.println("Invoices for " + client.getName() + ":");
            for (Invoice invoice : client.getInvoices()) {
                System.out.println(invoice);
            }
        }
    }

    public static void main(String[] args) {
        ClientList clientList = new ClientList();
        ProductList productList = new ProductList();
        Warehouse warehouse = new Warehouse();
        UserInterface ui = new UserInterface(clientList, productList, warehouse);
        ui.displayMenu();
    }
}
