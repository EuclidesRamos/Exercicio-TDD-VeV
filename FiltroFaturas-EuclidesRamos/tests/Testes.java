import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {

    @Test
    public void assertCreateClient() {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        assertEquals("Olavo", client.getNome());
    }

    @Test
    public void assertCreateFatura() {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(150, "30/10/2022", client.getGuid());

        assertEquals(client.getGuid(), fatura.getCliente());
    }
}