import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fatura {

    private int codigo;
    private int valor;
    private Date data;
    private String cliente;

    public Fatura(int valor, String data, String cliente) throws ParseException {
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        this.codigo = 123;
        this.valor = valor;
        this.data = formataData.parse(data);
        this.cliente = cliente;
    }

    public String getCliente() {
        return this.cliente;
    }

    public int getValor() {
        return this.valor;
    }

    public Date getData() {
        return data;
    }
}
