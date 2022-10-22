import java.util.*;

public class FiltroFaturas {

    private ClientController clientController;

    public FiltroFaturas(ClientController clientController) {
        this.clientController = clientController;
    }

    public List<Fatura> filtrar(Fatura[] faturas) {
        List<Fatura> result = new ArrayList<>(Arrays.asList(faturas));
        for (Fatura fatura : faturas) {
            if (fatura.getValor() < 2000) {
                result.remove(fatura);
            } else if (fatura.getValor() > 2000 && fatura.getValor() < 2500 && calculaTempo(fatura.getData()) <= 30) {
                result.remove(fatura);
            } else if (fatura.getValor() > 2500 && fatura.getValor() < 3000 && calculaTempo(this.clientController.getClient(fatura.getCliente()).getData()) <= 60) {
                result.remove(fatura);
            }
        }

        return result;
    }

    private double calculaTempo(Date data) {
        Date hoje = new Date();
        GregorianCalendar dataHojeCalendar = new GregorianCalendar();
        GregorianCalendar dataCalendar = new GregorianCalendar();

        dataHojeCalendar.setTime(hoje);
        dataCalendar.setTime(data);

        int diaHoje = dataHojeCalendar.get(Calendar.DAY_OF_YEAR);
        int diaData = dataCalendar.get(Calendar.DAY_OF_YEAR);

        return diaHoje - diaData;
    }
}
