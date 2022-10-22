import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    private String nome;
    private Date data;
    private String estado;

    public Client(String nome, Date data, String estado) {
        this.nome = nome;
        this.data = data;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public String getGuid() {
        return nome + data;
    }
}
