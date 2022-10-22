import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class ClientController {

    private Map<String, Client> clients;

    public ClientController() {
        clients = new HashMap();
    }

    public void criaClient(String nome, String data, String estado) {
        try {
            Client client = new Client(nome, data, estado);
            clients.put(client.getGuid(), client);
        } catch (ParseException exception) {
            System.out.println(exception);
        }
    }
}
