import java.util.*;

public class ClientList {
  private List<Client> clients = new LinkedList<>();
  private static ClientList clientList;

  private ClientList() {
  }

  public static ClientList instance() {
    if (clientList == null) {
      return (clientList = new ClientList());
    } else {
      return clientList;
    }
  }

  public boolean insertClient(Client client) {
    clients.add(client);
    return true;
  }

  public Iterator<Client> getClients() {
    return clients.iterator();
  }

  public String toString() {
    return clients.toString();
  }
}