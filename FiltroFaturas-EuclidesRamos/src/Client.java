public class Client {

    private String nome;
    private String data;
    private String estado;

    public Client(String nome, String data, String estado) {
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
