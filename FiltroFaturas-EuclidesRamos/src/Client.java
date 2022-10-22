import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    private String nome;
    private Date data;
    private String estado;

    public Client(String nome, String data, String estado) throws ParseException {
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        this.nome = nome;
        this.data = formataData.parse(data);
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getGuid() {
        return nome + data;
    }
}
