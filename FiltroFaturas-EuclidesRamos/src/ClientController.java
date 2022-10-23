import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ClientController {

    private Map<String, Client> clients;

    public ClientController() {
        this.clients = new HashMap<>();
    }

    public String criaClient(String nome, String data, String estado) {
        try {
            Client client = new Client(nome, data, estado);
            this.clients.put(client.getGuid(), client);
            return client.getGuid();
        } catch (ParseException exception) {
            System.out.println(exception);
        }
        return null;
    }

    public Client getClient(String clientGuid) {
        return this.clients.get(clientGuid);
    }
}
