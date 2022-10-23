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
        this.filtroFaturas = new FiltroFaturas(clientController);
    }

    @Test
    public void assertCreateClient() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");

        assertEquals("Olavo", client.getNome());
    }

    @Test
    public void assertCreateFatura() throws ParseException {
        String clientGuid = clientController.criaClient("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(150, "30/10/2022", clientGuid);

        assertEquals(clientGuid, fatura.getCliente());
    }

    @Test
    public void assertFiltraFaturasComValorAbaixoDeDoisMil() throws ParseException {
        String clientGuid = clientController.criaClient("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(150, "30/10/2022", clientGuid);
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraFaturasComValorEntreDoisMilEDoisMilEQuinhentos() throws ParseException {
        String clientGuid = clientController.criaClient("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(2200, "01/10/2022", clientGuid);
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraFaturasComValorEntreDoisMilEQuinhentosETresMil() throws ParseException {
        String clientGuid = clientController.criaClient("Olavo", "22/09/2022", "Paraíba");
        Fatura fatura = new Fatura(2800, "30/10/2022", clientGuid);
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraFaturasComValorMaiorQueTresMil() throws ParseException {
        String clientGuid = clientController.criaClient("Olavo", "22/09/2022", "Rio Grande do Sul");
        Fatura fatura = new Fatura(4500, "30/10/2022", clientGuid);
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtroFaturas.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraMuitasFaturas() throws ParseException {
        String clientGuidCentroOeste = clientController.criaClient("Olavo", "22/09/2022", "Goiás");
        String clientGuidNordeste = clientController.criaClient("Olavo", "22/09/2022", "Paraíba");
        String clientGuidNorte = clientController.criaClient("Olavo", "22/09/2022", "Acre");
        String clientGuidSudeste = clientController.criaClient("Olavo", "22/09/2022", "Rio de Janeiro");
        String clientGuidSul = clientController.criaClient("Olavo", "22/09/2022", "Paraná");

        Fatura fatura1 = new Fatura(500, "02/08/2022", clientGuidCentroOeste);
        Fatura fatura2 = new Fatura(4100, "22/10/2022", clientGuidNordeste);
        Fatura fatura3 = new Fatura(3000, "22/10/2022", clientGuidNorte);
        Fatura fatura4 = new Fatura(2000, "10/10/2022", clientGuidSudeste);
        Fatura fatura5 = new Fatura(4500, "22/10/2022", clientGuidSul);

        Fatura[] faturas = new Fatura[]{fatura1, fatura2, fatura3, fatura4, fatura5};

        assertEquals(1, filtroFaturas.filtrar(faturas).size());
    }
}