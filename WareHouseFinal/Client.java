public class Client {
    private String name;
    private double balance;

    public Client(String name) {
        this.name = name;
        this.balance = 0.0;
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

    @Override
    public String toString() {
        return "Client{name='" + name + "', balance=" + balance + '}';
    }
}
