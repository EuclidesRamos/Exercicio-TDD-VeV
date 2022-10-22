import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiltroFaturas {
    public List<Fatura> filtrar(Fatura[] faturas) {
        List<Fatura> result = new ArrayList<>(Arrays.asList(faturas));
        for (Fatura fatura : result) {
            if (fatura.getValor() < 2000) {
                result.remove(fatura);
            }
        }

        return result;
    }
}
