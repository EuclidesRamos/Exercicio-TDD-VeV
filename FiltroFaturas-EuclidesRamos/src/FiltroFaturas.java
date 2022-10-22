import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FiltroFaturas {
    public List<Fatura> filtrar(Fatura[] faturas) {
        List<Fatura> result = new ArrayList<>(Arrays.asList(faturas));
        for (Fatura fatura : faturas) {
            if (fatura.getValor() < 2000) {
                result.remove(fatura);
            } else if (fatura.getValor() > 2000 && fatura.getValor() < 2500 && calculaTempo(fatura) <= 30) {
                result.remove(fatura);
            }
        }

        return result;
    }

    private double calculaTempo(Fatura fatura) {
        Date hoje = new Date();
        GregorianCalendar dataHoje = new GregorianCalendar();
        GregorianCalendar dataFatura = new GregorianCalendar();
        
        dataHoje.setTime(hoje);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        
        try {
            data = sdf.parse(fatura.getData());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dataFatura.setTime(data);

        int diaHoje = dataHoje.get(Calendar.DAY_OF_YEAR);
        int diaFatura = dataFatura.get(Calendar.DAY_OF_YEAR);

        return diaHoje - diaFatura;
    }
}
