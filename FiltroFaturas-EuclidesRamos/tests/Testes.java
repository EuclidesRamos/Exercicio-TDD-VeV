import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testes {

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
        FiltroFaturas filtro = new FiltroFaturas();
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtro.filtrar(faturas).size());
    }

    @Test
    public void assertFiltraFaturasComValorEntreDeDoisMilEDoisMilEQuinhentos() throws ParseException {
        Client client = new Client("Olavo", "22/05/2022", "Paraíba");
        Fatura fatura = new Fatura(2200, "30/10/2022", client.getGuid());
        FiltroFaturas filtro = new FiltroFaturas();
        Fatura[] faturas = new Fatura[]{fatura};

        assertEquals(0, filtro.filtrar(faturas).size());
    }
}