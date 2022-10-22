import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {

    @Test
    public void assertCreateClient() {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");

        assertEquals("Olavo", client.getNome());
    }
}