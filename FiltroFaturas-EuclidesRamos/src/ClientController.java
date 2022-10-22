import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class ClientController {

    private Map<String, Client> clients;

    public ClientController() {
        clients = new HashMap();
    }

    public void criaClient(String nome, String data, String estado) {
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Client client = new Client(nome, formataData.parse(data), estado);
            clients.put(client.getGuid(), client);
        } catch (ParseException exception) {
            System.out.println(exception);
        }
    }
}
