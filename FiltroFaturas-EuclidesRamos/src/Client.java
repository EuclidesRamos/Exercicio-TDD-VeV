import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Client {

    private UUID guid;
    private String nome;
    private Date data;
    private String estado;

    public Client(String nome, String data, String estado) throws ParseException {
        SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
        this.guid = UUID.randomUUID();
        this.nome = nome;
        this.data = formataData.parse(data);
        this.estado = estado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getGuid() {
        return this.guid.toString();
    }

    public Date getData() {
        return this.data;
    }

    public String getEstado() {
        return this.estado;
    }
}
