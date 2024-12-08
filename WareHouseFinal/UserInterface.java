import java.util.Scanner;

public class UserInterface {
    private ClientList clientList;
    private ProductList productList;

    public UserInterface(ClientList clientList, ProductList productList) {
        this.clientList = clientList;
        this.productList = productList;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Client");
            System.out.println("2. Add Product");
            System.out.println("3. Display Clients");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
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
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        ClientList clientList = new ClientList();
        ProductList productList = new ProductList();
        UserInterface ui = new UserInterface(clientList, productList);
        ui.displayMenu();
    }
}
