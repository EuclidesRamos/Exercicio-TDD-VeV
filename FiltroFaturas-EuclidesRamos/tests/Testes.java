import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {

    @Test
    public void assertCreateCliente() {
        Cliente cliente = new Cliente("Olavo", "22/05/2022", "Paraíba");

        assertEquals("Olavo", cliente.getNome());
    }
}