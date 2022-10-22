import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FiltroFaturas {
    public List<Fatura> filtrar(Fatura[] faturas) {
        List<Fatura> result = new ArrayList<>(Arrays.asList(faturas));
        for (Fatura fatura : faturas) {
            if (fatura.getValor() < 2000) {
                result.remove(fatura);
            } else if (fatura.getValor() > 2000 && fatura.getValor() < 2500 && calculaTempo(fatura.getData()) <= 30) {
                result.remove(fatura);
            }
        }

        return result;
    }

    private double calculaTempo(String dataString) {
        Date hoje = new Date();
        GregorianCalendar dataHojeCalendar = new GregorianCalendar();
        GregorianCalendar dataCalendar = new GregorianCalendar();

        dataHojeCalendar.setTime(hoje);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date data = null;
        try {
            data = sdf.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataCalendar.setTime(data);

        int diaHoje = dataHojeCalendar.get(Calendar.DAY_OF_YEAR);
        int diaFatura = dataCalendar.get(Calendar.DAY_OF_YEAR);

        return diaHoje - diaFatura;
    }
}
