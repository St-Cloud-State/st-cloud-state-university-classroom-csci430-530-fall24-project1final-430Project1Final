import java.util.ArrayList;
import java.util.List;

public class ClientList {
    private List<Client> clients;

    public ClientList() {
        clients = new ArrayList<>();
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

    public Client getClient(String name) {
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                return client;
            }
        }
        return null; // Client not found
    }

    @Override
    public String toString() {
        return clients.toString();
    }
}
