import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {

    private FiltroFaturas filtroFaturas;
    private ClientController clientController;

    @BeforeEach
    public void before() {
        this.clientController = new ClientController();
        clientController.criaClient("Olavo", "22/05/2022", "Paraíba");
        this.filtroFaturas = new FiltroFaturas(clientController);
    }

    @Test
    public void assertCreateClient() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");

        assertEquals("Olavo", client.getNome());
    }

    @Test
    public void assertCreateFatura() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(150, "30/10/2022", client.getGuid());

        assertEquals(client.getGuid(), fatura.getCliente());
    }

    @Test
    public void assertFiltraFaturasComValorAbaixoDeDoisMil() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(150, "30/10/2022", client.getGuid());
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraFaturasComValorEntreDoisMilEDoisMilEQuinhentos() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(2200, "30/10/2022", client.getGuid());
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraFaturasComValorEntreDoisMilEQuinhentosETresMil() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(2800, "30/10/2022", client.getGuid());
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }
}