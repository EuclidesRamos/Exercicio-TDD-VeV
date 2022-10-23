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
            } else if (fatura.getValor() > 4000 && getRegiao(this.clientController.getClient(fatura.getCliente()).getEstado()).equals("Sul")) {
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

    private String getRegiao(String estado) {
        List<String> centroOeste = new ArrayList<String>();
        List<String> nordeste = new ArrayList<String>();
        List<String> norte = new ArrayList<String>();
        List<String> sudeste = new ArrayList<String>();
        List<String> sul = new ArrayList<String>();

        centroOeste.addAll(List.of(new String[]{"goiás", "mato grosso", "mato grosso do sul"}));
        nordeste.addAll(List.of(new String[]{"alagoas", "bahia", "ceará", "maranhão", "paraíba", "pernambuco", "piauí", "rio grande do norte", "sergipe"}));
        norte.addAll(List.of(new String[]{"acre", "amazonas", "amapá", "pará", "rondônia", "roraima", "tocantins"}));
        sudeste.addAll(List.of(new String[]{"espírito santo", "minas gerais", "rio de janeiro", "são paulo"}));
        sul.addAll(List.of(new String[]{"paraná", "rio grande do sul", "santa catarina"}));

        if (centroOeste.contains(estado.toLowerCase())) {
            return "Centro-Oeste";
        } else if (nordeste.contains(estado.toLowerCase())) {
            return "Nordeste";
        } else if (norte.contains(estado.toLowerCase())) {
            return "Norte";
        } else if (sudeste.contains(estado.toLowerCase())) {
            return "Sudeste";
        } else if (sul.contains(estado.toLowerCase())) {
            return "Sul";
        } else {
            return "";
        }
    }
}
